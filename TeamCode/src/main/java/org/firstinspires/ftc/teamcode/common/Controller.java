// Java file to centralize user input
package org.firstinspires.ftc.teamcode.common;

// Imports
import com.qualcomm.robotcore.hardware.Gamepad;


// Java class to access values returned by gamepads
public class Controller {
    // Variable to apply a dead zone to any values that return a value between -1 to 1
    private static final double DEAD_ZONE = 0.05;
    // Variable to store the gamepad
    private final Gamepad gamepad;


    // Constructor to set the gamepad object to the gamepad variable
    public Controller(Gamepad gamepad) { this.gamepad = gamepad; }

    // Function that applies a dead zone to values
    private double applyDeadZone(double value) {
        if (Math.abs(value) < DEAD_ZONE) { return 0.0; }

        return Math.copySign((Math.abs(value) - DEAD_ZONE) / (1.0 - DEAD_ZONE), value);
    }

    // Functions for returning the doubles of the joysticks of a PS5 gamepad controller
    public double leftAnalogY() { return applyDeadZone(-this.gamepad.left_stick_y); }
    public double leftAnalogX() { return applyDeadZone(this.gamepad.left_stick_x); }
    public double rightAnalogY() { return applyDeadZone(this.gamepad.right_stick_y); }
    public double rightAnalogX() { return applyDeadZone(this.gamepad.right_stick_x); }

    // Functions for returning the doubles of the triggers of a PS5 gamepad controller
    public double leftTrigger() { return applyDeadZone(this.gamepad.left_trigger); }
    public double rightTrigger() { return applyDeadZone(this.gamepad.right_trigger); }

    // Functions for returning the booleans of the dpads of a PS5 gamepad controller
    public boolean dpadUp() { return this.gamepad.dpad_up; }
    public boolean dpadDown() { return this.gamepad.dpad_down; }
    public boolean dpadLeft() { return this.gamepad.dpad_left; }
    public boolean dpadRight() { return this.gamepad.dpad_right; }

    // Function for returning the booleans of the action buttons of a PS5 gamepad controller
    public boolean triangle() { return this.gamepad.triangle; }
    public boolean circle() { return this.gamepad.circle; }
    public boolean cross() { return this.gamepad.cross; }
    public boolean square() { return this.gamepad.square; }

    // Functions for returning the booleans of the bumpers of a PS5 gamepad controller
    public boolean leftBumper() { return this.gamepad.left_bumper; }
    public boolean rightBumper() { return this.gamepad.right_bumper; }

    // Functions for returning the booleans of the stick buttons of a PS5 gamepad controller
    public boolean leftStickButton() { return this.gamepad.left_stick_button; }
    public boolean rightStickButton() { return this.gamepad.right_stick_button; }

    //Functions for returning the booleans of the share/options buttons of a PS5 gamepad controller
    public boolean share() { return this.gamepad.share; }
    public boolean options() { return this.gamepad.options; }

    // Functions for the haptics of the PS5 gamepad
    public boolean isRumbling() { return this.gamepad.isRumbling(); }
    public double hapticNextComplete() { return this.gamepad.nextRumbleApproxFinishTime; }
    public void rumble(int duration) { this.gamepad.rumble(duration); }
    public void stopRumble() { this.gamepad.stopRumble(); }
}

// This file was made by dev-verexxed, completed at: [23/06/2026] [23:04]
