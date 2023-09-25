// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tourelle;

public class TourelleCommand extends CommandBase {
  private final Tourelle m_tourelle;
  private Joystick m_copilote;
  private double m_angle;
  /** Creates a new TourelleCommand. */
  public TourelleCommand(Tourelle tourelle, Joystick copilote) {
    m_tourelle = tourelle;
    m_copilote = copilote;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(tourelle);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_angle = m_copilote.getRawAxis(0);
    m_tourelle.tournerdanslevide(m_angle);
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
