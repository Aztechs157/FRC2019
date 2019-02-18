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


import org.usfirst.frc157.FRC2019.PID;
import org.usfirst.frc157.FRC2019.NEO;

import org.usfirst.frc157.FRC2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANDigitalInput.LimitSwitch;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private NEO driveRight1;
    private NEO driveLeft1;
    private NEO driveRight2;
    private NEO driveLeft2;
    public AnalogGyro gyro;

    public PID turnPID = new PID(0.0045, 0, 0.0000003, 9999999, 9999999, 9999999, 999999);
    public PID drivePID = new PID(0.0045, 0, 0.0000003, 9999999, 9999999, 9999999, 999999);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public void mechDrive(double speed, double turn, double strafe) {
        double frontLeft = -speed + turn - strafe;
        double backLeft = -speed + turn + strafe; 
        double frontRight = speed + turn - strafe; 
        double backRight = speed + turn + strafe; 
        
        driveRight1.set(frontRight);
        driveRight2.set(backRight);
        driveLeft1.set(frontLeft);
        driveLeft2.set(backLeft);
      }

    public Drive() {

        gyro = new AnalogGyro(0);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveRight1 = new NEO(1, MotorType.kBrushless);
        driveRight1.setIdleMode(IdleMode.kCoast);
        
        
        
        driveLeft1 = new NEO(2, MotorType.kBrushless);
        driveLeft1.setIdleMode(IdleMode.kCoast);
        
        
        driveRight2 = new NEO(3, MotorType.kBrushless);
        driveRight2.setIdleMode(IdleMode.kCoast);
        
        
        driveLeft2 = new NEO(4, MotorType.kBrushless);
        driveLeft2.setIdleMode(IdleMode.kCoast);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    public double getAngle() {
        return gyro.getAngle();
    }
    public double getRightEncoder() {
        return driveRight1.getPosition();
    }
    
    public double getLeftEncoder() {
        return driveLeft1.getPosition();
    }
    public void tankDrive(double speed, double turn){
        double right = -speed - turn;
        double left = speed - turn;
        driveRight1.set(right);
        driveRight2.set(right);
        driveLeft1.set(left);
        driveLeft2.set(left);
    }
  

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveController());

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

}

