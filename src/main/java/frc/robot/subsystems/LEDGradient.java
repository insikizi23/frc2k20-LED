/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.awt.Color;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;

public class LEDGradient extends SubsystemBase {
  public static AddressableLED led;
  public static AddressableLEDBuffer m_Buffer;
  public int counter;
  public Color gold, purple;
  /**
   * Creates a new LEDGradient.
   * 
   */
  public LEDGradient() {
    led = new AddressableLED(1);
    m_Buffer = new AddressableLEDBuffer(178);
    purple = new Color(84, 0, 84);
    gold = new Color(240, 100, 0);
    counter = 0;
    led.setLength(m_Buffer.getLength());
    led.start();

    for(int i = 0; i < m_Buffer.getLength(); i++)
    {
      m_Buffer.setRGB(i, 0, 0, 0);
    }
    led.setData(m_Buffer);
  }
  

  @Override
  public void periodic() {
    if(counter<m_Buffer.getLength())
    {
      m_Buffer.setRGB(counter, gold.getRed()-counter, gold.getGreen()-counter, counter); // gold
     //  .setRGB(i, 127, i, 127); // purple
     counter++;
    }
    else{
      counter = 0;
      for(int i = 0; i<m_Buffer.getLength(); i++){
        m_Buffer.setRGB(i, 0, 0, 0);
      }
    }
    Timer.delay(0.05);
    led.setData(m_Buffer);
    // This method will be called once per scheduler run
    
  }
}
