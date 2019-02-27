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

public class OutriggerLand extends Command {
  boolean finished = false;
  double speed = 0;
  public OutriggerLand(double speed) {
    this.speed = speed;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    this.finished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //double frontValue = Robot.frontOutriggers.frontOutrigger.getPosition();
    //double backValue = Robot.backOutriggers.backOutrigger.getPosition();

    //Robot.outriggers.move((isA)?(-1):(1));
    //System.out.println("\n------\nFront: " + frontValue + "\nBack: " + backValue);
   // double moveFront = Robot.frontOutriggers.yawFrontPID.pidCalculate(frontTarget, frontValue);
    //double moveBack = Robot.backOutriggers.yawBackPID.pidCalculate(backTarget, backValue);
  //  Robot.outriggers.frontOutrigger.set(moveFront *frontSpeed);
   // Robot.outriggers.backOutrigger.set(moveBack * backSpeed);
    OutriggerTask front;
    OutriggerTask back;
    if (Robot.frontOutriggers.frontOutrigger1.getPosition() > -36 && 
    Robot.frontOutriggers.frontOutrigger2.getPosition() > -36 && 
    Robot.backOutriggers.backOutrigger1.getPosition() > -40 &&
    Robot.backOutriggers.backOutrigger2.getPosition() > -40)
    {
      front= new OutriggerTask(0, 1, 4, 1);
      back= new OutriggerTask(0, 1, 4, 1);
      this.finished = true;
    }
    else
    {
      front= new OutriggerTask(-34, 1, 2, speed);
      front.landing = true;
      back= new OutriggerTask(-37, 1, 2, speed);
      back.landing = true;
    }
    Robot.frontOutriggers.tasks[Robot.frontOutriggers.climbTask]= front;
    Robot.backOutriggers.tasks[Robot.frontOutriggers.climbTask]= back;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
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
