// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  public final CANSparkMax m_drive_LF = new CANSparkMax(Constants.consDrivetrain.Motor_LF, MotorType.kBrushless); 
  public final CANSparkMax m_drive_LB = new CANSparkMax(Constants.consDrivetrain.Motor_LB, MotorType.kBrushless); 
  public final CANSparkMax m_drive_RF = new CANSparkMax(Constants.consDrivetrain.Motor_RF, MotorType.kBrushless); 
  public final CANSparkMax m_drive_RB = new CANSparkMax(Constants.consDrivetrain.Motor_RB, MotorType.kBrushless); 
  private final MotorControllerGroup m_leftFollower= new MotorControllerGroup(m_drive_LB, m_drive_LF);
  private final MotorControllerGroup m_rightFollower= new MotorControllerGroup(m_drive_RB, m_drive_RF);
  private final DifferentialDrive mDifferentialDrive = new DifferentialDrive(m_leftFollower, m_rightFollower);
  private final AHRS NavX = new AHRS(SerialPort.Port.kMXP);
  /** Creates a new Drivetrain. */
  double zRotation;
  double ySpeed;
  public Drivetrain() {}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public double getangle(){
    return NavX.getRawGyroX();
  }

  public void drive(double x, double y){
    zRotation = x;
    ySpeed = y;
    mDifferentialDrive.arcadeDrive(ySpeed,zRotation);
  }
}
//allo bozo