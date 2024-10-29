package org.firstinspires.ftc.teamcode.one0938LearningBox.learningFTCLibSampleTeamCode.subsystems;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw extends SubsystemBase
{

    private SimpleServo leftClaw;
    private SimpleServo rightClaw;

    private ClawPosition leftPosition;
    private ClawPosition rightPosition;

    public Claw(HardwareMap hardwareMap)
    {
        CommandScheduler.getInstance().registerSubsystem(this);

        leftClaw    = new SimpleServo(hardwareMap, "leftClaw",
                0, 110);
        leftClaw.setInverted(true);
        rightClaw   = new SimpleServo(hardwareMap, "rightClaw",
                0, 110);

        leftPosition    = ClawPosition.CLOSE;
        rightPosition   = ClawPosition.CLOSE;
    }

    public void periodic()
    {
        switch (leftPosition)
        {
            case OPEN:
                leftClaw.setPosition(110);
                break;
            case CLOSE:
                leftClaw.setPosition(0);
                break;
            default:
                leftClaw.setPosition(110);
                leftPosition = ClawPosition.OPEN;
                break;
        }

        switch (rightPosition)
        {
            case OPEN:
                rightClaw.setPosition(110);
                break;
            case CLOSE:
                rightClaw.setPosition(0);
                break;
            default:
                leftClaw.setPosition(110);
                rightPosition = ClawPosition.OPEN;
                break;
        }
    }

    public void setLeftClaw(ClawPosition pos)
    {
        leftPosition = pos;
    }

    public void setRightClaw(ClawPosition pos)
    {
        rightPosition = pos;
    }

    public enum ClawPosition
    {
        OPEN,
        CLOSE
    }
}
