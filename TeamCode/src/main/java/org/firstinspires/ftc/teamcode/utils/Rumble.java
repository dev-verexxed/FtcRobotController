// Java file for controlling the gamepads rumble
package org.firstinspires.ftc.teamcode.utils;

// Imports
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.common.Controller;


// Java class for creating and updating rumble
public class Rumble {
    // Creating and storing the controller and creating an elapsed class
    private final Controller controller;
    private final ElapsedTime elapsedTime = new ElapsedTime();
    // Variables for checking and updating blip rumble
    private boolean isBlipping = false;
    private int blipCount = 0;
    private int blipTarget = 0;
    private int blipDuration = 0;


    // Constructor to update the controller variable
    public Rumble(Gamepad gamepad) {
        this.controller = new Controller(gamepad);
    }
    // Functions for creating rumbles
    public void quickRumble() { rumble(500); }
    public void midRumble() { rumble(1000); }
    public void longRumble() { rumble(2000); }
    // Functions for creating blip rumbles
    public void blipQuickRumble() { blip(250, 3); }
    public void blipMidRumble() { blip(500, 4); }
    public void blipLongRumble() { blip(750, 5); }
    // Function for centralizing rumbles
    private void rumble(int duration) {
        controller.stopRumble();
        controller.rumble(duration);
    }
    // Function to update the blip variables
    private void blip(int duration, int count) {
        if (this.isBlipping) { return; }

        this.isBlipping = true;
        this.blipDuration = duration;
        this.blipCount = 0;
        this.blipTarget = count;

        this.elapsedTime.reset();
    }
    // Function to send blip data to the rumble function
    public void update() {
        if (!this.isBlipping) { return; }

        if (this.elapsedTime.milliseconds() >= this.blipDuration + 200) {
            rumble(this.blipDuration);

            this.blipCount++;
            this.elapsedTime.reset();

            if (this.blipCount >= this.blipTarget) {
                this.isBlipping = false;
            }
        }
    }
}

// This file was made by dev-verexxed, completed at: [25/06/2026] [16:44]
