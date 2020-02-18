/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VelocityControl extends SubsystemBase {
  public TalonSRX left, right;
  public double distance;
  public LimeLightSub sub;
  /**
   * Creates a new VelocityControl.
   */
  public VelocityControl() {
    sub = new LimeLightSub();
    left = new TalonSRX(1);
    right = new TalonSRX(2);
    distance = 0;

    left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    left.setSensorPhase(true);
    left.setInverted(false);

    right.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    right.setSensorPhase(true);
    right.setInverted(false);

    left.config_kF(0, 0, 0);
    left.config_kP(0, 0.15, 0);
    left.config_kI(0, 0, 0);
    left.config_kD(0, 0.06, 0);

    right.config_kF(0, 0, 0);
    right.config_kP(0, 0.15, 0);
    right.config_kI(0, 0, 0);
    right.config_kD(0, 0.06, 0);
  }

  public void VelocityControl(){
    left.set(ControlMode.Velocity, 60);
    right.set(ControlMode.Velocity, 60);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    distance = sub.getDistance();
  }
}