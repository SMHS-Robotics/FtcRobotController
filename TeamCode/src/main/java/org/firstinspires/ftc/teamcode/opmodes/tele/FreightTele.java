package org.firstinspires.ftc.teamcode.opmodes.tele;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.FreightBot;

@TeleOp(name = "FreightTeleSMHS", group = "FreightBot")
public class FreightTele extends LinearOpMode {
    FreightBot robot = new FreightBot();
    GamepadEx control1, control2;

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

        control1 = new GamepadEx(gamepad1);
        control2 = new GamepadEx(gamepad2);

        while (opModeIsActive()) {
            double drive = control1.getLeftY() * 0.5;
            double strafe = control1.getLeftX() * 0.5;
            double turn = control1.getRightX() * 0.5;

            if (control1.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.5) {
                drive += 0.3; // speed boost
                strafe += 0.3;
                turn += 0.3;
            }

            robot.drive.driveRobotCentric(strafe, drive, turn);
        }
    }
}
