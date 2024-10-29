package org.firstinspires.ftc.teamcode.one0938LearningBox.learningFTCLibSampleTeamCode.subsystems;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Arm extends SubsystemBase
{
    private Motor armLeft;
    private Motor armRight;

    private SimpleServo wrist;

    private WristPosition wristPosition;

    private ArmPosition armPosition = ArmPosition.REST;

    private final double Kp = 0;
    private final double Ki = 0;
    private final double Kd = 0;

    private double integralSum = 0;
    private double lastError = 0;
    ElapsedTime timer = new ElapsedTime();

    public Arm(HardwareMap hardwareMap)
    {
        CommandScheduler.getInstance().registerSubsystem(this);

        armLeft     = new Motor(hardwareMap, "armLeft");
        armLeft.setInverted(true);
        armRight    = new Motor(hardwareMap, "armRight");

        wrist       = new SimpleServo(hardwareMap, "wrist",
                            0, 180, AngleUnit.DEGREES);

        wrist.setPosition(0);
    }

    public enum WristPosition {
        LEVEL,
        FLIPPED,
        VERTICAL
    }

    public void periodic()
    {

        switch(armPosition)
        {
            case REST:
                pidLoop(0);
                break;
            case LOW:
                pidLoop(600);
                break;
            case HIGH:
                pidLoop(1200);
                break;
            default:
                pidLoop(0);
                armPosition = ArmPosition.REST;
                break;
        }

        switch (wristPosition)
        {
            case FLIPPED:
                wrist.setPosition(180);
                break;
            case VERTICAL:
                wrist.setPosition(90);
                break;
            default:
                wrist.setPosition(0);
                break;
        }
    }

    public void setWristPosition(WristPosition pos)
    {
        wristPosition = pos;
    }

    public void setArmPosition(ArmPosition pos)
    {
        armPosition = pos;
    }

    public void pidLoop(int target)
    {
        int motorPosition = armLeft.getCurrentPosition();
        int error = target - motorPosition;

        double derivative = (error - lastError) / timer.seconds();

        integralSum += error * timer.seconds();

        double power = (Kp * error) + (Ki * integralSum) + (Kd * derivative);

        armLeft.set(power);
        armRight.set(power);

        lastError = error;

        timer.reset();
    }

    public enum ArmPosition
    {
        REST,
        LOW,
        HIGH
    }
}

