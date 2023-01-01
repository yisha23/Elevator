package frc.robot.utilities;

public class Conversions {
    public static double ticksToCentimeters(double ticks, double ticksPerCentimeter) {
        return ticks / ticksPerCentimeter;
    }

    public static double centimetersToTicks(double centimeters, double ticksPerCentimeter) {
        return centimeters * ticksPerCentimeter;
    }
}
