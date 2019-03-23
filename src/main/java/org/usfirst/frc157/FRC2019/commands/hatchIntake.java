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

public class hatchIntake extends Command {
  private boolean in;
  double targetPos;

  public hatchIntake(boolean in) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift);
    this.in = in;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    targetPos = Robot.lift.encoder.getDistance();
    targetPos += (in)?8:-4;
    targetPos = (targetPos > Lift.TOP)?Lift.TOP:targetPos;
    targetPos = (targetPos < Lift.BOTTOM)?Lift.BOTTOM:targetPos;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.lift.moveLift(1, targetPos);

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
