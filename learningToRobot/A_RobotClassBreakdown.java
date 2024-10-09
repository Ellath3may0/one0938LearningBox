package org.firstinspires.ftc.teamcode.one0938LearningBox.learningToRobot;
/*
FTC doesn't provide a class for a robot object. This means that most teams will just create the same
robot parts over and over in every OpMode they make each season, and start over from scratch each
year. This wastes time and effort in areas that could be easily avoided.

The solution:
Robot classes

There's no strict definition of a robot class, and no defined "best way" to do one. Every robot is
going to be different and include different mechanisms that will need different information and use
different methods, but we can use common features of robots to make a template that is easy to
rework as needed, and most importantly save time in the long term.

When I think of a robot class, I picture a wrapper class that points to more wrapper classes
that represent different subsystems on a robot. Sometimes, a subsystem will have further subsystems
within it. Creating these levels of organisation is vital in the long term as your robot's become
more complicated.


When making a robot class, things can get messy quick. If you don't organise you teamcode package,
it might become very difficult to navigate and get work done. In general, it is best to organise
your teamcode package however works best for you, but I would recommend making separate packages for
calibration OpModes, TeleOp OpModes, Autonomous OpModes, and a dedicated for your robot class and
subsystem classes.

Our class declaration doesn't matter too much. Because FTC doesn't have any form of robot class or
interface, there's nothing to extend or implement. We just create a class that will represent our
robot and import into each of our OpModes. This class itself will become an interface for our
OpModes to use to control our robot, without having inconsistencies in robot behaviour across
programs.
 */
public class A_RobotClassBreakdown
{
    /*
    Most robots have common features that make for easy subsystems on our robot. Here, I am going to
    declare a few objects of classes we're going to be making for those subsystems. As I make those
    declarations, I'll direct you to the classes being instantiated here so you can get a closer
    look at how each of those subsystems might be setup in a robot class.
     */

    // Our first subsystem is going to be our drivetrain. Navigate to the java file "Drivetrain"
    Drivetrain drivetrain;
    /*
    You may have noticed that I didn't need to import the Drivetrain class in order to use it here.
    Because the Drivetrain class and this class ("A_RobotClassBreakdown") are both in the same
    "learningToRobot" package, they don't need to be explicitly imported.
     */

    //Up next is a sample robot arm. Navigate to the java file "Arm".
    Arm arm;

}
