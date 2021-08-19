package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.FreightBot;

@Autonomous(name = "AutoOp", group = "SMHSFreightBot")
public class FreightAuto extends LinearOpMode {
    FreightBot robot = new FreightBot();
    PIDController rotateController = new PIDController(0.01, 0.2, 0.0001);

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();
        rotate(90);
    }

    // negative degrees = right turn, positive = left turn
    public void rotate(double degrees) {
        double rpower = degrees < 0 ? -0.3 : 0.3;
        final double TURN_TOLERANCE = 0.15;

        robot.imu.reset();
        robot.drive.stop();
        rotateController.reset();
        rotateController.setSetPoint(degrees);
        rotateController.setTolerance(TURN_TOLERANCE);

        do {
            robot.drive.driveRobotCentric(0, 0, rpower);
            sleep(50);
            rpower = rotateController.calculate(robot.imu.getRotation2d().getDegrees());
        } while (opModeIsActive() && !rotateController.atSetPoint());

        // turn the motors off.
        robot.drive.stop();

        // wait for rotation to stop.
        sleep(200);

        // reset angle tracking on new heading.
        robot.imu.reset();
    }
}
