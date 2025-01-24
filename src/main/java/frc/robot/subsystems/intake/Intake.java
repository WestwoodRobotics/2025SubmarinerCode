package frc.robot.subsystems.intake;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Intake {

    private SparkMax intakeMotor;
    private SparkMaxConfig intakeMotorConfig;
    private boolean isPIDConfigured;
    


    
    public Intake(int intakeMotorPort){
        intakeMotor = new SparkMax(intakeMotorPort, MotorType.kBrushless);
        intakeMotorConfig = new SparkMaxConfig();
    }

    public void configurePID(double p, double i, double d){
        intakeMotorConfig.closedLoop.pid(p, i, d);
        intakeMotor.configure(intakeMotorConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void configurePIDF(double p, double i, double d, double f){
        intakeMotorConfig.closedLoop.pidf(p, i, d, f);
        intakeMotor.configure(intakeMotorConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void configureMAXMotion(double maxVelocity, double acceleration){
        intakeMotorConfig.closedLoop.maxMotion.maxAcceleration(acceleration);
        intakeMotorConfig.closedLoop.maxMotion.maxVelocity(maxVelocity);
        intakeMotor.configure(intakeMotorConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void configureMAXOutput(double maxOutput){
        intakeMotorConfig.closedLoop.maxOutput(maxOutput);
        intakeMotor.configure(intakeMotorConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void configureMINOutput(double minOutput){
        intakeMotorConfig.closedLoop.minOutput(minOutput);
        intakeMotor.configure(intakeMotorConfig,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }
    



    public void setSpeed(double speed){
        intakeMotor.set(speed);
    }


    public boolean isPIDConfigured(){
        return isPIDConfigured;
    }




    
}
