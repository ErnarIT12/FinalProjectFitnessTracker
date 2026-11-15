package fitnesstracker.strategy.strategies;

import fitnesstracker.adapter.target.WearableDevice;
import fitnesstracker.decorator.component.Workout;
import fitnesstracker.strategy.CalorieStrategy;

public class MetCalorieStrategy implements CalorieStrategy {

    @Override
    public String getName() {
        return "MET formula";
    }

    @Override
    public double calculate(double weightKg, Workout workout, WearableDevice device) {
        double hours = workout.getDurationMinutes() / 60.0;
        return workout.getMet() * weightKg * hours;
    }
}
