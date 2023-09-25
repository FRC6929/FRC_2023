// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.commands.ClimberAxelCommand;
import frc.robot.commands.ClimberLateralCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ElevatorLateralCommand;
import frc.robot.commands.ElevatorVerticalCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.PinceCommand;
import frc.robot.commands.TourelleCommand;
import frc.robot.commands.mode;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Pince;
import frc.robot.subsystems.Tourelle;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  
  // The robot's subsystems and commands are defined here...

  private final Pince m_pince = new Pince();
  private final Intake m_intake = new Intake();
  private final Elevator m_elevator = new Elevator();
  private final Climber m_climber = new Climber();
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Tourelle m_tourelle = new Tourelle();

  private final XboxController m_Controller = new XboxController(1);
  private final Joystick m_Joystick = new Joystick(0);
  private final Joystick m_Copilote = new Joystick(2);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {




    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    m_tourelle.setDefaultCommand(new TourelleCommand(m_tourelle, m_Copilote));
    m_drivetrain.setDefaultCommand(new DriveCommand(m_drivetrain, m_Joystick, m_Controller));
    JoystickButton pince = new JoystickButton(m_Copilote, 1);
    JoystickButton intakeL = new JoystickButton(m_Copilote, 2);
    JoystickButton intakeR = new JoystickButton(m_Copilote, 3);
    JoystickButton elevatorstate = new JoystickButton(m_Copilote, 4);
    JoystickButton elevatorup = new JoystickButton(m_Copilote, 5);
    JoystickButton elevatordown = new JoystickButton(m_Copilote, 6);
    JoystickButton elevatorforward = new JoystickButton(m_Copilote, 7);
    JoystickButton elevatorbackward = new JoystickButton(m_Copilote, 8);

    pince.onTrue(new PinceCommand(m_pince));
    intakeL.onTrue(new IntakeCommand(m_intake,false)); //false == L
    intakeR.onTrue(new IntakeCommand(m_intake, true)); //true == R
    elevatorup.onTrue(new ElevatorVerticalCommand(m_elevator, 1));
    elevatorup.onTrue(new ClimberAxelCommand(m_climber, 1));
    elevatordown.onTrue( new ElevatorVerticalCommand(m_elevator, -1));
    elevatordown.onTrue( new ClimberAxelCommand(m_climber, -1));
    elevatorforward.onTrue(new ElevatorLateralCommand(m_elevator, 1));
    elevatorforward.onTrue(new ClimberLateralCommand(m_climber, 1));
    elevatorbackward.onTrue(new ElevatorLateralCommand(m_elevator, -1));
    elevatorbackward.onTrue(new ClimberLateralCommand(m_climber, -1));
    elevatorstate.onTrue(new mode());

  
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
   // new Trigger(m_drivetrain::exampleCon  dition)
     //  .onTrue(new Drivetrain(m_drivetrain));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
   // m_driverController.b().whileTrue(m_drivetrain.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;// Autos.exampleAuto(m_drivetrain);
  }
}
