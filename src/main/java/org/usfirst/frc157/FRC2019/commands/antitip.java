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

public class Antitip extends Command {
  public final OutriggerTask frontPos = new OutriggerTask(-36, 0, 2, 0.85);
  public final OutriggerTask backPos = new OutriggerTask(-36, 0, 2, 0.85);
  public static final OutriggerTask nullPos = new OutriggerTask(0, 0, 8, 0.85);
  boolean front;
  boolean back;
  public Antitip(boolean front, boolean back) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.subsystem1);
    this.front = front;
    this.back = back;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (front){Robot.frontOutriggers.tasks[Robot.frontOutriggers.antitipTask] = frontPos;}
    if (back){Robot.backOutriggers.tasks[Robot.backOutriggers.antitipTask] = backPos;}

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
