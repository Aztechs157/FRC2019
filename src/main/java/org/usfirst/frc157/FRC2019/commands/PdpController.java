/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.commands;



import org.usfirst.frc157.FRC2019.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PdpController extends Command {
  int counter;
  public final int loopCount = 50;
  double[] sums = new double[Robot.pdp.channels.length];
  double[] peaks = new double[Robot.pdp.channels.length];

  public PdpController() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pdp);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    counter = 0;
    sums = new double[Robot.pdp.channels.length];
    peaks = new double[Robot.pdp.channels.length];
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    for (int i = 0; i < Robot.pdp.channels.length; i++)
    {
      double current = Robot.pdp.powerDistro.getCurrent(Robot.pdp.channels[i]);
      sums[i] += current;
      if (current > peaks[i])
      {
        peaks[i] = current;
      }
    }
    if (counter < loopCount)
    {
      counter++;
    }
    else
    {
      for (int i = 0; i < Robot.pdp.channels.length; i++)
      {
        System.out.println("================");
        System.out.println("PDP channel "+Robot.pdp.channels[i]);
        System.out.println("peak    - "+peaks[i]);
        System.out.println("average - "+(sums[i]/(double)loopCount));
      }
      System.out.println("================");
      counter = 0;
      sums = new double[Robot.pdp.channels.length];
      peaks = new double[Robot.pdp.channels.length];
    }
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
