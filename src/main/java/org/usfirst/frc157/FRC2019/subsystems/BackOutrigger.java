/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.usfirst.frc157.FRC2019.NEO;
import org.usfirst.frc157.FRC2019.OutriggerTask;
import org.usfirst.frc157.FRC2019.PID;
import org.usfirst.frc157.FRC2019.commands.BackOutriggerController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class BackOutrigger extends Subsystem {
  
  public PID yawBackPID = new PID(0.28, 0, 0.000009, 9999999, 9999999, 9999999, 999999);
  public PID yawBackLandingPID = new PID(0.3, 0, 0.00002, 9999999, 9999999, 9999999, 999999);

  public int liftTask = 0;
  public int climbTask = 1;
  public int antitipTask = 2;
  public OutriggerTask[] tasks = new OutriggerTask[]{new OutriggerTask(0, 0, 9, 0),
    new OutriggerTask(0, 0, 9, 0), new OutriggerTask(0, 0, 9, 0)};
  public NEO backOutrigger;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public BackOutrigger()
  {
    backOutrigger = new NEO (6, MotorType.kBrushless);
    backOutrigger.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new BackOutriggerController());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
