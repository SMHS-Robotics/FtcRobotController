package org.firstinspires.ftc.teamcode.hardware;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FiveBot {
    public ServoEx handServo;
    public ServoEx sanitizerServo;

    /* local OpMode members. */
    private HardwareMap hwMap;

    /* Constructor */
    public FiveBot() { }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        handServo = new SimpleServo(hwMap, "hand", 0, 360);
        sanitizerServo = new SimpleServo(hwMap, "sanitizer", 0, 360);
    }
}
