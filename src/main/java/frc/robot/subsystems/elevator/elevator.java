package frc.robot.subsystems.elevator;

import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

public class elevator {
    private SparkMax elevatorMotor1;
    private SparkMax elevatorMotor2;

    private SparkMaxConfig elevatorMotor1Config;
    private SparkMaxConfig elevatorMotor2Config;
    //must move in same directions

    public elevator(int elevatorMotor1Port, int elevatorMotor2Port){
        elevatorMotor1 = new SparkMax(elevatorMotor1Port, MotorType.kBrushless);
        elevatorMotor2 = new SparkMax(elevatorMotor2Port, MotorType.kBrushless);
    }

    public void configurePID(double p, double i, double d){
        elevatorMotor1Config.closedLoop.pid(p, i, d);
        elevatorMotor2Config.closedLoop.pid(p, i, d);

        elevatorMotor1.configure(elevatorMotor1Config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
        elevatorMotor2.configure(elevatorMotor1Config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    }

    public void configurePIDF(double p, double i, double d, double f){
        elevatorMotor1Config.closedLoop.pidf(p, i, d, f);
        elevatorMotor2Config.closedLoop.pidf(p, i, d, f);

        elevatorMotor1.configure(elevatorMotor1Config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
        elevatorMotor2.configure(elevatorMotor1Config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    }

    public void configureMAXMotion(double maxVelocity, double acceleration){
        elevatorMotor1Config.closedLoop.maxMotion.maxAcceleration(acceleration);
        elevatorMotor1Config.closedLoop.maxMotion.maxVelocity(maxVelocity);

        elevatorMotor2Config.closedLoop.maxMotion.maxAcceleration(acceleration);
        elevatorMotor2Config.closedLoop.maxMotion.maxVelocity(maxVelocity);

        elevatorMotor1.configure(elevatorMotor1Config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
        elevatorMotor2.configure(elevatorMotor1Config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    }

    public void setTargetEncoderPose(double target){
        elevatorMotor1.getClosedLoopController().setReference(target, ControlType.kPosition);
        elevatorMotor2.set(target);
    }
    

    public void setSpeed(double speed){
        elevatorMotor1.set(speed);
        elevatorMotor2.set(speed);
    }

    public void setSpeed(double speedMotor1, double speedMotor2){
        elevatorMotor1.set(speedMotor1);
        elevatorMotor2.set(speedMotor2);
    }

}
