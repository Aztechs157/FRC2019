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
import org.usfirst.frc157.FRC2019.Robot;
import org.usfirst.frc157.FRC2019.subsystems.Lift;
import org.usfirst.frc157.FRC2019.subsystems.Lift.moveType;

/**
 *
 */
public class LiftController extends Command {
    OutriggerTarget out = new OutriggerTarget(19, false, 1.0f, 1);
    OutriggerTarget in = new OutriggerTarget(0, false, 1.0f, 1);
    State currentState = State.REST;
    public static final double tolerance = 0.1;
    public static final int OUTRIGGERRANGE = 18;
    enum State
    {
        UP,
        DOWN,
        REST,
        OUT
    };


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public LiftController() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lift);
        requires(Robot.outriggers);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }
    private boolean outRange()
    {
        return true;
    }
    private boolean upOutRange()
    {
        return true;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double up = Robot.oi.joystick1.getRawAxis(3);
        double down = Robot.oi.joystick1.getRawAxis(2);
        double movement = up-down;
        if (outRange())
        {
            if (movement < -tolerance || movement > tolerance)
            {
                if (Robot.outriggers.frontOutrigger.getPosition() < OUTRIGGERRANGE)
                {
                    if (currentState != State.OUT)
                    {
                        out.initialize();
                    }
                    out.execute();
                    Robot.lift.moveLift(movement, Lift.moveType.hold);
                }
                else
                {
                    out.execute();
                    if (movement > tolerance)
                    {
                        Robot.lift.moveLift(movement, Lift.moveType.toTop);
                    }
                    else if (movement < -tolerance)
                    {
                        Robot.lift.moveLift(movement, Lift.moveType.toBottom);
                    }
                }
                currentState = State.OUT;
            }
            else
            {
                Robot.lift.moveLift(movement, Lift.moveType.hold);
            }
        }
        else if (movement > tolerance){
            if (upOutRange())
            {
                if (Robot.outriggers.frontOutrigger.getPosition() < OUTRIGGERRAMNGE)
                {
                    if (currentState != State.UP)
                    {
                        out.initialize();
                    }
                    out.execute();
                    Robot.lift.moveLift(movement, Lift.moveType.hold);
                }
                else
                {
                    in.execute();
                    Robot.lift.moveLift(movement, moveType.toTop);
                }
            }
            else
            {
                if (currentState != State.REST)
                {
                    in.initialize();
                }
                in.execute();
                if (Robot.lift.encoder.getDistance() < Lift.STARTUPRANGE)
                {
                    Robot.lift.moveLift(movement, moveType.toUpStartPoint);
                }
                else
                {
                    Robot.lift.moveLift(movement, moveType.toTop);
                }
                currentState = State.REST;
            }
        }
        else if (movement < -tolerance)
        {
            if (downOutRange())
            {
                if (Robot.outriggers.frontOutrigger.getPosition() < OUTRIGGERRAMNGE)
                {
                    if (currentState != State.DOWN)
                    {
                        out.initialize();
                    }
                    out.execute();
                    Robot.lift.moveLift(movement, Lift.moveType.hold);
                }
                else
                {
                    out.execute();
                    Robot.lift.moveLift(movement, Lift.moveType.toBottom);
                }
                currentState = State.DOWN;
            }
            else
            {
                if (currentState != State.REST)
                {
                    in.initialize();
                }
                in.execute();
                if (Robot.lift.encoder.getDistance() > Robot.lift.ENDDOWNRANGE)
                {
                    Robot.lift.moveLift(movement, Lift.moveType.toDownEndPoint);
                }
                else
                {
                    Robot.lift.moveLift(movement, Lift.moveType.toBottom);
                }
                currentState = State.REST;
            }
        }
        else
        {
            in.execute();
            Robot.lift.moveLift(movement, Lift.moveType.hold)
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
