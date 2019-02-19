/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.commands;

import org.usfirst.frc157.FRC2019.OutriggerTask;
import org.usfirst.frc157.FRC2019.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FrontOutriggerController extends Command {
  public FrontOutriggerController() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.frontOutriggers);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    OutriggerTask[] tasks = Robot.frontOutriggers.tasks;
    OutriggerTask mostImportant;
    boolean[] checked = new boolean[]{false, false, false};
    int lowestIndex = 10;
    int lowest = 10;
    for (int i = 0; i < tasks.length; i++)
    {
      if (tasks[i].priority < lowest)
      {
        lowest = tasks[i].priority;
        lowestIndex = i;
      }
    }
    mostImportant = tasks[lowestIndex];
    Robot.frontOutriggers.tasks[lowestIndex].accepted = true;
    FrontOutriggerTarget target = new FrontOutriggerTarget(mostImportant.position, 
    mostImportant.speed, mostImportant.tolerance, mostImportant);
    Robot.frontOutriggers.tasks[lowestIndex].finished = target.execute();
    
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
