package fitnesstracker.strategy.strategies;

import fitnesstracker.adapter.target.WearableDevice;
import fitnesstracker.decorator.component.Workout;
import fitnesstracker.strategy.CalorieStrategy;

public class HeartRateCalorieStrategy implements CalorieStrategy {
    private static final int AVERAGE_AGE = 20;

    @Override
    public String getName() {
        return "Heart rate formula";
    }

    @Override
    public double calculate(double weightKg, Workout workout, WearableDevice device) {
        int heartRate = device.getHeartRate();
        double perMinute = (0.6309 * heartRate + 0.1988 * weightKg + 0.2017 * AVERAGE_AGE - 55.0969) / 4.184;
        return perMinute * workout.getDurationMinutes();
    }
}
