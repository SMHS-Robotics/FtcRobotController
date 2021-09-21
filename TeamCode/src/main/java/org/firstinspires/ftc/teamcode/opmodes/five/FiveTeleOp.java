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
            if (gamepad2.right_trigger > 0.5) {
                bot.handServo.turnToAngle(90);
            } else if (gamepad2.left_trigger > 0.5) {
                bot.sanitizerServo.turnToAngle(90);
            } else if (gamepad2.right_bumper) {
                bot.handServo.turnToAngle(0);
            } else if (gamepad2.left_bumper) {
                bot.sanitizerServo.turnToAngle(0);
            }
        }
    }
}
