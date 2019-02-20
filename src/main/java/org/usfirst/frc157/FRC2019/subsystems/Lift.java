// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc157.FRC2019.subsystems;


import org.usfirst.frc157.FRC2019.PID;
import org.usfirst.frc157.FRC2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Lift extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public WPI_TalonSRX lift;
    //public PID upPID = new PID(0.5, 0, 0.00002, 999999, 99999, 999999, 9999999);
    private PID downPID = new PID(0.1, 0, 0, 999999, 99999, 999999, 9999999);
    //public PID holdPID = new PID(0.01, 0, 0, 999999, 99999, 999999, 9999999);

    public Encoder encoder;
    public static final double BOTTOM = 0;
    public static final double STARTUPRANGE = 0;
    public static final double STARTDOWNRANGE = 100;
    public static final double STARTCONSTRANGE = 1;
    public static final double ENDUPRANGE = 0;
    public static final double ENDDOWNRANGE = 15;
    public static final double ENDCONSTRANGE = 23;

    public static final double TOP = 88;
    public static final double CARGO1 = 27;
    public static final double CARGO2 = 61;
    public static final double CARGOSHIP = 46.5;
    public static final double HATCH1 = 15;
    public static final double HATCH2 = 49.5;
    public static final double HATCH3 = 84;
    
    public double holdPosition = 0;

    public static enum moveType
    {
        hold(0),
        toHeight(0),
        toStartConstPoint(STARTCONSTRANGE+1),
        toEndConstPoint(ENDCONSTRANGE),
        toTop(TOP),
        toBottom(BOTTOM);

        public double height;
        private moveType(double height) {this.height = height;}
    }

    public moveType lastMoveType = moveType.hold;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Lift() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        lift = new WPI_TalonSRX(6);
        lift.setInverted(true);
        encoder = new Encoder(8, 9, false, EncodingType.k4X);
        encoder.setDistancePerPulse(0.01968506996);
        encoder.setReverseDirection(true);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    public void moveLift(double movement, double position)
    {
        moveType target = moveType.toHeight;
        target.height = position;
        moveLift(movement, target);

    }
    public void moveLift(double movement, moveType type)
    {
        movement = Math.abs(movement);
        if (type == moveType.toHeight)
        {
            //System.out.println(type.height);
            //System.out.println("Encoder: " + encoder.getDistance());
        }
        else
        {
            //System.out.println(type);
        }
        if (type == moveType.hold)
        {

            double value = 0;

            if (lastMoveType != moveType.hold) {
                lastMoveType = moveType.hold;
                holdPosition = encoder.getDistance();
            }
            value = downPID.pidCalculate(holdPosition, encoder.getDistance());
            lift.set(value);
        }
        else
        {
            
            double value = 0;
            if (encoder.getDistance() > type.height)
            {
                value = downPID.pidCalculate(type.height, encoder.getDistance());
            }
            else 
            {
                value = downPID.pidCalculate(type.height, encoder.getDistance());
            }
            //System.out.println("Value: "+ value);

            lift.set(value * movement);
        }
        lastMoveType = type;
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new LiftHold());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

