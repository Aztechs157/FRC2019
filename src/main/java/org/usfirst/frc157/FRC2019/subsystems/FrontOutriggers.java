// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc157.FRC2019.subsystems;

import org.usfirst.frc157.FRC2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import org.usfirst.frc157.FRC2019.PID;
import org.usfirst.frc157.FRC2019.NEO;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import org.usfirst.frc157.FRC2019.OutriggerTask;

/**
 *
 */
public class FrontOutriggers extends Subsystem {
    public static double hatchTarget = -7;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // public CANSparkMaxfrontOutrigger;
    public NEO frontOutrigger1;
    public NEO frontOutrigger2;

    public PID yawFrontPID1 = new PID(0.1, 0, 0.000002, 9999999, 9999999, 9999999, 999999);
    public PID yawFrontPID2 = new PID(0.1, 0, 0.000002, 9999999, 9999999, 9999999, 999999);
    public PID yawFrontLandingPID1 = new PID(0.3, 0, 0.00002, 9999999, 9999999, 9999999, 999999);
    public PID yawFrontLandingPID2 = new PID(0.3, 0, 0.00002, 9999999, 9999999, 9999999, 999999);
    public int liftTask = 0;
    public int climbTask = 1;
    public int antitipTask = 2;
    public OutriggerTask[] tasks = new OutriggerTask[]{new OutriggerTask(0, 0, 9, 0),
        new OutriggerTask(0, 0, 9, 0), new OutriggerTask(0, 0, 9, 0)};

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public FrontOutriggers() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
       //frontOutrigger = new CANSparkMax(7, MotorType.kBrushless);
       frontOutrigger1 = new NEO (5, MotorType.kBrushless); //TODO: id 5
       frontOutrigger1.setIdleMode(IdleMode.kBrake);
       frontOutrigger2 = new NEO (7, MotorType.kBrushless); //TODO: id 7
       frontOutrigger2.setIdleMode(IdleMode.kBrake);
       frontOutrigger2.setInverted(true);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new FrontOutriggerController());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void move(double rightSpeed, double leftSpeed)
    {
       frontOutrigger1.set(rightSpeed);
       frontOutrigger2.set(leftSpeed);
       
    }
}