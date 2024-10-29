package org.firstinspires.ftc.teamcode.one0938LearningBox.learningSampleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.one0938LearningBox.learningToRobot.A_RobotClassBreakdown;

@Disabled
@TeleOp (name="TeleOp Sample 1", group="Learning")
public class teleOpRobotClassImplementation extends OpMode
{
    A_RobotClassBreakdown robot;

    /*
    In our init method, we initialise the robot class. Calling the robot class's constructor also
    initialises the robot's subsystems, so we don't have to worry about anything beyond the robot
    itself.
     */
    public void init()
    {
        robot = new A_RobotClassBreakdown(hardwareMap);
    }

    /*
    In the loop, we call both the drivetrain's arcade drive method and the arm's PID method. These
    methods both interface directly with the objects of the devices they control so all we have to
    do in the OpMode is give them the information they need and they will make the robot perform its
    tasks.
     */
    public void loop()
    {
        robot.drivetrain.teleOpArcadeDrive(gamepad1.left_stick_x,
                                           gamepad1.right_stick_y,
                                           gamepad1.right_bumper);
        robot.arm.armPID(gamepad1.b);
    }
    /*
    This OpMode would allow a user to control the robot's differential drivetrain using the gamepad
    sticks and right bumper, and toggle between two arm positions using a PID control system by
    pressing the B-button.
     */
}

/*
This is the end of the simple introductory programming tutorial. There are other sample OpModes in
the package one0938VanillaSampleOpModes if you want more examples.

To continue to the FTCLib portion of this tutorial, navigate to the package learningFTCLibRobotClass
and open the Robot file.
 */