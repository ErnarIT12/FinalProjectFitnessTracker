package fitnesstracker.strategy;

import fitnesstracker.adapter.target.WearableDevice;
import fitnesstracker.decorator.component.Workout;

public interface CalorieStrategy {

    String getName();

    double calculate(double weightKg, Workout workout, WearableDevice device);
}
