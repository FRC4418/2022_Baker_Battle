// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.commands.number;
import frc.robot.constants.Ports;
import frc.robot.constants.Settings;

public class Shooter extends SubsystemBase {
  final WPI_TalonFX shootMotor = new WPI_TalonFX(Ports.Shooter.TOP);
  final WPI_TalonSRX shootMotor2 = new WPI_TalonSRX(Ports.Shooter.BOTTOM);

  public Shooter() {
    shootMotor.configFactoryDefault();
    shootMotor2.configFactoryDefault();

    // Config closed-loop controls
    shootMotor.config_kF(Settings.Shooter.PID.kSlot, 
                               Settings.Shooter.PID.kF);
		shootMotor.config_kP(Settings.Shooter.PID.kSlot, 
                               Settings.Shooter.PID.kP);
    
		shootMotor.config_kI(Settings.Shooter.PID.kSlot, 
                               Settings.Shooter.PID.kI);
    shootMotor.config_kD(Settings.Shooter.PID.kSlot, 
                               Settings.Shooter.PID.kD);
    
    resetEncoders();
    
  }

  // public static void setVelocity(Number number, Number Percent){
  //   shootMotor.set(ControlMode.Velocity, (double) number);
  //   shootMotor2.set(ControlMode.PercentOutput, (double) Percent);
  // }

    public static void setVelocity(Shooter shooter) {
      shooter.shootMotor.setVoltage(10.0);
      shooter.shootMotor2.setVoltage(10.0);
    }

  public void setPercentOutput(Number speed){
    shootMotor.set(ControlMode.PercentOutput, (double) speed);
  }

  public double getTopVelocity() {
		return shootMotor.getSelectedSensorVelocity();
	}

  public void resetEncoders() {
		shootMotor.setSelectedSensorPosition(0.d);
	}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
