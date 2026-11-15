package fitnesstracker.strategy.strategies;

import fitnesstracker.adapter.target.WearableDevice;
import fitnesstracker.decorator.component.Workout;
import fitnesstracker.strategy.CalorieStrategy;

public class StepsCalorieStrategy implements CalorieStrategy {
    private static final double KCAL_PER_STEP = 0.04;
    private static final double BASE_WEIGHT_KG = 70.0;

    @Override
    public String getName() {
        return "Steps formula";
    }

    @Override
    public double calculate(double weightKg, Workout workout, WearableDevice device) {
        return device.getSteps() * KCAL_PER_STEP * (weightKg / BASE_WEIGHT_KG);
    }
}
