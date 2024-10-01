package org.firstinspires.ftc.teamcode.one0938LearningBox.learningToOpmode;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

@Disabled
@Autonomous (name="LinearOpModeBreakdown", group="Learning")
public class B_LinearOpModeBreakdown extends LinearOpMode
{
    DcMotor motor;
    IMU imu;

    public void runOpMode()
    {
        telemetry.addData("Status", "Initialized");
    }
}
