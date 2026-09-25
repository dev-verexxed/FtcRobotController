// Java file for creating a storing a button state
package org.firstinspires.ftc.teamcode.common;


// Class to create the object of the button state
public class ButtonState {
    // Variables that store the state of a button
    private boolean pastState;
    private boolean currentState;
    private boolean toggled;


    // Constructor to initialize the button state
    public ButtonState(boolean state) {
        update(state);
    }

    // Functions for handling button states
    public void update(boolean state) {
        this.pastState = currentState;
        this.currentState = state;

        if (this.wasPressed()) { this.toggled = !toggled; }
    }
    public boolean wasPressed() { return this.currentState && !this.pastState; }
    public boolean wasReleased() { return !this.currentState && this.pastState; }
    public boolean isToggled() { return this.toggled; }
}

// This file was made by dev-verexxed, completed at: [24/06/2026] [10:48]
