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

public class RainbowLED extends SubsystemBase {
  public static AddressableLED led;
  public static AddressableLEDBuffer m_Buffer;
  public int counter, currentR, currentG, currentB;
  public Color temp, color;
  public Color[] colors;
  /**
   * Creates a new RainbowLED.
   */
  public RainbowLED() {
    led = new AddressableLED(1);
    m_Buffer = new AddressableLEDBuffer(178);
    //purple = new Color(84, 0, 84);
    temp = new Color(255, 0, 0);
    currentR = 255;
    currentG = 0;
    currentB = 0;
    counter = 0;
    colors = new Color[m_Buffer.getLength()];
    led.setLength(m_Buffer.getLength());
    led.start();

    for(int i = 0; i < m_Buffer.getLength(); i++)
    {
      if(currentR>=0 && currentR<=255 && currentG>=0 && currentG<=255 && currentB>=0 && currentB<=255){
      if(i<100)
        color = new Color(temp.getRed()-counter, temp.getGreen()-counter, counter); // gold
      else
      color = new Color(temp.getRed()-counter, 0, counter);
      colors[i] = color;
      m_Buffer.setRGB(i, colors[i].getRed(), colors[i].getGreen(), colors[i].getBlue());
      //  .setRGB(i, 127, i, 127); // purple
     counter++;
    }
    led.setData(m_Buffer);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Color temp = colors[0];

    for(int i = 0; i < m_Buffer.getLength()-1; i++)
    {
      colors[i] = colors[i+1];
      m_Buffer.setRGB(i, colors[i].getRed(), colors[i].getGreen(), colors[i].getBlue());
      //color[i+1] = color[i];
    }

    colors[colors.length-1] = temp;

    led.setData(m_Buffer);
    Timer.delay(0.08);
  }
}
