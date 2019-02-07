package org.usfirst.frc157.FRC2019;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.hal.util.UncleanStatusException;


public class NEO {
    private CANSparkMax motor;
    private double ticks;
    private double offset;
	public NEO (int port, MotorType type) {
        try
        {
            motor = new CANSparkMax(port, MotorType.kBrushless);
        }
        catch (UncleanStatusException e) 
        {
            System.err.println("ERROR: Spark failed at: " + port + " check connections");
        }
        ticks = 0;
        offset = 0;
    }
    public double getPosition() {
        ticks = motor.getEncoder().getPosition();
        return ticks-offset;
    }
    public void tare() {
        try {
            ticks = motor.getEncoder().getPosition();
            offset = ticks;
        } catch (NullPointerException e) {
            System.err.println(e);
        }
    }
    public void setPosition(double position) {
        try {
            ticks = motor.getEncoder().getPosition();
            offset = ticks - position;
        } catch (NullPointerException e) {
            System.err.println(e);
        }
    }
    public double getVelocity() {
        return motor.getEncoder().getVelocity();
    }
    public void set(double speed) {
        try {
            motor.set(speed);
        } catch (NullPointerException e) {
            System.err.println(e);
        }
    }
}
