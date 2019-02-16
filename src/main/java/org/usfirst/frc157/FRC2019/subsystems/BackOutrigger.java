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
import org.usfirst.frc157.FRC2019.PID;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class BackOutrigger extends Subsystem {
  
  public PID yawBackPID = new PID(0.09, 0, 0.0000001, 9999999, 9999999, 9999999, 999999);
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
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}