/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimeLightSub extends SubsystemBase {
  public static NetworkTable table;
  public static NetworkTableEntry tx, ty, ta;
  public double x, y, area, distance;
  /**
   * Creates a new LimeLightSub.
   */
  public LimeLightSub() {
   // table = new NetworkTable(null, null);
    //tx = new NetworkTableEntry(inst, handle);
    //ty = new NetworkTableEntry(inst, handle);
    //ta = new NetworkTableEntry(inst, handle);
    x = 0;
    y = 0;
    area = 0;
    distance = 0;
  }

  public double getDistance(){
    
    return distance;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
