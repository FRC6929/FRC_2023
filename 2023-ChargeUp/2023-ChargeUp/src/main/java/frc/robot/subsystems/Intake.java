// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private final DoubleSolenoid l_piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.consIntake.Piston_IL, Constants.consIntake.Piston_IL2);
  private final DoubleSolenoid r_piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.consIntake.Piston_IR, Constants.consIntake.Piston_IR2);
  /** Creates a new Intake. */
  public Intake() {}
  public void Intakeactivate(Boolean L, Boolean R){
      if(L == true){
        l_piston.set(Value.kForward);
      }else if(L == false){
        l_piston.set(Value.kReverse);
      }if(R == true){
        r_piston.set(Value.kForward);
      }else if(R == false){
        r_piston.set(Value.kReverse);
      }
 

      
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
