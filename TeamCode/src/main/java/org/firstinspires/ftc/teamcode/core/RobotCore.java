// Java file to centralize files accessing robot hardware
package org.firstinspires.ftc.teamcode.core;

// Imports
import com.qualcomm.robotcore.hardware.HardwareMap;


// Java class to create and store the core robot hardware
public class RobotCore {
    // Constant variable for storing the robot
    private final RobotHardware robot;


    // Constructor for setting the robot hardware to the robot variable
    public RobotCore(HardwareMap hardwareMap) { this.robot = new RobotHardware(hardwareMap); }

    // Getter method for returning the robot object
    public RobotHardware getRobot() { return this.robot; }
}

// This file was made by dev-verexxed, completed at: [23/06/2026] [11:41]
