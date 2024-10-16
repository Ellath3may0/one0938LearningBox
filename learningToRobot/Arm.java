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
        This isn't itself a part of the PID calculation. It's just a toggle for the target position
        of the arm
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

        int motorPosition = arm.getCurrentPosition();
        int error = target - motorPosition;

        double derivative = (error - lastError) / timer.seconds();

        integralSum += error * timer.seconds();

        double power = (Kp * error) + (Ki * integralSum) + (Kd * derivative);
        arm.setPower(power);

        lastError = error;
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
