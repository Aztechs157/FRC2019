/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.commands;

import org.usfirst.frc157.FRC2019.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class OutriggerTarget{
  private int frontTarget;
  private int backTarget;
  private float frontSpeed;
  private float backSpeed;
  private int tolerance;
  private boolean useBack;

  public OutriggerTarget(int frontTarget, int backTarget, float frontSpeed, float backSpeed, int tolerance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.frontTarget = frontTarget;
    this.backTarget = backTarget;
    this.frontSpeed = frontSpeed;
    this.backSpeed = backSpeed;
    this.tolerance = tolerance;
    this.useBack = true;
  }
  public OutriggerTarget(int frontTarget, boolean useBack, float frontSpeed, int tolerance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.frontTarget = frontTarget;
    this.useBack = useBack;
    this.backSpeed = 1;
    this.frontSpeed = frontSpeed;
    this.tolerance = tolerance;
    
  }
  
  // Called just before this Command runs the first time
  public void initialize() {
    if (!useBack)
    {
      this.backTarget = (int)Math.floor(Robot.outriggers.backOutrigger.getPosition());
    }
  }

  // Called repeatedly when this Command is scheduled to run
  public boolean execute() {
    
    double frontValue = Robot.outriggers.frontOutrigger.getPosition();
    double backValue = Robot.outriggers.backOutrigger.getPosition();

    //Robot.outriggers.move((isA)?(-1):(1));
    //System.out.println("\n------\nFront: " + frontValue + "\nBack: " + backValue);
    double moveFront = Robot.outriggers.yawFrontPID.pidCalculate(frontTarget, frontValue);
    double moveBack = Robot.outriggers.yawBackPID.pidCalculate(backTarget, backValue);
    Robot.outriggers.frontOutrigger.set(moveFront * frontSpeed);
    Robot.outriggers.backOutrigger.set(moveBack * backSpeed);
    return isFinished();
  }

  // Make this return true when this Command no longer needs to run execute()
  public boolean isFinished() {
    return ((Math.abs(frontTarget-Robot.outriggers.frontOutrigger.getPosition())<tolerance) &&
    (useBack?(Math.abs(backTarget-Robot.outriggers.backOutrigger.getPosition())<tolerance):true));
  }

}
