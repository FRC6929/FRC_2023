// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  private final CANSparkMax m_motor_CU = new CANSparkMax(Constants.consClimberinabox.Motor_CU, MotorType.kBrushless);
  private final CANSparkMax m_motor_CL = new CANSparkMax(Constants.consClimberinabox.Motor_CL, MotorType.kBrushless);
  /** Creates a new Climber. */
  public Climber() {}
  public void ClimberAxel(double avalue){
    m_motor_CU.set(avalue);
  }
  public void ClimberLateral(double lvalue){
    m_motor_CL.set(lvalue);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
