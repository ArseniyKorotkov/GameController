package p4service;

import p2entity.KeyboardButton;
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

    public ArrayList<KeyboardButtonEntity> getKeyboardButtons() {
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


    public static ButtonService getInstance() {
        return BUTTON_SERVICE;
    }

/*    public static void main(String[] args) {
        HashSet<KeyboardButton> testHash = new HashSet<>();
        ButtonService service = ButtonService.getInstance();

        testHash.add(KeyboardButton.build("VK_1", 2, ControlButton.BUTTON_A));
        testHash.add(KeyboardButton.build("VK_5", 2, ControlButton.BUTTON_B));
        testHash.add(KeyboardButton.build("VK_3", 2, ControlButton.BUTTON_C));
        testHash.add(KeyboardButton.build("VK_4", 2, ControlButton.BUTTON_D));
        testHash.add(KeyboardButton.build("VK_2", 2, ControlButton.BUTTON_E));
        testHash.add(KeyboardButton.build("VK_6", 2, ControlButton.BUTTON_F));
        testHash.add(KeyboardButton.build("VK_0", 2, ControlButton.BUTTON_UP));
        testHash.add(KeyboardButton.build("VK_8", 2, ControlButton.BUTTON_DOWN));
        testHash.add(KeyboardButton.build("VK_9", 2, ControlButton.BUTTON_LEFT));
        testHash.add(KeyboardButton.build("VK_7", 2, ControlButton.BUTTON_RIGHT));

        service.saveConsoleButtonsValues(testHash);
    }*/

}












