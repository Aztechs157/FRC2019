/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.commands;

import org.usfirst.frc157.FRC2019.OutriggerTask;
import org.usfirst.frc157.FRC2019.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class FrontOutriggerTarget{
  private double frontTarget;
  private double frontSpeed;
  private double tolerance;
  private OutriggerTask task;

  public FrontOutriggerTarget(double frontTarget, double frontSpeed, double tolerance, OutriggerTask task) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.frontTarget = frontTarget;
    this.frontSpeed = frontSpeed;
    this.tolerance = tolerance;
    this.task = task;
  }
  

  // Called repeatedly when this Command is scheduled to run
  public boolean execute() {
    
    double rightValue = Robot.frontOutriggers.frontOutrigger1.getPosition();
    double leftValue = Robot.frontOutriggers.frontOutrigger2.getPosition();

    //Robot.outriggers.move((isA)?(-1):(1));
    //System.out.println("\n------\nFront: " + frontValue + "\nBack: " + backValue);
    double moveRight;
    double moveLeft;
    if (task.landing)
    {
      moveRight = Robot.frontOutriggers.yawFrontLandingPID.pidCalculate(frontTarget, rightValue);
      moveLeft = Robot.frontOutriggers.yawFrontLandingPID.pidCalculate(frontTarget, leftValue);
    }
    else
    {
      moveRight = Robot.frontOutriggers.yawFrontPID.pidCalculate(frontTarget, rightValue);
      moveLeft = Robot.frontOutriggers.yawFrontPID.pidCalculate(frontTarget, leftValue);
    }
    Robot.frontOutriggers.frontOutrigger1.set(moveRight * frontSpeed);
    Robot.frontOutriggers.frontOutrigger2.set(moveLeft * frontSpeed);
    return isFinished();
  }

  // Make this return true when this Command no longer needs to run execute()
  public boolean isFinished() {
    return (Math.abs(frontTarget-Robot.frontOutriggers.frontOutrigger1.getPosition())+
    Math.abs(frontTarget-Robot.frontOutriggers.frontOutrigger2.getPosition()))<tolerance;
  }

}
