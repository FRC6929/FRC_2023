// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pince;

public class PinceCommand extends CommandBase {
  private final Pince m_pince;
  private boolean m_active = false;
  /** Creates a new PinceCommand. */
  public PinceCommand(Pince pince) {
    m_pince = pince;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pince);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_active = !m_active;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("Pince", m_active);
    m_pince.Pinceactivate(m_active);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
