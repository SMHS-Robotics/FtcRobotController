package org.firstinspires.ftc.teamcode.opmodes.five;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.FiveBot;

@Autonomous(name = "FiveAutonomousSMHS", group = "FreightBot")
public class FiveTeleOp extends LinearOpMode {
    FiveBot bot = new FiveBot();

    @Override
    public void runOpMode() {
        bot.init(hardwareMap);
        waitForStart();

        bot.handServo.setPosition(0);
        sleep(500);
        bot.handServo.rotateByAngle(120);
        sleep(1200);
        bot.handServo.rotateByAngle(215);
        sleep(1000);

        bot.sanitizerServo.setPosition(1);
        sleep(500);
        bot.sanitizerServo.setPosition(0);
        sleep(500);

        bot.handServo.setPosition(0);
        sleep(3000);
    }
}
