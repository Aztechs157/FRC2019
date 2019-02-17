/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc157.FRC2019;

/**
 * Add your docs here.
 */
public class OutriggerTask {
    public double speed;
    public double position;
    public int priority;
    public double tolerance;
    public boolean landing = false;
    public boolean accepted = false;
    public boolean finished = false;
    public OutriggerTask(double position, int tolerance, int priority, double speed)
    {
        this.position = position;
        this.tolerance = tolerance;
        this.priority = priority;
        this.speed = speed;
    }
    public boolean isFinished(int current)
    {
        return ((position-tolerance)<= current && current <= (position+tolerance));
    }
}
