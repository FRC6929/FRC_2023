// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tourelle extends SubsystemBase {
  private final CANSparkMax m_moteur_t = new CANSparkMax(Constants.consTourelle.Motor_T, MotorType.kBrushless);
  /** Creates a new Tourelle. */
  public Tourelle() {}
  public double getEncoder() {
    return m_moteur_t.getEncoder().getPosition();
  }
  public void tournerdanslevide(double angle){
    // la tourelle a un ratio de 462:1
    double enc = 462/360 * angle;
    boolean keepgoing = true;
    while(keepgoing) {
      if(Math.floor(enc) == Math.floor(this.getEncoder())) {
        keepgoing = false;
        break;
      }
      if(enc > this.getEncoder()) {
        m_moteur_t.set(.4);
      }
      else {
        m_moteur_t.set(-.4);
      }
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
