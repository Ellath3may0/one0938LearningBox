package org.firstinspires.ftc.teamcode.one0938LearningBox.learningToRobot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Arm
{
    /*
    Our arm for this example is going to be a simple single motor pendulum arm so we only need 1
    motor.
     */

    DcMotor arm;

    /*
    These variables are constants and a timer for a later method.
     */
    double Kp = 0;
    double Ki = 0;
    double Kd = 0;

    int toggleState = 0;
    int target = 0;
    double integralSum = 0;
    double lastError = 0;

    ElapsedTime timer = new ElapsedTime();


    public Arm(HardwareMap hardwareMap)
    {
        arm = hardwareMap.get(DcMotor.class, "arm");
    }

    /*
    For this example, I'm going to make an example of a PID control method for more information on
    how these work, visit the pages that describe their inner workings and how to implement them.
     */

    /**This method uses a PID loop to switch between 2 arm positions
     * @param toggle A boolean button input to toggle between arm target positions
     */
    public void armPID(boolean toggle)
    {
        /*
        This switch isn't itself a part of the PID calculation. It's just a toggle for the target
        position of the arm
         */
        switch(toggleState)
        {
            case 0:
                if (toggle)
                {
                    toggleState++;
                    target = 200;
                }
                break;
            case 1:
                if (!toggle)
                {
                    toggleState++;
                }
                break;
            case 2:
                if (toggle)
                {
                    toggleState++;
                    target = 0;
                }
                break;
            case 3:
                if (!toggle)
                {
                    toggleState = 0;
                }
                break;
        }

        /*
        This code is for the PID controller. If you want more information about how a PID controller
        works or more examples of implementation, visit CTRL + ALT + FTC's breakdown on the topic at
        this link: https://www.ctrlaltftc.com/the-pid-controller
         */
        // motorPosition, error, and target are the three pieces of positional information that the
        // PID controller uses to calculate an output.
        int motorPosition = arm.getCurrentPosition();
        int error = target - motorPosition;

        // This is a very quick-and-dirty rate-of-change calculation of the time between the last
        // loop execution of this method and the current. If you are unfamiliar with the idea of
        // derivatives (calculus) you may want to familiarise yourself.
        double derivative = (error - lastError) / timer.seconds();

        // The integralSum is the opposite of the last one, instead of being the rate of change, it
        // represents the total change over time. This roughly equates to the current position of
        // the arm, and is an approximate integral (calculus; familiarise yourself with the concept)
        // of the function of your PID controller.
        integralSum += error * timer.seconds();

        // Here is where all of our calculated values are brought together with our P, I, and D
        // constants (which would need to be calibrated) to create the output power for the arm.
        double power = (Kp * error) + (Ki * integralSum) + (Kd * derivative);

        // Once the power is calculated it gets applied to the motor
        arm.setPower(power);

        // The persistent variable lastError is set to the current error value to be used in the
        // next loop
        lastError = error;

        // The timer is reset to be used in the next loop to show how much time has passed (used to
        // calculate the derivative and the integral of the PID function)
        timer.reset();
    }
    /*
    PID loops are used most frequently for controlling arms in such a way that they can accurately
    and consistently target a specific position using motion profiling dependent on the constants
    Kp, Ki, and Kd declared earlier. This method of controller is one of the better options for
    controlling any appendage that experiences external forces, but it is complicated for newer
    programmers, and requires calibration.

    Now you can head back over to A_RobotClassBreakdown and continue from line 57.
     */
}
