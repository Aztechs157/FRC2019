/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.commands;

import org.usfirst.frc157.FRC2019.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class setCargo extends Command {
  private boolean val;
  public setCargo(boolean setVal) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.val = setVal;
    setRunWhenDisabled(true);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.oi.cargo = val;
    System.out.println(Robot.oi.cargo);
    //Robot.oi.joystick2.setOutput(Robot.oi.LightId, Robot.oi.cargo);
    //Robot.oi.joystick2.setOutput(Robot.oi.LightId2, !Robot.oi.cargo);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
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
