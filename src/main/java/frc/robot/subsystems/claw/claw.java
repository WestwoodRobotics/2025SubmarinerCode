package frc.robot.subsystems.claw;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class claw {
    
    private SparkMax clawPivotMotor;
    private SparkMax clawPowerMotor;
    private SparkMax clawActuateMotor;

    private SparkMaxConfig clawPivotMotorConfig;
    private SparkMaxConfig clawPowerMotorConfig;
    private SparkMaxConfig clawActuateMotorConfig;
    
    

    public claw(int clawPivotMotorPort, int clawPowerMotorPort, int clawActuateMotorPort){
        clawPivotMotor = new SparkMax(clawPivotMotorPort, MotorType.kBrushless);
        clawPowerMotor = new SparkMax(clawPowerMotorPort, MotorType.kBrushless);
        clawActuateMotor = new SparkMax(clawActuateMotorPort, MotorType.kBrushless);

    }

    public void setPivotSpeed(double speed){
        clawPivotMotor.set(speed);
    }

    public void setPowerSpeed(double speed){
        clawPowerMotor.set(speed);
    }

    public void setActuateSpeed(double speed){
        clawActuateMotor.set(speed);
    }

    public void setPID(double p, double i, double d){
        clawPivotMotorConfig.closedLoop.pid(p, i, d);
        clawPowerMotorConfig.closedLoop.pid(p, i, d);
        clawActuateMotorConfig.closedLoop.pid(p, i, d);

        clawPivotMotor.configure(clawPivotMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
        clawPowerMotor.configure(clawPowerMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
        clawActuateMotor.configure(clawActuateMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    }

    public void setPIDF(double p, double i, double d, double f){
        clawPivotMotorConfig.closedLoop.pidf(p, i, d, f);
        clawPowerMotorConfig.closedLoop.pidf(p, i, d, f);
        clawActuateMotorConfig.closedLoop.pidf(p, i, d, f);

        clawPivotMotor.configure(clawPivotMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
        clawPowerMotor.configure(clawPowerMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
        clawActuateMotor.configure(clawActuateMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    }

    private void setClawPivotMAXMotion(double maxVelocity, double acceleration){
        clawPivotMotorConfig.closedLoop.maxMotion.maxAcceleration(acceleration);
        clawPivotMotorConfig.closedLoop.maxMotion.maxVelocity(maxVelocity);
        clawPivotMotor.configure(clawPivotMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    }

    private void setClawPowerMAXMotion(double maxVelocity, double acceleration){
        clawPowerMotorConfig.closedLoop.maxMotion.maxAcceleration(acceleration);
        clawPowerMotorConfig.closedLoop.maxMotion.maxVelocity(maxVelocity);
        clawPowerMotor.configure(clawPowerMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    }

    private void setClawActuateMAXMotion(double maxVelocity, double acceleration){
        clawActuateMotorConfig.closedLoop.maxMotion.maxAcceleration(acceleration);
        clawActuateMotorConfig.closedLoop.maxMotion.maxVelocity(maxVelocity);
        clawActuateMotor.configure(clawActuateMotorConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    }

    private void setClawPivotReference(double target){
        clawPivotMotor.getClosedLoopController().setReference(target, SparkMax.ControlType.kPosition);
    }

    private void setClawPowerReference(double target){
        clawPowerMotor.getClosedLoopController().setReference(target, SparkMax.ControlType.kPosition);
    }

    private void setClawActuateReference(double target){
        clawActuateMotor.getClosedLoopController().setReference(target, SparkMax.ControlType.kPosition);
    }



    

    

  
}