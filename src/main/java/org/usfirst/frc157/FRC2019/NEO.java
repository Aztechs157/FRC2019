package org.usfirst.frc157.FRC2019;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class NEO {
    private CANSparkMax motor;
    private double ticks;
    private double offset;
	public NEO (int port, MotorType type) {
        motor = new CANSparkMax(7, MotorType.kBrushless);
        ticks = 0;
        offset = 0;
    }
    public double getPosition() {
        ticks = motor.getEncoder().getPosition();
        return ticks-offset;
    }
    public void tare() {
        ticks = motor.getEncoder().getPosition();
        offset = ticks;
    }
    public void setPosition(double position) {
        ticks = motor.getEncoder().getPosition();
        offset = ticks - position;
    }
    public double getVelocity() {
        return motor.getEncoder().getVelocity();
    }
    public void set(double speed) {
        motor.set(speed);
    }
}
