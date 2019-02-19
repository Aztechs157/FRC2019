/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.commands;

import org.usfirst.frc157.FRC2019.OutriggerTask;
import org.usfirst.frc157.FRC2019.Robot;
import org.usfirst.frc157.FRC2019.subsystems.FrontOutriggers;

import edu.wpi.first.wpilibj.command.Command;

public class AllUp extends Command {
  public final OutriggerTask frontPos = new OutriggerTask(0, 0, 4, 1);
  public final OutriggerTask backPos = new OutriggerTask(0, 0, 2, 1);
  public final OutriggerTask nullPos = new OutriggerTask(-0, 0, 9, 1);
  public AllUp() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.frontOutriggers.tasks[Robot.frontOutriggers.antitipTask] = frontPos;
    Robot.backOutriggers.tasks[Robot.backOutriggers.antitipTask] = backPos;

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
    Robot.backOutriggers.tasks[Robot.backOutriggers.antitipTask] = nullPos;
    Robot.backOutriggers.tasks[Robot.backOutriggers.antitipTask] = nullPos;
  }
}
