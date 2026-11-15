package fitnesstracker.strategy.context;

import fitnesstracker.adapter.target.WearableDevice;
import fitnesstracker.decorator.component.Workout;
import fitnesstracker.strategy.CalorieStrategy;

public class CalorieCalculator {
    private CalorieStrategy strategy;

    public CalorieCalculator(CalorieStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(CalorieStrategy strategy) {
        this.strategy = strategy;
    }

    public CalorieStrategy getStrategy() {
        return strategy;
    }

    public double calculate(double weightKg, Workout workout, WearableDevice device) {
        return strategy.calculate(weightKg, workout, device);
    }
}
