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
import org.usfirst.frc157.FRC2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANDigitalInput.LimitSwitch;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private CANSparkMax driveRight1;
    private CANSparkMax driveLeft1;
    private CANSparkMax driveRight2;
    private CANSparkMax driveLeft2;
    private static DigitalInput limitSwitch1;
    public PID turnPID = new PID(0.002, 0, 0.0000003, 9999999, 9999999, 9999999, 999999);
    public PID drivePID = new PID(0.002, 0, 0.0000003, 9999999, 9999999, 9999999, 999999);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public void mechDrive(double speed, double turn, double strafe) {
        double frontLeft = -speed + turn - strafe;
        double backLeft = -speed + turn + strafe; 
        double frontRight = speed + turn - strafe; 
        double backRight = speed + turn + strafe; 
       // driveRight1.set(frontRight);
       // driveRight2.set(backRight);
        //driveLeft1.set(frontLeft);
        //driveLeft2.set(backLeft);
      }

    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveRight1 = new CANSparkMax(1, MotorType.kBrushless);
        
        
        
        driveLeft1 = new CANSparkMax(2, MotorType.kBrushless);
        
        
        
        driveRight2 = new CANSparkMax(3, MotorType.kBrushless);
        
        
        
        driveLeft2 = new CANSparkMax(4, MotorType.kBrushless);
        
        limitSwitch1 = new DigitalInput(0); 
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    public void tankDrive(double speed, double turn)
  {        if (limitSwitch1.get() == true)
    {
        driveLeft1.set(0);
        driveLeft2.set(0);
        driveRight1.set(0);
        driveRight2.set(0);
    }
    else{
    double right = -speed - turn;
    double left = speed - turn;
    //driveRight1.set(right);
    //driveRight2.set(right);
    //driveLeft1.set(left);
    //driveLeft2.set(left);
    }
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

