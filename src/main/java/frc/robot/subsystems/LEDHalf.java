/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;
import java.awt.Color;

public class LEDHalf extends SubsystemBase {
  public static AddressableLED led;
  public static AddressableLEDBuffer m_buffer;
  public static Color purple, gold;
  public Color[] color;
  /**
   * Creates a new LEDHalf.
   */
  public LEDHalf() {
    led = new AddressableLED(1);
    m_buffer = new AddressableLEDBuffer(178);
    led.setLength(m_buffer.getLength());
    led.start();

    purple = new Color(84, 0, 84);
    gold = new Color(240, 100, 0);

    color = new Color[m_buffer.getLength()];

    for(int i = 0; i < m_buffer.getLength(); i++)
    {
      if(i<m_buffer.getLength()/2)
        color[i] = gold;
      else
        color[i] = purple;
      m_buffer.setRGB(i, color[i].getRed(), color[i].getGreen(), color[i].getBlue());
    }
    led.setData(m_buffer);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
