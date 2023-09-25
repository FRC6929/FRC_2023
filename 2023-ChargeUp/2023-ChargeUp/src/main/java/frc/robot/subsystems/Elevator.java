// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  public final CANSparkMax m_motor_EUL = new CANSparkMax(Constants.consElevator.Motor_EUL, MotorType.kBrushless);
  public final CANSparkMax m_motor_EUR = new CANSparkMax(Constants.consElevator.Motor_EUR, MotorType.kBrushless);
  public final CANSparkMax m_motor_EL = new CANSparkMax(Constants.consElevator.Motor_EL, MotorType.kBrushless);
  public final MotorControllerGroup m_motor_EU = new MotorControllerGroup(m_motor_EUR, m_motor_EUL);
  /** Creates a new Elevator. */
  public Elevator() {}
  public void ElevatorVertical(double vvalue){

  }
  public void ElevatorLateral(double lvalue){

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
