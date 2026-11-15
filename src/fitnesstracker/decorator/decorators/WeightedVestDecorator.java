package fitnesstracker.decorator.decorators;

import fitnesstracker.decorator.component.Workout;

public class WeightedVestDecorator extends WorkoutDecorator {
    private static final double EXTRA_MET = 1.5;

    public WeightedVestDecorator(Workout workout) {
        super(workout);
    }

    @Override
    public String getDescription() {
        return workout.getDescription() + " + weighted vest";
    }

    @Override
    public double getMet() {
        return workout.getMet() + EXTRA_MET;
    }
}
