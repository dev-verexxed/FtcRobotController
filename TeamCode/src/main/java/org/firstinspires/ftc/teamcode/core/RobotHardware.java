// Java file for robot hardware
package org.firstinspires.ftc.teamcode.core;

// Imports
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.enums.MotorEnum;
import org.firstinspires.ftc.teamcode.enums.ServoEnum;

import java.util.EnumMap;
import java.util.Map;


// Java class to create and store the robot hardware
public class RobotHardware {
    // Settings each component to a constant private variable
    private final Map<MotorEnum, DcMotor> motors = new EnumMap<>(MotorEnum.class);
    private final Map<ServoEnum, Servo> servos = new EnumMap<>(ServoEnum.class);
    private final Limelight3A limelight3A;
    private final RevColorSensorV3 revColorSensorV3;
    private final IMU imu;


    // Constructor to create and store the robot hardware
    public RobotHardware(HardwareMap hardwareMap) {
        // Mapping each hardware to the correct variable
        for (MotorEnum motor : MotorEnum.values()) { motors.put(motor, hardwareMap.get(DcMotor.class, motor.getHardwareName())); }
        for (ServoEnum servo : ServoEnum.values()) { servos.put(servo, hardwareMap.get(Servo.class, servo.name())); }

        limelight3A = hardwareMap.get(Limelight3A.class, "limelight3A");
        revColorSensorV3 = hardwareMap.get(RevColorSensorV3.class, "revColorSensorV3");
        imu = hardwareMap.get(IMU.class, "imu");


        // Setting the correct modes of each motor
        for (MotorEnum motor : MotorEnum.values()) {
            DcMotor dcMotor = motors.get(motor);

            dcMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            dcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            dcMotor.setDirection(motor.getDirection());

            dcMotor.getTargetPosition();
        }

        RevHubOrientationOnRobot revHubOrientationOnRobot = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );
    }

    // Setter method for setting the power of a motor
    public void setMotorPower(MotorEnum motor, double power){ this.motors.get(motor.getHardwareName()).setPower(power); }

    // Method for checking if a motor is busy
    public boolean isMotorBusy(MotorEnum motor) { return this.motors.get(motor.getHardwareName()).isBusy(); }

    // Getter method for getting the latest result from the Limelight3A
    public LLResult getLatestResult(){ return this.limelight3A.getLatestResult(); }

    // Getter method for getting the time since the last update
    public long getTimeSinceLastUpdate() { return this.limelight3A.getTimeSinceLastUpdate(); }

    // Getter method for getting the distance of the rev color sensor
    public double getRevDistance() { return this.revColorSensorV3.getDistance(DistanceUnit.INCH); }

    // Getter method for getting the color detected by the rev color sensor
    public double getLightDetected() { return this.revColorSensorV3.getLightDetected(); }
}

// This file was made by dev-verexxed, completed at: [23/06/2026] [11:41]
