/*
Since we've already talked about a lot of the parts of an OpMode, I'll skip over most of the stuff
we've already covered.
 */

package org.firstinspires.ftc.teamcode.one0938LearningBox.learningToOpmode;


/*
Here is the first difference: Two new import statements that bring in two new classes that replace
OpMode and TeleOp from the last file. In fact, these classes are mutually exclusive. You  can't use
both of them at the same time. Autonomous and TeleOp refer to the category of your OpMode, whether
it is to be run during autonomous or TeleOp. OpMode and Linear OpMode are also mutually exclusive,
because they refer to the structure and behaviour of the OpMode itself. The OpMode class is most
often used when creating an iterative OpMode, or an OpMode that consists of repeated behaviours
found in loops, while a LinearOpMode will execute code in a script-like fashion, where the code is
executed in a linear fashion, one after the other. This is most useful in some autonomous programs
where a robot is performing specific actions in a specific sequence. You can also use the class's
"+opModeIsActive(): boolean" method to create loops that run until you stop the program just like
in the OpMode class. As you get more advanced , you may want to look into using iterative OpModes
with threading for autonomous.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@Disabled
/*
The difference in our OpMode annotation comes from the difference we talked about above between an
autonomous program and a TeleOp program. In practice, this is used to sort your OpMode under the
Autonomous category on the driver station.
 */
@Autonomous (name="LinearOpModeBreakdown", group="Learning")
/*
In the class declaration you can see the other difference. Instead of extending the OpMode class, we
are extending LinearOpMode, which changes the methods the superclass provides to us, and thus the
way we are able to write the OpMode.
 */
public class B_LinearOpModeBreakdown extends LinearOpMode
{
    /*
    Just like the last OpMode, it is best practice to put your variable declarations in the root of
    your OpMode's class to keep them in scope throughout your program and any methods you might add
    to it.
     */
    DcMotor motor;
    IMU imu;

    /*
    Instead of having init, start, end, and loop methods like the OpMode class, LinearOpMode gives
    us the runOpMode() method. This method begins running as soon as you press the INIT button on
    the driver station, and when it finishes, the program ends.
     */
    public void runOpMode()
    {
        /*
        Although there aren't any specifically labeled sections of a LinearOpMode, there are common
        structures that can be used to create areas that serve the same purposes. Right here, we are
        in what would be considered by most as the initialisation section of the OpMode. This code
        runs when the INIT button is pressed, because the runOpMode() method is called, but on line
        XX we use the method "waitForStart()". This method will stop the program from continuing
        until you press the start button on the driver station.
         */
        motor   = hardwareMap.get(DcMotor.class, "motor");
        imu     = hardwareMap.get(IMU.class, "imu");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        /*
        You can also mimic the behaviour of the init_loop() from the last OpMode using a loop that
        checks the isStarted() method to see if the start button has been pressed.
        Here's an example:

        while (!isStarted())
        {
            // Any code in this loop will repeat until start is pressed.
        }

        When you use a loop like that, you also don't need to use the waitForStart() method
        afterwards because the loop will continue to execute until the start button is pressed, then
        the code after it will begin executing.
         */
        waitForStart();

        /*
        This section of the program equates to the start() method of the last OpMode. The code here
        is executed once after the start button is pressed.

        Here's some example code that will set the motor's output power to equal the pitch of the
        accelerometer at the start of the program:
        */

        motor.setPower(imu.getRobotYawPitchRollAngles().getPitch(AngleUnit.RADIANS)/(2 * Math.PI));

        /*
        This line of code uses the motor's setPower(Double power) method, passing in the algebraic
        equation as a parameter.

        This equation has a few parts.
        First, we get the IMU's pitch, yaw, and roll angle measurements using the IMU's
        getYawPitchRollAngles() method which returns a YawPitchRollAngles object that stores the
        data collected by the IMU sensor. This object has a .getPitch(AngleUnit angleUnit) method
        which returns the pitch data stored in the YawPitchRollAngles object, in the measurement
        unit we pass as the parameter. In this case, we pass the AngleUnit enum value RADIANS. For
        those of you unfamiliar, radians are a measure of angles just like degrees, but instead of a
        full rotation being 360 degrees, a full rotation around a circle is 2*pi. To convert this to
        a range of 0 to 1, we divide the angle returned from our IMU by 2 * pi, using the Math
        module's PI attribute to get an accurate value of pi for our calculation.

        If we were to run this OpMode, the power of the motor would be set by the pitch of the IMU's
        position in the real world. If you hold the IMU perfectly level, the motor's power would be
        set to 0, but if you pitched it slightly up and ran the OpMode, it would be set to its
        maximum power output. If you held the IMU upside down, it would set the motor's power to
        half of its maximum. However, because it's not in a loop, this line will only exectue once,
        so whatever the angle of the IMU is when you press start, determines the power of the motor
        for the whole program.

        In reality though, the motor might not even start spinning. Because the OpMode doesn't have
        any time considerations or loops, the program would reach the end of the runOpMode() method,
        and the OpMode would end. To solve this you could use a sleep() method to suspend the thread
        which would give a bit of time for the motor to be powered before the program ends, or you
        could create a loop.

        Here's an example of a loop that would have the same effective behaviour of the loop()
        method from the last OpMode:
         */
        while (opModeIsActive())
        {
            /*
            The code in this loop will run until the stop button is pressed. This gives the motor
            unlimited time to spin. Or at least until you press the stop button.

            If you were using a linear OpMode for your robot's TeleOp program, this is where you
            would put your control statements.
             */
        }

        /*
        This part of the OpMode, after any loops or other code would function similarly to the
        stop() function from the last OpMode, where the code here is executed once before the
        program ends.
         */
    }
}

/*
Now that you know how OpModes work, we need to start talking about your robot itself. Open the java
file "A_RobotClassBreakdown" in the learningToRobot package to continue.
 */
