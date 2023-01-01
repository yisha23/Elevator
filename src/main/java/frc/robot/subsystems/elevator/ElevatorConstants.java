package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.utilities.Conversions;

public class ElevatorConstants {
    private static final int MOTOR_ID = 1;
    static final WPI_TalonFX MOTOR = new WPI_TalonFX(MOTOR_ID);
    static final double OFFSET = 0;
    static final double FEEDFORWARD = 0;
    static final double TICKS_PER_CENTIMETER = 20480;
    private static final double
            LEVEL_ZERO = Conversions.centimetersToTicks(0, TICKS_PER_CENTIMETER),
            LEVEL_TWENTY = Conversions.centimetersToTicks(20, TICKS_PER_CENTIMETER),
            LEVEL_FORTY = Conversions.centimetersToTicks(40, TICKS_PER_CENTIMETER),
            LEVEL_HUNDRED = Conversions.centimetersToTicks(100, TICKS_PER_CENTIMETER);
    private static final double
            P = 0,
            I = 0,
            D = 0;
    private static final boolean MOTOR_INVERTED = true;

    static {
        MOTOR.setInverted(MOTOR_INVERTED);
        MOTOR.config_kP(0, P);
        MOTOR.config_kI(0, I);
        MOTOR.config_kD(0, D);
        MOTOR.config_kF(0, FEEDFORWARD);

    }

    public enum ElevatorLevel {
        LEVEL_ZERO(ElevatorConstants.LEVEL_ZERO),
        LEVEL_TWENTY(ElevatorConstants.LEVEL_TWENTY),
        LEVEL_FORTY(ElevatorConstants.LEVEL_FORTY),
        LEVEL_HUNDRED(ElevatorConstants.LEVEL_HUNDRED);

        final double ticks;

        ElevatorLevel(double ticks) {
            this.ticks = ticks;
        }
    }
}