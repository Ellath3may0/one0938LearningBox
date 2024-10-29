/*
FTCLib gives us a lot of tools that make our lives as programmers significantly easier.
 */
package org.firstinspires.ftc.teamcode.one0938LearningBox.learningFTCLibSampleTeamCode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;

import com.arcrobotics.ftclib.geometry.Pose2d;

import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveKinematics;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveOdometry;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveWheelSpeeds;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.one0938LearningBox.learningFTCLibSampleTeamCode.DriveConstants;


public class Drivetrain extends SubsystemBase
{
    // Hardware devices
    private MotorGroup MGLeft;
    private MotorGroup MGRight;

    private Motor leftFront;
    private Motor leftRear;
    private Motor rightFront;
    private Motor rightRear;

    private Encoder leftEncoder;
    private Encoder rightEncoder;

    RevIMU imu;

    DifferentialDriveOdometry odometry;
    DifferentialDriveKinematics kinematics;


    /**
     * Constructor for FTCLib Sample Robot Chassis
     * @param hardwareMap   HardwareMap object passed from your OpMode
     * @param startingPose  Starting position and heading of your robot on the field
     */
    public Drivetrain(HardwareMap hardwareMap, Pose2d startingPose)
    {
        // Initialising motors
        leftFront   = new Motor(hardwareMap, "leftFront");
        leftRear    = new Motor(hardwareMap, "leftRear");
        rightFront  = new Motor(hardwareMap, "rightFront");
        rightRear   = new Motor(hardwareMap, "rightRear");

        // Initialising motor groups
        MGLeft  = new MotorGroup(leftFront, leftRear);
        MGRight = new MotorGroup(rightFront, rightRear);

        // Initialising encoders
        leftEncoder     = leftFront.encoder;
        rightEncoder    = rightFront.encoder;

        // Initialising IMU (accelerometer)
        imu = new RevIMU(hardwareMap, "imu");
        imu.init();

        // Initialising odometry and kinematics systems
        odometry = new DifferentialDriveOdometry(imu.getRotation2d(), startingPose);
        kinematics = new DifferentialDriveKinematics(DriveConstants.TRACK_WIDTH);
    }

    public void periodic()
    {
        odometry.update(imu.getRotation2d(), leftEncoder.getDistance(), rightEncoder.getDistance());
    }

    public DifferentialDriveWheelSpeeds getWheelSpeeds()
    {
        return new DifferentialDriveWheelSpeeds(leftEncoder.getRate(), rightEncoder.getRate());
    }

    public Pose2d getPose()
    {
        return odometry.getPoseMeters();
    }

    public void drive(double left, double right)
    {
        MGLeft.set(left / DriveConstants.MAX_VELOCITY);
        MGRight.set(right / DriveConstants.MAX_VELOCITY);
    }

    public void teleOpArcadeDrive(double throttle, double turn, boolean squareInputs)
    {
        if (squareInputs)
        {
            drive(Math.pow(throttle, 2) + Math.pow(turn, 2),
                    Math.pow(throttle, 2) - Math.pow(turn, 2));
        }
        else
        {
            drive(throttle + turn, throttle - turn);
        }
    }
}

