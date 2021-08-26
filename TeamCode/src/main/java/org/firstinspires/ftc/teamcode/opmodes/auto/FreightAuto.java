package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.FreightBot;

<<<<<<< HEAD

@Autonomous(name = "FreightAutoSMHS", group = "SMHSBots")
=======
@Autonomous(name = "AutoOp", group = "SMHSFreightBot")
>>>>>>> 9273d81ec94348873503c687d6b3e9f903660ec7
public class FreightAuto extends LinearOpMode {
    FreightBot robot = new FreightBot();
    PIDController rotateController = new PIDController(0.01, 0.2, 0.0001);

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();
<<<<<<< HEAD
=======
        rotate(90);
>>>>>>> 9273d81ec94348873503c687d6b3e9f903660ec7
    }

    // negative degrees = right turn, positive = left turn
    public void rotate(double degrees) {
        double rpower = degrees < 0 ? -0.1 : 0.1;
        final double TURN_TOLERANCE = 0.05;
        robot.imu.reset();
        robot.drive.stop();
        rotateController.reset();
        rotateController.setSetPoint(degrees);
        rotateController.setTolerance(TURN_TOLERANCE);

        do {
            robot.drive.driveRobotCentric(0, 0, rpower);
            sleep(50);
            rpower = rotateController.calculate(robot.imu.getRotation2d().getDegrees())/2;
        } while (opModeIsActive() && !rotateController.atSetPoint());

        // turn the motors off.
        robot.drive.stop();

        // wait for rotation to stop.
        sleep(200);

        // reset angle tracking on new heading.
        robot.imu.reset();
    }
}
