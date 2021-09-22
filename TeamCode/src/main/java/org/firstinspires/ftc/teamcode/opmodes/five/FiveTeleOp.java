package org.firstinspires.ftc.teamcode.opmodes.five;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.FiveBot;

@TeleOp(name = "FiveTeleSMHS", group = "FreightBot")
public class FiveTeleOp extends LinearOpMode {
    FiveBot bot = new FiveBot();

    @Override
    public void runOpMode() {
        bot.init(hardwareMap);
        waitForStart();

        bot.handServo.turnToAngle(0);
        bot.sanitizerServo.turnToAngle(0);

        while (opModeIsActive()) {
            telemetry.addLine("begin run:");
            if (gamepad1.right_trigger > 0.3) {
                telemetry.addLine("right trigger!");
                bot.handServo.turnToAngle(90);
            } else if (gamepad1.left_trigger > 0.3) {
                telemetry.addLine("left trigger!");
                bot.sanitizerServo.turnToAngle(90);
            } else if (gamepad1.right_bumper) {
                telemetry.addLine("right bumper!");
                bot.handServo.turnToAngle(0);
            } else if (gamepad1.left_bumper) {
                telemetry.addLine("left bumper!");
                bot.sanitizerServo.turnToAngle(0);
            }
        }
    }
}
