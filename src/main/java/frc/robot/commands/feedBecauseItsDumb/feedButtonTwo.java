// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.feedBecauseItsDumb;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class feedButtonTwo extends CommandBase {
  public Feeder feeder;
  DigitalInput bottomlimitSwitch = new DigitalInput(4);
  /** Creates a new feedButtonOne. */
  public feedButtonTwo(Feeder feeder) {
    this.feeder = feeder;
    addRequirements(feeder);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println(bottomlimitSwitch.get());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    feeder.feed(1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    feeder.feed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (!bottomlimitSwitch.get()){
      return true;
    }
    return false;
  }
}
