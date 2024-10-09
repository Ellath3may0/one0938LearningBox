/*
This class is going to get busy fast so I'm going to give this disclaimer first:

If you find any word that you don't understand, try looking either at the java documentation,
gm0.org, or the FTCDocs site to figure out what it is before continuing. The information shared here
isn't going to be helpful if you don't understand any of what it means.
 */
package org.firstinspires.ftc.teamcode.one0938LearningBox.learningToRobot;
/*
The import statements in this file are going to include primarily the interfaces for hardware
devices and sensors or parts of OpModes from the FTC SDK.
 */

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/*
The declaration here is kind of the same as for the robot class. Just be sure to pick a descriptive
and intuitive name that explains the purpose of the class.
 */
public class Drivetrain
{
    /*
    Most FTC drivetrains use multiple motors and sometimes sensors. For this example I am going to
    use a 4-motor differential drivetrain, with drive encoders. The drive encoder interfaces are
    built into the DcMotor interface so you don't have to do any extra imports for those unless you
    are using external encoders for dead-wheels or something else and need the separate interfaces.
     */

    // Left Drive Motors
    DcMotor leftFront;
    DcMotor leftRear;

    // Right Drive Motors
    DcMotor rightFront;
    DcMotor rightRear;

    // Because our drivetrain is relatively simple, we won't need anything else besides the motors.

    public Drivetrain(HardwareMap hardwareMap)
    {
        // Instantiate motors
        leftFront   = hardwareMap.get(DcMotor.class, "leftFront");
        leftRear    = hardwareMap.get(DcMotor.class, "leftRear");
        rightFront  = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear   = hardwareMap.get(DcMotor.class, "rightRear");

        // If we were using extra control interfaces like RoadRunner (more on stuff like that later)
        // you would initialise those variables here as well
    }

    /*
    So now we have a class that contains our hardware devices. What do we do with that? The simplest
    explanation is to define methods. What steps do we have to take to make those hardware devices
    function as we want them to?

    The first function is going to be a simple arcade drive:
     */

    /*
    This is a JavaDoc comment. It's used to created in-code documentation for a method. I recommend
    doing research into this topic.
     */
    /**Arcade drive for differential drivebase
     * @param turnInput A double value between -1 and 1 that represents how far the robot should
     *                  turn (-1 = left, 1 = right)
     * @param throttleInput A double value between -1 and 1 that represents how fast the robot
     *                      should move (-1 full speed reverse, 1 full speed forward)
     * @param squareInputs A boolean value to switch between squared and non-squared inputs (true =
     *                     squared, false = unsquared
     */
    public void teleOpArcadeDrive(double turnInput,
                                  double throttleInput,
                                  boolean squareInputs)
    {
        double leftPower;
        double rightPower;

        if (squareInputs)
        {
            leftPower  = Math.pow(throttleInput, 2) + Math.pow(turnInput, 2);
            rightPower = Math.pow(throttleInput, 2) - Math.pow(turnInput, 2);
        }
        else
        {
            leftPower  = throttleInput + turnInput;
            rightPower = throttleInput - turnInput;
        }

        leftFront.setPower(leftPower);
        leftRear.setPower(leftPower);

        rightFront.setPower(rightPower);
        rightRear.setPower(rightPower);
    }
    /*
    Now would be a good time to look at this code and try to decipher how it works. The JavaDoc
    comment can be used as a guide.
     */

    /*
    This is also a good time to talk about controllers.

    Every input on the controller has an associated data type and value range that can be accessed
    via the Gamepad objects from either type of OpMode class. For example:

    The value from the A-button on gamepad 1 can be accessed using this code:
    gamepad1.a

    The Gamepad object has an attribute for each of its inputs. The buttons all return a boolean,
    true or false, to tell if the button is pressed. From the example above, if the a button on
    gamepad 1 was pressed then the following would return true:

    gamepad1.a == true

    All the information that a controller can give you is listed in the FTC SDK JavaDoc which can be
    found at this link: https://javadoc.io/doc/org.firstinspires.ftc


    Because this is just for illustration purposes, I won't go in depth to all the things you might
    put in each of these subsystem classes. For more in depth help with controlling different parts
    of your robot, I will encourage you to look at https://gm0.org and https://www.ctrlaltftc.com/
    Game manual 0 (gm0) is a great resource for all things FTC from team management to robot
    specific stuff. CTR + ALT + FTC is a wonderful resource for any kind of control theory usage in
    FTC.

    The next step in this tutorial is the first sample appendage for our robot class. Return to the
    A_RobotClassBreakdown file at line 49.
     */
}