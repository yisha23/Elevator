package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private final static Elevator INSTANCE = new Elevator();
    private final WPI_TalonFX motor = ElevatorConstants.MOTOR;

    private Elevator() {
    }

    public static Elevator getInstance() {
        return INSTANCE;
    }

    /**
     * @return a command that is going to the desired level, and stops the elevator when it ends.
     */
    public Command getGoToLevelCommand(ElevatorConstants.ElevatorLevel level) {
        return new StartEndCommand(() -> goToLevel(level), this::stop, this);
    }


    private void goToLevel(ElevatorConstants.ElevatorLevel level) {
        motor.set(ControlMode.Position, level.ticks + ElevatorConstants.OFFSET,
                DemandType.ArbitraryFeedForward, ElevatorConstants.FEEDFORWARD);
    }

    private void stop() {
        goToLevel(ElevatorConstants.ElevatorLevel.LEVEL_ZERO);
        motor.stopMotor();
    }

}