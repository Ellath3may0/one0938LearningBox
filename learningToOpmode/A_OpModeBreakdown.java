/*
Welcome into your first step into OpModes! This OpMode is going to dive into the parts OpModes have
to offer you when you're working on robot programs. In this OpMode, we're going to discuss the parts
every OpMode has.

First of all, what is an OpMode? OpModes are the programs that your robot runs. These can be
anything from a sensor test and tests to get information about your robot, all the way to fully
fledged competition programs. Every OpMode has a few things in common though:

  - Every OpMode is written in a Java class. This is an element of object oriented programming that
    you should already be quite familiar with
  - Every OpMode extends an OpMode class. Here, we are extending OpMode. We'll talk more about other
    OpMode types later.
 */

/*
The first part of this OpMode is its package. Every class inside of your Android Studio project will
have a package line that tells the module where it is. Without a package line, your class will be
missing and your robot won't be able to use it, whether it be an OpMode or a class for a function
of your robot. Luckily, anytime you create a class, Android Studio will automatically add the
package line based off of where the class is put.
 */
package org.firstinspires.ftc.teamcode.one0938LearningBox.learningToOpmode;

/*
Next up is the import statements. This is where you are telling the Java executor what other classes
your class uses. If you notice, the classes being imported use their package location and name to
find the class and import it.
 */
import      com.qualcomm.robotcore.eventloop.opmode.Disabled;
import      com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import      com.qualcomm.robotcore.hardware.DcMotor;
import      com.qualcomm.robotcore.eventloop.opmode.OpMode;
//package-->^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^|^^^^^^<--Class name


/*
This line might look alien at first but its just called an annotation. It tells the system something
about the code that follows it. In this case, it tells the Robot Controller not to show this OpMode
on the list in the Driver Station app.
 */
@Disabled
/*
This annotation tells the Robot Controller that this OpMode is a TeleOp Mode. The arguments in
parentheses also tell the RC the name and group the OpMode should be displayed as. This OpMode type
annotation is necessary for the OpMode to appear on the DS screen. The only other OpMode type
annotation is @Autonomous, which tells the Robot Controller that this OpMode is an autonomous mode.
 */
@TeleOp (name="OpModeBreakdown", group="Learning")
/*
Next up is the class declaration. Here is where we declare the class and that it extends the OpMode
class.
 */
public class A_OpModeBreakdown extends OpMode
{
    /*
    Inside the class we can declare variables that will be used in multiple methods of our OpMode.
    However, it is best practice to assign values to these variables in the init() method, rather
    than the root of the class. If a variable is only used in one method, it is best practice to
    declare and assign that variable inside that method.
     */

    // As an example, we will create two variables. One will be a motor, the other a double
    DcMotor motor;
    double powerMultiplier;
    /*
    These variables will be used in more than one of the methods of the OpMode so they need to be in
    the scope of the class rather than any single method, but they aren't assigned here.
     */


    /*
    The init() method is code that executes once when you press the init button on the DS. Every
    OpMode must have an init() method. This is usually where variables are declared and attributes
    are given to hardware objects.
     */
    public void init()
    {
        // Here, both variables we declared are assigned a value.
        powerMultiplier = 0.8;
        /*
        The hardwareMap object referenced here is a part of the OpMode class. This object is how the
        hardware devices configured on the robot are connected to the hardware objects in the
        software. In the "get" method, we tell the hardwareMap what type of device we are looking
        for, and what it's name in the robot's configuration is. The hardwareMap object then returns
        an object of that type that refers to the correct hardware device.
         */
        motor = hardwareMap.get(DcMotor.class, "motor");

        /*
        Many parts of your robot will have extra parameters that need to be assigned for the robot
        to perform tasks as expected. As an example, we will set some parameters for our motor
        object.
         */
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motor.setPower(0);
        /*
        Each of these methods set the value of a variable for the motor object. To find out more
        about what attributes and methods every object in the SDK has, visit the FTC Robot
        Controller JavaDoc.
        https://javadoc.io/doc/org.firstinspires.ftc/RobotCore/latest/overview-summary.html
        Just make sure you pick the version that matches the release of the SDK you're using.
         */
    }

    /*
    The init_loop() method is code that is executed repeatedly after the init() method, until you
    press the start button on the DS. This is usually used to get information from sensors at the
    start of a match.
     */
    public void init_loop()
    {
        // There's no real reason to put anything here for the purpose of this tutorial
    }

    /*
    The start() method is code that is executed once as soon as you press the start button on the
    DS.
     */
    public void start()
    {
        // This code doesn't really matter for the tutorial. It's more of an example application.
        for (int i = 0; i < 5000; i++)
        {
            motor.setPower(powerMultiplier * -1);
        }
    }

    /*
    Next up is the loop() method, which runs repeatedly until you press the stop button on the DS.
    In a TeleOp mode, this is usually where the robot's loop code will go, that interprets the
    drivers' controller inputs to move the robot.
     */
    public void loop()
    {
        /*
        Here we can talk about another feature of OpModes: the gamepad objects. Every OpMode has two
        gamepad objects (gamepad1 and gamepad2) which have their own attributes that represent the
        values being returned by the controllers. In this case, we set the power of the motor to a
        relationship between the powerMultiplier variable and the input from gamepad1's left
        trigger.
         */
        motor.setPower(powerMultiplier * gamepad1.left_trigger);
    }

    /*
    Finally is the stop() method which runs once when you press the stop button on the DS.
     */
    public void stop()
    {
        // Here, we speed up the motor to its max speed.
        motor.setPower(1);
        /*
        Sadly however, as soon as the stop() method is executed, all hardware devices on the robot
        are stopped, so this line won't do much.
         */

    }

    /*
    OpModes also have more variables and interfaces you can access during their runtime. To see all
    of them, you can right click the import statement for the OpMode class, specifically over the
    word "OpMode" at the end of the line, and select the hamburger menu, then jump to source to view
    the OpMode class and all of its attributes and methods.
     */


}
