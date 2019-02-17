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

public class BackOutriggerTarget{
  private double backTarget;
  private double backSpeed;
  private double tolerance;
  OutriggerTask task;

  public BackOutriggerTarget(double backTarget, double speed, double tolerance, OutriggerTask mostImportant) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.backTarget = backTarget;
    this.backSpeed = speed;
    this.tolerance = tolerance;
    this.task = mostImportant;
  }
  

  // Called repeatedly when this Command is scheduled to run
  public boolean execute() {
    
    double backValue = Robot.backOutriggers.backOutrigger.getPosition();

    //Robot.outriggers.move((isA)?(-1):(1));
    //System.out.println("\n------\nFront: " + frontValue + "\nBack: " + backValue);
    double moveBack;
    if (task.landing)
    {
      moveBack = Robot.backOutriggers.yawBackLandingPID.pidCalculate(backTarget, backValue);
    }
    else
    {
      moveBack = Robot.backOutriggers.yawBackPID.pidCalculate(backTarget, backValue);
    }
      Robot.backOutriggers.backOutrigger.set(moveBack * backSpeed);
    return isFinished();
  }

  // Make this return true when this Command no longer needs to run execute()
  public boolean isFinished() {
    return (Math.abs(backTarget-Robot.backOutriggers.backOutrigger.getPosition())<tolerance);
  }

}
