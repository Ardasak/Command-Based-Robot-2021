// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class Drive extends CommandBase {
  private DriveSubsystem m_drivesubsystem;
  private double throttle;

  /** Creates a new Drive. */
  public Drive(DriveSubsystem m_drivesubsystem, double throttle) {
    this.m_drivesubsystem = m_drivesubsystem;
    this.throttle = throttle;
   

    addRequirements(m_drivesubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    throttle = (throttle + 1) / 2; 
    SmartDashboard.putNumber("throttle",this.throttle);
    m_drivesubsystem.arcadeDrive(this.throttle*RobotContainer.stick.getY(), this.throttle*RobotContainer.stick.getX());
    
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
