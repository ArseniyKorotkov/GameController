package p2entity;

import java.util.HashMap;

public class ControlPanel {

    private static final HashMap<ControlButton, KeyboardButton> buttonsValue = new HashMap<>();

    static {
        buttonsValue.put(ControlButton.BUTTON_UP, null);
        buttonsValue.put(ControlButton.BUTTON_DOWN, null);
        buttonsValue.put(ControlButton.BUTTON_LEFT, null);
        buttonsValue.put(ControlButton.BUTTON_RIGHT, null);
        buttonsValue.put(ControlButton.BUTTON_A, null);
        buttonsValue.put(ControlButton.BUTTON_B, null);
        buttonsValue.put(ControlButton.BUTTON_C, null);
        buttonsValue.put(ControlButton.BUTTON_D, null);
        buttonsValue.put(ControlButton.BUTTON_E, null);
        buttonsValue.put(ControlButton.BUTTON_F, null);
    }

    public void setButtonValue(ControlButton button, KeyboardButton value) {
        buttonsValue.put(button, value);
    }

    public KeyboardButton getButtonValue(ControlButton button, KeyboardButton value) {
        return buttonsValue.get(button);
    }
}
