/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * Add your docs here
 **/
public class OI {
    public Joystick joy;
    public JoystickButton intake, outake;
    public LEDFading fade;
    public LEDGradient grad;
    public LED led;
    public LEDHalf half;
    public HopperLED hop;
    public RainbowLED rainbow;


    public OI(){
      //fade = new LEDFading();
      // grad = new LEDGradient();
      led = new LED();
      //half = new LEDHalf();
     //hop = new HopperLED();
     joy = new Joystick(1);
     intake = new JoystickButton(joy, 2);
     outake = new JoystickButton(joy, 1);
     //rainbow = new RainbowLED();
    }
}
