// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase {
  private final Intake m_intake;
  private boolean m_which;
  private boolean m_activeL = false;
  private boolean m_activeR = false;
  /** Creates a new IntakeCommand. */
  public IntakeCommand(Intake intake, boolean which) {
    m_intake = intake;
    m_which = which;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(!m_which){
      m_activeL = !m_activeL;
    }if(m_which){
      m_activeR = !m_activeR;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override

  public void execute() {
    SmartDashboard.putBoolean("Intake L", m_activeL);
    SmartDashboard.putBoolean("intake R",m_activeR);
    m_intake.Intakeactivate(m_activeL,m_activeR);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
