package p4service;

import p2entity.ControlButton;
import p2entity.KeyboardButtonEntity;
import p3dao.ControlPanelDao;
import p8exception.OptionalNullException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class ButtonService {

    private static final ButtonService BUTTON_SERVICE = new ButtonService();

    private ButtonService() {
    }

    private final ControlPanelDao controlPanelDao = ControlPanelDao.getInstance();
    private final UserService userService = UserService.getInstance();

    public ArrayList<KeyboardButtonEntity> getKeyboardButtonsArray() {
        return controlPanelDao.getAllButtonsValue();
    }

    public ArrayList<String[]> saveConsoleButtonsValues(HashSet<KeyboardButtonEntity> keyboardButtons) {
        ArrayList<String[]> responseArray = new ArrayList<>();

        for (KeyboardButtonEntity installedKey : keyboardButtons) {
            //who now is owner for this button
            Optional<Integer> keyOwnerId = controlPanelDao.getKeyUserId(installedKey.name());

            if (installedKey.getUserId().isPresent() && keyOwnerId.isPresent()
                && keyOwnerId.get() != 0 && !installedKey.getUserId().equals(keyOwnerId)
                && userService.isUserConnectById(keyOwnerId.get()).isPresent()) {

                String keyOwnerName = userService.isUserConnectById(keyOwnerId.get()).get();
                responseArray.add(new String[]{"Button " + installedKey.name().substring(3),
                        "   is busy from '" + keyOwnerName + "' player"});

            } else if(installedKey.getUserId().isPresent() && installedKey.getControlButton().isPresent()) {

                Optional<KeyboardButtonEntity> lastButtonName = controlPanelDao.getButtonValue
                        (installedKey.getUserId().get(), installedKey.getControlButton().get());

                lastButtonName.ifPresent(keyboardButtonEntity ->
                        controlPanelDao.deleteButtonValue(keyboardButtonEntity.name()));

                responseArray.add(new String[]{"Button " + installedKey.name().substring(3),
                        "   is installed like " + installedKey.getControlButton().get()});
                controlPanelDao.setButtonValue(installedKey);
            } else {
                throw new OptionalNullException(KeyboardButtonEntity.class);
            }
        }
        return responseArray;
    }

    public void deleteConsoleValuesFor(int userId) {
        controlPanelDao.deleteConsoleValuesFor(userId);
    }

    public Optional<KeyboardButtonEntity> getButtonValue(Integer userId, String controlButton) {
        return controlPanelDao.getButtonValue(userId, ControlButton.valueOf(controlButton));
    }



    public static ButtonService getInstance() {
        return BUTTON_SERVICE;
    }

}












