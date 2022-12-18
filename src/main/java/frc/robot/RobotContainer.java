// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.stuypulse.stuylib.input.gamepads.AutoGamepad;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;
import frc.robot.commands.DrivetrainDrive;

import frc.robot.commands.shooterShoot;
import frc.robot.commands.feedBecauseItsDumb.feedButtonOne;
import frc.robot.commands.feedBecauseItsDumb.feedButtonTwo;
import frc.robot.commands.feedBecauseItsDumb.feederFeedUwU;
import frc.robot.commands.feedBecauseItsDumb.feederFeeding;
import frc.robot.commands.feedBecauseItsDumb.feederFeedingReverse;
import frc.robot.commands.feedBecauseItsDumb.feederNoFeed;
import frc.robot.constants.Ports;
import frc.robot.constants.Settings;
import frc.robot.constants.Ports.Gamepad;
import frc.robot.commands.blankAuto;
import frc.robot.commands.feederLimitSwitch;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain drivetrain = new Drivetrain();
  private final Shooter shooter = new Shooter();
  private final Feeder feeder = new Feeder();
  public final AutoGamepad driver = new AutoGamepad(Ports.Gamepad.DRIVER);
  private final DrivetrainDrive DrivetrainDrive = new DrivetrainDrive(drivetrain, driver);
  public final blankAuto blankAuto = new blankAuto();
  
  private static SendableChooser<Command> autoChooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureDefaultCommands();
    configureButtonBindings();
    configureAutons();
  }


  private void configureDefaultCommands() {
    drivetrain.setDefaultCommand(new DrivetrainDrive(drivetrain, driver));
  }


  public void configureButtonBindings() {
    driver.getLeftButton().whenHeld(new shooterShoot(shooter));
    driver.getRightButton().whenHeld(new feedButtonOne(feeder));
    driver.getTopButton().whenHeld(new feedButtonTwo(feeder));
  }


  // Add commands to the autonomous command chooser
  public void configureAutons() {
    autoChooser.setDefaultOption("Do Nothing", new blankAuto());

    SmartDashboard.putData("Autonomous", autoChooser);
  }


  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
    // return realAutoCode;
  }
}



  
