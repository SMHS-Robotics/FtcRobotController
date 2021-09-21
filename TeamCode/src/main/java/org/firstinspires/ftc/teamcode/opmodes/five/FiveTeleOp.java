package org.firstinspires.ftc.teamcode.opmodes.five;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.FiveBot;

@TeleOp(name = "FiveTeleSMHS", group = "FreightBot")
public class FiveTeleOp extends LinearOpMode {
    FiveBot bot = new FiveBot();
    GamepadEx control1;

    @Override
    public void runOpMode() {
        bot.init(hardwareMap);
        waitForStart();

        bot.handServo.turnToAngle(0);
        bot.sanitizerServo.turnToAngle(0);

        control1 = new GamepadEx(gamepad1);
        while (opModeIsActive()) {
            if (control1.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.5) {
                bot.handServo.turnToAngle(90);
            } else if (control1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.5) {
                bot.sanitizerServo.turnToAngle(90);
            } else if (control1.getButton(GamepadKeys.Button.RIGHT_BUMPER)) {
                bot.handServo.turnToAngle(0);
            } else if (control1.getButton(GamepadKeys.Button.LEFT_BUMPER)) {
                bot.sanitizerServo.turnToAngle(0);
            }
        }
    }
}
