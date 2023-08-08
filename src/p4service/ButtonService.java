package p4service;

import p2entity.KeyboardButton;
import p3dao.ControlPanelDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class ButtonService {

    private static final ButtonService BUTTON_SERVICE = new ButtonService();


    private ButtonService() {
    }

    private final ControlPanelDao controlPanelDao = ControlPanelDao.getInstance();


    public ArrayList<KeyboardButton> getKeyboardButtons() {
        return controlPanelDao.getAllButtonsValue();
    }

    public boolean saveConsoleButtonsValues(HashSet<KeyboardButton> keyboardButtons) {
        boolean isSave = true;

        for (KeyboardButton installedKey : keyboardButtons) {
            Optional<Integer> keyUserId = controlPanelDao.getKeyUserId(installedKey.name());
            if (installedKey.getUserId().isPresent() && keyUserId.isPresent()
                && keyUserId.get() != 0 && !installedKey.getUserId().equals(keyUserId)) {
                System.out.println(installedKey.getUserId().get());
                System.out.println(keyUserId.get());
                System.out.println("nonono");
                isSave = false;
            } else {
                Optional<KeyboardButton> lastButtonName = controlPanelDao.getButtonValue
                        (installedKey.getUserId().get(), installedKey.getControlButton().get());
                if (lastButtonName.isPresent()) {
                    System.out.println(lastButtonName.get().name() + " old name");
                    controlPanelDao.deleteButtonValue(lastButtonName.get().name());
                    System.out.println("pred Ok");
                }
                System.out.println(keyUserId.get() + " hfhfhfhf");
                System.out.println("OK");
                controlPanelDao.setButtonValue(installedKey);
            }

        }

        return isSave;
    }


    public static ButtonService getInstance() {
        return BUTTON_SERVICE;
    }

}
