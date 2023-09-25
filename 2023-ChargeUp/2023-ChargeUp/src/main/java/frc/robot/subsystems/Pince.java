// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class Pince extends SubsystemBase {
  private final DoubleSolenoid Piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.consPince.Piston_P, Constants.consPince.Piston_P2);
  /** Creates a new Pince. */
  public Pince() {}
  public void Pinceactivate(boolean activate){
  if(activate == true){
      Piston.set(Value.kForward);
  }
  else{
    Piston.set(Value.kReverse);
  }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
