// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class consDrivetrain{
    public static final int Motor_LF = 6;
    public static final int Motor_LB = 1;
    public static final int Motor_RF = 2;
    public static final int Motor_RB = 8;
  }
 public static class consIntake{
    public static final int Piston_IL = 0;
    public static final int Piston_IL2 = 1;
    public static final int Piston_IR = 2;
    public static final int Piston_IR2 = 3;
 }
  public static class consPince{
    public static final int Piston_P = 4;
    public static final int Piston_P2 = 5;
  }
  public static class consElevator{
    public static final int Motor_EUL = 0;
    public static final int Motor_EUR = 0;
    public static final int Motor_EL = 0;
  }
  public static class consClimberinabox{
    public static final int Motor_CU = 0;
    public static final int Motor_CL = 0;
  }
  public static class consTourelle{
    public static final int Motor_T = 5;
  }
}
