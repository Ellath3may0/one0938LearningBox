package org.firstinspires.ftc.teamcode.one0938LearningBox.one0938SampleOpModes;

import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name="Differential TeleOp Sample", group="Samples")
public class differrentialTeleOp extends OpMode
{
    // Here, we create a ton of variables to represent different parts of our robot.
    // They are declared here so they are in scope for our whole OpMode, but they aren't initialised
    // yet, because that would take up immense amounts of memory on our control hub for OpModes we
    // aren't using. You can hover your mouse over the types of each declaration to learn more about
    // what each one does.

    // This variable is a DifferentialDrive object. It's one of the drive base options provided to use
    // via the FTCLib database, and simplifies using common mechanisms.
    private DifferentialDrive differentialDrive;

    // These are the variables that will store our motors. These specifically use FTCLib's Motor
    // wrapper class which has extra built in tools for controlling the motors like PID controllers.
    private Motor fl; // Ignore that android studio is highlighting these. Because java is compiled, it can be a little dumb sometimes.
    private Motor bl;
    private Motor fr;
    private Motor br;

    private MotorGroup left;
    private MotorGroup right;

    @Override
    public void init()
    {
        // Initialising motors
        fl = new Motor(hardwareMap, "frontLeft");
        bl = new Motor(hardwareMap, "backLeft");
        fr = new Motor(hardwareMap, "frontRight");
        br = new Motor(hardwareMap, "backRight");

        left = new MotorGroup(fl, new Motor[] {bl});
        right = new MotorGroup(fr, new Motor[] {br});

        // Initialising DifferentialDrive object
        differentialDrive = new DifferentialDrive(left, right);
    }

    public void loop()
    {
        // This is a method intended to run once per loop, for the duration of the OpMode. This
        // sends controller inputs to the drive base object and tells the motors to move.
        // Specifically, this is an arcade drive method, which uses simple math to take turn and
        // speed inputs to create a simple differential drive control. This can be mapped to just
        // one stick, but I've mapped it to triggers and stick steering to make it more familiar.
        /*
        Controls:
        Left trigger    - brake/reverse
        Right trigger   - forward
        Left stick      - steering
        Right bumper    - Squares inputs. Slows down the robot for finer control.
         */
        differentialDrive.arcadeDrive(gamepad1.left_trigger - gamepad1.right_trigger, -0.5 * gamepad1.left_stick_x, gamepad1.right_bumper);
        // Alternatively, you can use a tank drive which uses no math, and directly maps the Y-Axis
        // of the control sticks to the power output of the left and right motors. Uncomment the
        // next line and comment out the arcade drive line to use tank drive.
        /*
        Controls:
        Left Stick Y    - Left wheels' power
        Right Stick Y   - Right wheels' power
        Right bumper    - Squares inputs. Slows down the robot for finer control.
         */
        //differentialDrive.tankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y, gamepad1.right_bumper);
    }
}
