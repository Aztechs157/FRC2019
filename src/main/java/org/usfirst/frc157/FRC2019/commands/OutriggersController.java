// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc157.FRC2019.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc157.FRC2019.OutriggerTask;
import org.usfirst.frc157.FRC2019.Robot;

/**
 *
 */
public class OutriggersController extends Command {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATION
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    //private int position;
    private int frontTarget = 0;
    private int backTarget = 0;
    private double speed = 0;
    //private float frontSpeed = 0;
    //private float backSpeed = 0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public OutriggersController( int frontTarget, int backTarget, double speed)
    {
        
      //  this.frontSpeed = frontSpeed;
       // this.backSpeed = backSpeed;
       this.frontTarget = frontTarget;
       this.backTarget = backTarget;
       this.speed = speed;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
       // this.frontTarget = Robot.frontOutriggers.frontOutrigger.getPosition();;
        //this.backTarget = Robot.backOutriggers.backOutrigger.getPosition();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute()
    {
       // double moveFront = Robot.frontOutriggers.yawFrontPID.pidCalculate(frontTarget, frontValue);
        //double moveBack = Robot.backOutriggers.yawBackPID.pidCalculate(backTarget, backValue);
      //  Robot.outriggers.frontOutrigger.set(moveFront *frontSpeed);
       // Robot.outriggers.backOutrigger.set(moveBack * backSpeed);
        OutriggerTask front= new OutriggerTask(frontTarget, 1, (frontTarget < -25)?2:4, speed) ;
        OutriggerTask back= new OutriggerTask(backTarget, 1, (backTarget<-30)?2:4, speed);
        Robot.frontOutriggers.tasks[Robot.frontOutriggers.climbTask]= front;
        Robot.backOutriggers.tasks[Robot.frontOutriggers.climbTask]= back;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished()
    {
        return true;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
