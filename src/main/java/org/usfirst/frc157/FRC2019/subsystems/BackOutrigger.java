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
import org.usfirst.frc157.FRC2019.commands.OutriggersController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class BackOutrigger extends Subsystem {
  
  public PID yawBackPID1 = new PID(0.1, 0, 0.000002, 9999999, 9999999, 9999999, 999999);
  public PID yawBackPID2 = new PID(0.1, 0, 0.000002, 9999999, 9999999, 9999999, 999999);
  public PID yawBackLandingPID1 = new PID(0.3, 0, 0.00002, 9999999, 9999999, 9999999, 999999);
  public PID yawBackLandingPID2 = new PID(0.3, 0, 0.00002, 9999999, 9999999, 9999999, 999999);
  public static OutriggersController climb = new OutriggersController(-43, -55 /*-52*/, 0.65);
  public int liftTask = 0;
  public int climbTask = 1;
  public int antitipTask = 2;
  public OutriggerTask[] tasks = new OutriggerTask[]{new OutriggerTask(0, 0, 9, 0),
    new OutriggerTask(0, 0, 9, 0), new OutriggerTask(0, 0, 9, 0)};
    public NEO backOutrigger1;
    public NEO backOutrigger2;
    // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public BackOutrigger() 
  {
    backOutrigger1 = new NEO (6, MotorType.kBrushless); 
    backOutrigger1.setIdleMode(IdleMode.kBrake);
    backOutrigger2 = new NEO (8, MotorType.kBrushless); 
    backOutrigger2.setIdleMode(IdleMode.kBrake);
    backOutrigger2.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new BackOutriggerController());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
