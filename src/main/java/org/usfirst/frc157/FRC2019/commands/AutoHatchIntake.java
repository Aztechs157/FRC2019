/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.commands;

import java.util.ArrayList;

import org.usfirst.frc157.FRC2019.Robot;
import org.usfirst.frc157.FRC2019.Target;

import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Command;

public class AutoHatchIntake extends Command {
  private boolean isFinished;

  public AutoHatchIntake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.vision.targetLight.setDirection(Direction.kForward);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    ArrayList<Target> cargo = null;
    if (cargo.size() > 0)
    {
      Target currentTarget = new Target();
      if (cargo.size()>1)
      {
        Target largest2Targ = new Target();
        Target largest1Targ = new Target();
        if (cargo.size()>2)
        {
          ArrayList<Double> sizes = new ArrayList<Double>();
          for (int i = 0; i < cargo.size(); i++)
          {
            sizes.add(cargo.get(i).width*cargo.get(i).height);
          }
          double largest1 = 0;
          double largest2 = 0;
          
          for (int i = 0; i < cargo.size(); i++)
          {
            if (sizes.get(i) > largest1)
            {
              largest1 = sizes.get(i);
              largest1Targ = cargo.get(i);
            }
            else if (sizes.get(i) > largest2)
            {
              largest2 = sizes.get(i);
              largest2Targ = cargo.get(i);
            }
          }

        }
        else
        {
          largest1Targ=cargo.get(0);
          largest2Targ=cargo.get(1);
        }
        currentTarget.x = (largest1Targ.x+largest2Targ.x)/2.0;
        currentTarget.y = (largest1Targ.y+largest2Targ.y)/2.0;

      }
      else
      {
        currentTarget.x = cargo.get(0).x;
        currentTarget.y = cargo.get(0).y;
      }
      if ((currentTarget.width+currentTarget.height)/2>220) {
        isFinished = true;
      }
      double forward = Robot.drive.drivePID.pidCalculate(260, (currentTarget.width+currentTarget.height)/2); //176 for cargo
      double turn = Robot.drive.turnPID.pidCalculate(158, currentTarget.x);
      
      Robot.drive.tankDrive(forward*0.3, turn*0.6);
    // System.out.println("Forward: "+ forward);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.vision.targetLight.stopMotor();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
