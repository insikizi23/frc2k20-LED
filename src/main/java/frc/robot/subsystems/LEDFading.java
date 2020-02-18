/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;
import java.awt.Color;

public class LEDFading extends SubsystemBase {
  public static AddressableLED led;
  public static AddressableLEDBuffer m_Buffer;
  public Color purple, gold;
  public Color[] color;
  public int currentR, currentG, currentB;
  public int differenceRed, differenceGreen, differenceBlue;
  /**
   * Creates a new LED.
   */
  public LEDFading() {
    led = new AddressableLED(1);
    m_Buffer = new AddressableLEDBuffer(178);
    led.setLength(m_Buffer.getLength());
    led.setData(m_Buffer);
    led.start();
    purple = new Color(84, 10, 84);
    gold = new Color(240, 100, 10);
    currentR = gold.getRed();
    currentG = gold.getGreen();
    currentB = gold.getBlue();

    differenceRed = (purple.getRed()-gold.getRed())/10;
    differenceGreen = (purple.getGreen()-gold.getGreen())/10;
    differenceBlue = (purple.getBlue()-gold.getBlue())/10;
    color = new Color[m_Buffer.getLength()];
    for(int i=0; i < m_Buffer.getLength(); i++){
      color[i] = new Color(0, 0, 0);
      if(currentR>=0 && currentR<=255 && currentG>=0 && currentG<=255 && currentB>=0 && currentB<=255){
        color[i] = new Color(currentR, currentG, currentB);
      }
      currentR += differenceRed;
      currentG += differenceGreen;
      currentB += differenceBlue;

      if(i!=0 && i%10==0){
        differenceRed *= -1;
        differenceGreen *= -1;
        differenceBlue *= -1;
      }
      m_Buffer.setRGB(i, color[i].getRed(), color[i].getGreen(), color[i].getBlue());
    }
    led.setData(m_Buffer);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Color temp = color[0];
    for(int i=0; i<m_Buffer.getLength()-1; i++){
      color[i] = color[i+1];
      m_Buffer.setRGB(i, color[i].getRed(), color[i].getGreen(), color[i].getBlue());
    }
    color[m_Buffer.getLength()-1] = temp;
    for(int i=0; i<m_Buffer.getLength(); i++){
      currentR += differenceRed;
      currentG += differenceGreen;
      currentB += differenceBlue;
      if(i%5==0){
        differenceRed *= -1;
        differenceGreen *= -1;
        differenceBlue *= -1;
      }
    }

    Timer.delay(0.08);
    led.setData(m_Buffer);
  }
}
