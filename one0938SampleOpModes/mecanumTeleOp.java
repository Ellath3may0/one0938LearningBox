package org.firstinspires.ftc.teamcode.one0938LearningBox.one0938SampleOpModes;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name="Mecanum TeleOp Sample", group="Samples")
public class mecanumTeleOp extends OpMode
{

    // Here, we create a ton of variables to represent different parts of our robot.
    // They are declared here so they are in scope for our whole OpMode, but they aren't initialised
    // yet, because that would take up immense amounts of memory on our control hub for OpModes we
    // aren't using. You can hover your mouse over the types of each declaration to learn more about
    // what each one does.

    // This variable is a MecanumDrive object. It's one of the drive base options provided to use
    // via the FTCLib database, and simplifies using common mechanisms.
    private MecanumDrive mecanumDrive;

    // These are the variables that will store our motors. These specifically use FTCLib's Motor
    // wrapper class which has extra built in tools for controlling the motors like PID controllers.
    private Motor fl;
    private Motor bl;
    private Motor fr;
    private Motor br;

    // This is an FTCLib IMU wrapper object. The IMU is integrated into the control hub on your
    // robot and have a few more settings than objects like motors. Those are all in the
    // initialisation section though.
    private RevIMU imu;


    @Override
    public void init()
    {
        // Initialising motors
        fl = new Motor(hardwareMap, "frontLeft");
        bl = new Motor(hardwareMap, "backLeft");
        fr = new Motor(hardwareMap, "frontRight");
        br = new Motor(hardwareMap, "backRight");

        // Initialising MecanumDrive object
        mecanumDrive = new MecanumDrive(fl, fr, bl, br);

        // Initialising IMU
        // You WILL want to read through this class in the FTCLib docs or just by reading the
        // comments in the class. It's very confusing but you NEED to make sure you follow every
        // bit of it. Note: before running this OpMode you will need to calibrate the IMU with the
        // calibration OpMode in the root of the LearningBox package.
        imu = new RevIMU(hardwareMap);
        imu.init();


    }

    public void loop()
    {
        // This is a method intended to run once per loop, for the duration of the OpMode. This
        // sends controller inputs to the drive base object and tells the motors to move.
        // Specifically, this is a field centric mecanum drive call. (robot moves relative to the
        // field)
        /*
        Controls:
        Left stick      - Lateral translation. Moves the robot around the field.
        Right stick     - Rotation. Move the stick left to make the robot rotate left.
        Right bumper    - Squares inputs. This slows the robot down a lot. It allows for finer
                          control while driving in tight situations.
         */
        mecanumDrive.driveFieldCentric(gamepad1.left_stick_x,
                                        gamepad1.left_stick_y,
                                        gamepad1.right_stick_x,
                                        imu.getHeading(),
                                        gamepad1.right_bumper);
        // For a POV drive, comment out that line ^^^ and uncomment line 81
        // If you are using POV drive, you won't need the IMU. You can delete all code pertaining to
        // it in this OpMode.
        /*
        Controls:
        Left stick      - Move the robot left, right, forward, backward, and any direction between.
        Right stick     - Make the robot spin/turn on the spot.
        Right bumper    - Squares inputs. Increases control sensitivity.
         */
        //mecanumDrive.driveRobotCentric(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.right_bumper);
    }
}
