// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc157.FRC2019;

import org.usfirst.frc157.FRC2019.commands.*;
import org.usfirst.frc157.FRC2019.subsystems.Lift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Joystick joystick1;
    public Joystick joystick2;
    public JoystickButton R1;
    public JoystickButton Y;
    public JoystickButton A;
    public JoystickButton X;
    public JoystickButton B;
    public JoystickButton BACK; //NUMBER!!! -4.35
    public JoystickButton BOTTOM;
    public JoystickButton LEVEL1;
    public JoystickButton LEVEL2; 
    public JoystickButton TOP; 
    public JoystickButton HATCHINTAKE; 
    public JoystickButton HATCHOUTAKE; 
    public JoystickButton OSB; 
    public JoystickButton FRONTOSB; 
    public JoystickButton BACKOSB; 
    public JoystickButton ALLUP; 
    public JoystickButton ALLDOWN; 
    public JoystickButton SWITCH; 
    
    public boolean cargo = true;
    public static OutriggersController getOffHab2 = new OutriggersController(-54, -41, 0.65);// -40 48 for hab 2
    public static OutriggersController climb = new OutriggersController(-43, -51, 0.65);
    public int LT = 2;
    public int RT = 3;

	public OI() {
        System.out.println("Happy Robot");
        joystick1 = new Joystick(0);
        joystick2 = new Joystick(1);
        R1 = new JoystickButton(joystick1, 6);
        SWITCH = new JoystickButton(joystick2, 16);
        R1.whenPressed(new processVision());
        SWITCH.whenPressed(new setCargo(true));
        SWITCH.whenReleased(new setCargo(false));
        if (Robot.key.get())
        {
            HATCHINTAKE = new JoystickButton(joystick2, 15); 
            HATCHOUTAKE = new JoystickButton(joystick2, 14); 
            OSB = new JoystickButton(joystick2, 3); 
            FRONTOSB = new JoystickButton(joystick2, 4); 
            BACKOSB = new JoystickButton(joystick2, 1); 
            ALLUP = new JoystickButton(joystick2, 5); 
            ALLDOWN = new JoystickButton(joystick2, 2); 
            Y = new JoystickButton(joystick1, 4);
            A = new JoystickButton(joystick1, 1);
            X = new JoystickButton(joystick1, 3);
            B = new JoystickButton(joystick1, 2);
            BACK = new JoystickButton(joystick1, 7);
            BOTTOM = new JoystickButton(joystick2, 9);
            LEVEL1 = new JoystickButton(joystick2, 11);
            LEVEL2 = new JoystickButton(joystick2, 12);
            TOP = new JoystickButton(joystick2, 13);
            Y.whenPressed(new OutriggerLand(0.25));
            A.whenPressed(climb);//-40 48 for hab 2
            A.cancelWhenPressed(getOffHab2);
            B.whenPressed(new Antitip(true, false));
            B.whenReleased(new CancelAntiTip());
            //X.whenPressed(new Deploy());
            X.whenPressed(new Antitip(false, true));
            X.whenReleased(new CancelAntiTip());
            BOTTOM.whileHeld(new LiftController(0));
            LEVEL1.whileHeld(new LiftController(1));
            LEVEL2.whileHeld(new LiftController(2));
            TOP.whileHeld(new LiftController(3));
            //B.whenPressed(new EncoderReadout(Robot.backOutriggers.backOutrigger));  
            BACK.whenPressed(new LiftEncoderReadout());      
            HATCHINTAKE.whenPressed(new hatchIntake(true)); 
            HATCHOUTAKE.whenPressed(new hatchIntake(false)); 
            OSB.whenPressed(new Antitip(true, true)); 
            FRONTOSB.whenPressed(new Antitip(true, false)); 
            BACKOSB.whenPressed(new Antitip(false, true)); 
            OSB.whenReleased(new CancelAntiTip());
            FRONTOSB.whenReleased(new CancelAntiTip());
            BACKOSB.whenReleased(new CancelAntiTip());
            //ALLUP.whileHeld(new); 
            //ALLDOWN.whileHeld(new); 

            Robot.frontOutriggers.frontOutrigger1.tare();
            Robot.frontOutriggers.frontOutrigger2.tare();
            Robot.backOutriggers.backOutrigger1.tare();
            Robot.backOutriggers.backOutrigger2.tare();
        }


        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS



        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveController", new DriveController());
        SmartDashboard.putData("IntakeController", new IntakeController());
        //SmartDashboard.putData("VisionController", new VisionController());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    public Joystick getJoystick()
    {
        return joystick1;
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

