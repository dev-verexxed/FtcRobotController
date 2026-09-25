// Java file to store motor hardware name and direction
package org.firstinspires.ftc.teamcode.enums;

// Imports
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


public enum MotorEnum {
    // Enums to store each motor hardware name and direction
    FRONT_LEFT_MOTOR("front_left_motor", DcMotor.Direction.REVERSE),
    FRONT_RIGHT_MOTOR("front_right_motor", DcMotor.Direction.FORWARD),
    BACK_LEFT_MOTOR("back_left_motor", DcMotor.Direction.REVERSE),
    BACK_RIGHT_MOTOR("back_right_motor", DcMotor.Direction.FORWARD);


    // Private variable to set the hardware name and direction
    private final String hardwareName;
    private final DcMotor.Direction direction;


    // Constructor to set the variable to the hardware name
    MotorEnum(String hardwareName, DcMotor.Direction direction){
        this.hardwareName = hardwareName;
        this.direction = direction;
    }

    // Getter method to retrieve the enum for the hardware name
    public String getHardwareName(){ return this.hardwareName; }

    // Getter method to retrieve the enum for the hardware direction
    public DcMotorSimple.Direction getDirection() { return  this.direction; }
}

// This file was made by dev-verexxed, [23/06/2026] [11:46]
