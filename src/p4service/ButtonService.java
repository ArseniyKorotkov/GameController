package p4service;

import p2entity.ControlButton;
import p2entity.KeyboardButtonEntity;
import p3dao.ControlPanelDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class ButtonService {

    private static final ButtonService BUTTON_SERVICE = new ButtonService();

    private ButtonService() {
    }

    private final ControlPanelDao controlPanelDao = ControlPanelDao.getInstance();
    private final UserService userService = UserService.getInstance();
    private HashSet<KeyboardButtonEntity> keyboardButtons;

    public ArrayList<KeyboardButtonEntity> getKeyboardButtonsArray() {
        return controlPanelDao.getAllButtonsValue();
    }

    public ArrayList<String[]> saveConsoleButtonsValues(HashSet<KeyboardButtonEntity> keyboardButtons) {
        ArrayList<String[]> responseArray = new ArrayList<>();

        for (KeyboardButtonEntity installedKey : keyboardButtons) {
            System.out.println(installedKey.getControlButton() + " lalala2");
        }

        for (KeyboardButtonEntity installedKey : keyboardButtons) {
            System.out.println(installedKey.getControlButton() + " lalala  " + installedKey.name());
            //who now is owner for this button
            Optional<Integer> keyOwnerId = controlPanelDao.getKeyUserId(installedKey.name());

            if (installedKey.getUserId().isPresent() && keyOwnerId.isPresent()
                && keyOwnerId.get() != 0 && !installedKey.getUserId().equals(keyOwnerId)
                && userService.isUserConnectById(keyOwnerId.get()).isPresent()) {

                String keyOwnerName = userService.isUserConnectById(keyOwnerId.get()).get();
                responseArray.add(new String[]{"Button " + installedKey.name().substring(3),
                        "   is busy from '" + keyOwnerName + "' player"});
                System.out.println(installedKey.getUserId().get());     /*****/
                System.out.println(keyOwnerId.get());        /*****/
                System.out.println("nonono");               /******/
                System.out.println("---------");

            } else {

                Optional<KeyboardButtonEntity> lastButtonName = controlPanelDao.getButtonValue
                        (installedKey.getUserId().get(), installedKey.getControlButton().get());
                if (lastButtonName.isPresent()) {
                    System.out.println(lastButtonName.get().name() + " old name"); /********/
                    controlPanelDao.deleteButtonValue(lastButtonName.get().name());
                    System.out.println("pred Ok");                                      /*******/
                }
                responseArray.add(new String[]{"Button " + installedKey.name().substring(3),
                        "   is installed like " + installedKey.getControlButton().get()});
                System.out.println(keyOwnerId.get() + " hfhfhfhf");/*****/
                System.out.println("OK"); /********/
                controlPanelDao.setButtonValue(installedKey);
            }
        }
        System.out.println("**************************************");
        return responseArray;
    }

    public Optional<KeyboardButtonEntity> getButtonValue(Integer userId, String controlButton) {
        return controlPanelDao.getButtonValue(userId, ControlButton.valueOf(controlButton));
    }



    public static ButtonService getInstance() {
        return BUTTON_SERVICE;
    }

}












