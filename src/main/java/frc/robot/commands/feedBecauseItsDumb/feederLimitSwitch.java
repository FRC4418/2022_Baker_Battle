// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.feedBecauseItsDumb;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class feederLimitSwitch extends CommandBase {
  private Feeder feeder;
  int caseUwU=0;
  double time;
  boolean finished = false;
  /** Creates a new feederLimitSwitch. */
  public feederLimitSwitch(Feeder feeder) {
    addRequirements(feeder);
    this.feeder=feeder;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DigitalInput toplimitSwitch = new DigitalInput(3);
    DigitalInput bottomlimitSwitch = new DigitalInput(4);
    
    if (caseUwU==0){
      feeder.feed(-1.0);
      caseUwU = 1;
    }
    if (caseUwU==1){
      feeder.feed(0.0);
      if (toplimitSwitch.get()){
        time = Timer.getFPGATimestamp();
        caseUwU = 2;
      }
    }
    if (caseUwU==2){
      if (Timer.getFPGATimestamp() >= (time+1.0)){
        feeder.feed(1.0);
        caseUwU = 3;
      }
    }
    if (caseUwU==3){
      if (bottomlimitSwitch.get()){
        feeder.feed(0.0);
        finished = true;
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
