package org.firstinspires.ftc.teamcode.hardware;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FreightBot {
    /* Public OpMode members. */
    public MotorEx leftBackMotor, rightBackMotor, leftFrontMotor, rightFrontMotor;

    public MecanumDrive drive;

    public RevIMU imu = null;

    /* local OpMode members. */
    private HardwareMap hwMap;

    /* Constructor */
    public FreightBot() { }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftBackMotor = new MotorEx(hwMap, "left_drive");
        rightBackMotor = new MotorEx(hwMap, "right_drive");
        leftFrontMotor = new MotorEx(hwMap, "left_drive_front");
        rightFrontMotor = new MotorEx(hwMap, "right_drive_front");

        drive = new MecanumDrive(leftFrontMotor, rightFrontMotor, leftBackMotor, rightBackMotor);

        imu = new RevIMU(hwMap, "imu");
        imu.init();

        // Set all motors to zero power
        drive.stop();

        // Make motors brake when they hit zero power.
        leftFrontMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightFrontMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        leftBackMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightBackMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        imu.reset();
    }



}