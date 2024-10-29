/*
For the purposes of the FTCLib tutorial, I made a full robot class. This class has all the
functionality of a full robot for the Center Stage FTC game. Here is a description of the robot:

Drivetrain:
4-motor differential drive (2 left, 2 right)
2-Wheel deadwheel odometry (uses integrated Inertial Measurement Unit (IMU))
  The encoders for the deadwheels are plugged into the drive encoder ports corresponding to Motors
  frontLeft and frontRight. This is good practice as these encoder ports have a higher polling rate
  than the sensor ports on the other side of a Rev hub.
  Odometry is a method of localisation that is very commmon in FTC. to learn more, visit this link:
  https://gm0.org/en/latest/docs/software/concepts/odometry.html

Manipulator (arm):
  2-Motor gear-driven 1 degree-of-freedom arm
  360 rotating wrist
  Dual-grasp claws

Vision:
  2 cameras (front and rear)
  April Tag localisation
  OpenCV object detection
 */
package org.firstinspires.ftc.teamcode.one0938LearningBox.learningFTCLibSampleTeamCode;


import com.arcrobotics.ftclib.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.one0938LearningBox.learningFTCLibSampleTeamCode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.one0938LearningBox.learningFTCLibSampleTeamCode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.one0938LearningBox.learningFTCLibSampleTeamCode.subsystems.Drivetrain;

public class Robot extends com.arcrobotics.ftclib.command.Robot
{

    public Drivetrain drivetrain;
    public Arm arm;
    public Claw claw;

    public static boolean isDisabled = true;

    public Robot(HardwareMap hardwareMap,
                 Pose2d startingPosition)
    {
        drivetrain  = new Drivetrain(hardwareMap, new Pose2d());
        arm         = new Arm(hardwareMap);
        claw        = new Claw(hardwareMap);
    }
}
