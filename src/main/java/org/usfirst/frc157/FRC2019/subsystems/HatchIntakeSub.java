/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc157.FRC2019.commands.HatchController;

/**
 * Add your docs here.
 */
public class HatchIntakeSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX mainMotor;
  public Encoder encoder;
  public int talonId;
  public int EncoderIdA;
  public int EncoderIdB;
  public double P = 0.002;
  public double I = 0;
  public double D = 5E-8;
  public boolean state = true; //true = closed on hatch, false = open to intake new hatch

  public HatchIntakeSub()
  {
    mainMotor = new WPI_TalonSRX(19);
    encoder = new Encoder(2,3);
  }
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new HatchController());
  }
}
