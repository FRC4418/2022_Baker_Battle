// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.feedBecauseItsDumb;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Feeder;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.feedBecauseItsDumb.feederFeed;
import frc.robot.commands.feedBecauseItsDumb.feederNoFeed;
import frc.robot.commands.feedBecauseItsDumb.feederStopFeeding;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class feederFeedUwU extends SequentialCommandGroup {
  /** Creates a new feederFeedUwU. */
  public feederFeedUwU(Feeder feeder) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new feederFeed(feeder), new WaitCommand(1.0), new feederNoFeed(feeder), new feederStopFeeding(feeder));
  }
}
