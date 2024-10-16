
/*
FTCLib gives us a lot of tools that make our lives as programmers significantly easier.
 */
package org.firstinspires.ftc.teamcode.one0938LearningBox.learningFTCLibRobotClass;

import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;

import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveOdometry;

import com.qualcomm.robotcore.hardware.HardwareMap;


public class FTCLib_Chassis
{
    // Drivetrain wrapper and hardware
    private DifferentialDrive drivetrain;

    private MotorGroup MGLeft;
    private MotorGroup MGRight;

    private Motor leftFront;
    private Motor leftRear;
    private Motor rightFront;
    private Motor rightRear;

    // Odometry handler and related hardware
    private DifferentialDriveOdometry odo;

    private RevIMU imu;

    private Motor.Encoder leftEncoder;
    private Motor.Encoder rightEncoder;

    /**
     * Constructor for FTCLib Sample Robot Chassis
     * @param hardwareMap   HardwareMap object passed from your OpMode
     * @param startingPose  Starting position and heading of your robot on the field
     */
    public FTCLib_Chassis(HardwareMap hardwareMap, Pose2d startingPose)
    {
        // Initialising motor wrappers
        leftFront   = new Motor(hardwareMap, "leftFront");
        leftRear    = new Motor(hardwareMap, "leftRear");
        rightFront  = new Motor(hardwareMap, "rightFront");
        rightRear   = new Motor(hardwareMap, "rightRear");

        // Initialising motor groups
        MGLeft      = new MotorGroup(leftFront, leftRear);
        MGRight     = new MotorGroup(rightFront, rightRear);

        // Setting RunModes
        /*
        The setRunMode method is a default for the RobotCore DcMotor classes, but the FTCLib
        implementation can be called on motor groups for convenience, as well as including different
        enum values for the RunModes themselves. In this case we use the RawPower RunMode which
        functions the same as the FTC SDK's RUN_WITHOUT_ENCODER RunMode.
         */
        MGLeft.setRunMode(Motor.RunMode.RawPower);
        MGRight.setRunMode(Motor.RunMode.RawPower);

        // Initialising drivetrain object
        drivetrain  = new DifferentialDrive(true, MGLeft, MGRight);

        // TODO: line number in index
        // Storing references to the encoders used for odometry (see line XX)
        leftEncoder     = leftFront.encoder;
        rightEncoder    = rightFront.encoder;

        // Initialising the IMU wrapper
        imu = new RevIMU(hardwareMap, "imu");

        // Initialising odometry handler
        odo = new DifferentialDriveOdometry(startingPose.getRotation(), startingPose);
    }

    /**
     * Arcade drive method for TeleOp control (w/ squared inputs)
     * @param throttle      A double value between -1.0 and 1.0 that represents the speed of the
     *                      robot. 1.0 is full speed forward and -1.0 is full speed in reverse
     * @param turn          A double value between -1.0 and 1.0 that represents the intensity of a
     *                      turn, where 1.0 is a full right turn and -1.0 is a full left turn.
     * @param squareInputs  A boolean input (button press) that increases the sensitivity of the
     *                      robot's controls by squaring the values of the other two inputs.
     */
    public void teleOpArcadeDrive(Double throttle, Double turn, boolean squareInputs)
    {
        // The arcade drive method is a member of the DifferentialDrive class from FTCLib
        drivetrain.arcadeDrive(throttle, turn, squareInputs);
    }

    /**
     * Arcade drive method for TeleOp control (w/o squared inputs)
     * @param throttle      A double value between -1.0 and 1.0 that represents the speed of the
     *                      robot. 1.0 is full speed forward and -1.0 is full speed in reverse
     * @param turn          A double value between -1.0 and 1.0 that represents the intensity of a
     *                      turn, where 1.0 is a full right turn and -1.0 is a full left turn.
     */
    public void teleOpArcadeDrive(Double throttle, Double turn)
    {
        drivetrain.arcadeDrive(throttle, turn);
    }

    /**
     * Tank drive method for TeleOp control (w/ squared inputs)
     * @param left          A double value between -1.0 and 1.0 that represents the left side power
     *                      output of the drivetrain
     * @param right         A double value between -1.0 and 1.0 that represents the right side power
     *                      of the drivetrain
     * @param squareInputs  A boolean input (button press) that increases the sensitivity of the
     *                      robot's controls by squaring the values of the other 2 inputs.
     */
    public void teleOpTankDrive(Double left, Double right, boolean squareInputs)
    {
        drivetrain.tankDrive(left, right, squareInputs);
    }


    /**
     * Tank drive method for TeleOp control (w/ squared inputs)
     * @param left          A double value between -1.0 and 1.0 that represents the left side power
     *                      output of the drivetrain
     * @param right         A double value between -1.0 and 1.0 that represents the right side power
     *                      output of the drivetrain
     */
    public void teleOpTankDrive(Double left, Double right)
    {
        drivetrain.tankDrive(left, right);
    }

}
