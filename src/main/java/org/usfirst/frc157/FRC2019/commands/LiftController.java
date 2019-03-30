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

import javax.lang.model.util.ElementScanner6;

import org.usfirst.frc157.FRC2019.OutriggerTask;
import org.usfirst.frc157.FRC2019.Robot;
import org.usfirst.frc157.FRC2019.subsystems.FrontOutriggers;
import org.usfirst.frc157.FRC2019.subsystems.Lift;
import org.usfirst.frc157.FRC2019.subsystems.Lift.moveType;
import org.usfirst.frc157.FRC2019.OutriggerTask;

/**
 *
 */
public class LiftController extends Command {
    //move out =  FrontOutriggercargoTarget[target](19, 0f, 1);
    public static final OutriggerTask out = new OutriggerTask(-14, 1, 3, 0.5);
    public static final OutriggerTask in = new OutriggerTask(0, 1, 5, 0.5);
    public static final OutriggerTask hatchPos = new OutriggerTask(FrontOutriggers.hatchTarget, 1, 1, 0.5);
    public static  double tolerance = 0;
    public static final double tolerance2 = 0.1;
    public static final int OUTRIGGERRANGE = -13;
    public boolean useLatch = true;
    int target = 0;
    double[] cargoTarget = new double[]{Lift.BOTTOM, Lift.CARGO1, Lift.CARGO2, Lift.TOP, Lift.HATCH2};
    double[] hatchTarget = new double[]{Lift.HATCHINTAKE, Lift.HATCH1, Lift.HATCH2, Lift.HATCH3};


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public LiftController(int target) {
        this.target = target;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lift);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    public LiftController(int target, boolean useLatch) {
        this.target = target;
        this.useLatch = useLatch;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lift);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }
    private boolean outRange()
    {
        double encoder = Robot.lift.encoder.getDistance();
        return (Lift.STARTCONSTRANGE < encoder && encoder < Lift.ENDCONSTRANGE);
    }
    private boolean upOutRange()
    {
        double encoder = Robot.lift.encoder.getDistance();
        return (Lift.STARTUPRANGE <= encoder && encoder <= Lift.ENDUPRANGE);
    }
    private boolean downOutRange()
    {
        double encoder = Robot.lift.encoder.getDistance();
        return (Lift.STARTDOWNRANGE < encoder && encoder < Lift.ENDDOWNRANGE);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double movement = target-Robot.lift.encoder.getDistance();
        tolerance = 0;
        if (useLatch && !Robot.oi.cargo )
        {
            double tolerance2=0.3;
            
            if (Robot.frontOutriggers.frontOutrigger1.getPosition() > FrontOutriggers.hatchTarget - tolerance2
            && Robot.frontOutriggers.frontOutrigger1.getPosition() < FrontOutriggers.hatchTarget+tolerance2
            && Robot.frontOutriggers.frontOutrigger2.getPosition() > FrontOutriggers.hatchTarget - tolerance2
            && Robot.frontOutriggers.frontOutrigger2.getPosition() < FrontOutriggers.hatchTarget+tolerance2)
            {
                
            }
            else
            {
                //Robot.lift.moveLift(0.85, Lift.moveType.hold);
            }
            Robot.lift.moveLift(1, hatchTarget[target]);
            Robot.frontOutriggers.tasks[Robot.frontOutriggers.liftTask] = hatchPos;
        }
        else
        {
            Robot.lift.moveLift(1, cargoTarget[target]);
            Robot.frontOutriggers.tasks[Robot.frontOutriggers.liftTask] = in;
        }
        

        
    }


    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
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
