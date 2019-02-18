/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.commands;

import org.usfirst.frc157.FRC2019.Robot;
import org.usfirst.frc157.FRC2019.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

public class LiftHold extends Command {
  public LiftHold() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift);
  }
  private boolean outRange()
  {
    double encoder = Robot.lift.encoder.getDistance();
    return (Lift.STARTCONSTRANGE < encoder && encoder < Lift.ENDCONSTRANGE);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.lift.moveLift(1, Lift.moveType.hold);
    if (outRange())
    {
      Robot.frontOutriggers.tasks[Robot.frontOutriggers.liftTask] = LiftController.out;
    }
    else
    {
      Robot.frontOutriggers.tasks[Robot.frontOutriggers.liftTask] = LiftController.in;

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
