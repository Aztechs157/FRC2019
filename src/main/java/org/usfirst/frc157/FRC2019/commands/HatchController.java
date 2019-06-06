/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.commands;

import org.usfirst.frc157.FRC2019.PID;
import org.usfirst.frc157.FRC2019.Robot;
import org.usfirst.frc157.FRC2019.subsystems.HatchIntakeSub;

import edu.wpi.first.wpilibj.command.Command;

public class HatchController extends Command {
  private int count = 0;
  PID pid = new PID(Robot.hatchIntakeSub.P, Robot.hatchIntakeSub.I, Robot.hatchIntakeSub.D, 999999, 99999, 999999, 9999999);
  public HatchController() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.hatchIntakeSub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    pid.p = Robot.hatchIntakeSub.P;
    pid.i = Robot.hatchIntakeSub.I;
    pid.d = Robot.hatchIntakeSub.D;
    double moveVal = 0;
    if (Robot.hatchIntakeSub.state)
    {
      moveVal = pid.pidCalculate(0, Robot.hatchIntakeSub.encoder.getDistance());
    }
    else
    {
      moveVal = pid.pidCalculate(535, Robot.hatchIntakeSub.encoder.getDistance());
    }
    Robot.hatchIntakeSub.mainMotor.set(-moveVal);
    if (count%30 == 0) {
      /*System.out.println("Hatch Power: "+ moveVal);
      System.out.println("Hatch Encoder: "+ Robot.hatchIntakeSub.encoder.getDistance());*/
    }
    count++;
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
