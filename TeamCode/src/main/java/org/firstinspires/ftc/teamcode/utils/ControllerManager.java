// Java file to centralize button states
package org.firstinspires.ftc.teamcode.utils;

// Imports
import org.firstinspires.ftc.teamcode.common.ButtonState;
import org.firstinspires.ftc.teamcode.enums.ButtonEnum;

import java.util.EnumMap;
import java.util.Map;


// Java class to create the button state map
public class ControllerManager {
    // Variable to store all button states
    private Map<ButtonEnum, ButtonState> buttonStateMap = new EnumMap<>(ButtonEnum.class);


    // Constructor to create and update the buttonStateMap
    public ControllerManager() {
        for (ButtonEnum button : ButtonEnum.values()) {
            buttonStateMap.put(button, new ButtonState(false));
        }
    }

    // Functions for handling the retuning button state
    public void update(ButtonEnum buttonEnum, boolean state) { this.buttonStateMap.get(buttonEnum).update(state); }
    public boolean wasPressed(ButtonEnum buttonEnum) { return this.buttonStateMap.get(buttonEnum).wasPressed(); }
    public boolean wasReleased(ButtonEnum buttonEnum) { return this.buttonStateMap.get(buttonEnum).wasReleased(); }
    public boolean isToggled(ButtonEnum buttonEnum) { return this.buttonStateMap.get(buttonEnum).isToggled(); }
}

// This file was made by dev-verexxed, completed at: [24/06/2026] [10:58]
