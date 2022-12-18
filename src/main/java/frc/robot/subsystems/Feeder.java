// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Ports;
import frc.robot.constants.Settings;


public class Feeder extends SubsystemBase {
final static WPI_TalonSRX feederFeed = new WPI_TalonSRX(Ports.Feeder.FEEDER);
public static DigitalInput topSwitch = new DigitalInput(3);
public static DigitalInput bottomSwitch = new DigitalInput(4);

  public Feeder() {
    
    // feederFeed.configFactoryDefault();

    // // Config closed-loop controls
    // feederFeed.config_kF(Settings.Feeder.PID.kSlot, 
    //                            Settings.Feeder.PID.kF);
    // feederFeed.config_kP(Settings.Feeder.PID.kSlot, 
    //                            Settings.Feeder.PID.kP);
    
    // feederFeed.config_kI(Settings.Feeder.PID.kSlot, 
    //                            Settings.Feeder.PID.kI);
    // feederFeed.config_kD(Settings.Feeder.PID.kSlot, 
    //                            Settings.Feeder.PID.kD);
    
    // feederFeed.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
    // feederFeed.setInverted(true);
		// resetEncoders();


  }
  public static WPI_TalonSRX getMotor(){
    return feederFeed;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void resetEncoders() {
		feederFeed.setSelectedSensorPosition(0.d);
	}

  
  public static void feed(Number percent){
    feederFeed.set((double)percent);
    //   (ControlMode.PercentOutput, (Double) percent);
  }
}
