package p2entity;

import java.util.Optional;

public class KeyboardButtonEntity {

    private String keyboardButtonName;
    private Optional<Integer> userId = Optional.empty();
    private Optional<ControlButton> controlButton = Optional.empty();

    private KeyboardButtonEntity(){
    }

    public String name() {
        return keyboardButtonName;
    }

    public Optional<Integer> getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = Optional.ofNullable(userId);
    }

    public Optional<ControlButton> getControlButton() {
        return controlButton;
    }

    public void setControlButton(ControlButton controlButton) {
        this.controlButton = Optional.ofNullable(controlButton);
    }

    public boolean isUsed() {
        return userId.isPresent() && controlButton.isPresent();
    }

    public static KeyboardButtonEntity build(String button, Integer userId, String userButton) {
        KeyboardButtonEntity keyboardButton = new KeyboardButtonEntity();
        keyboardButton.keyboardButtonName = button;
        keyboardButton.setUserId(userId);
        Optional<String> stringOptional = Optional.ofNullable(userButton);
        stringOptional.ifPresent(key -> keyboardButton.setControlButton(ControlButton.valueOf(userButton)));
        return keyboardButton;
    }

    public static KeyboardButtonEntity build(String button, Integer userId, ControlButton userButton) {
        KeyboardButtonEntity keyboardButton = new KeyboardButtonEntity();
        keyboardButton.keyboardButtonName = button;
        keyboardButton.setUserId(userId);
        keyboardButton.setControlButton(userButton);
        return keyboardButton;
    }
}
