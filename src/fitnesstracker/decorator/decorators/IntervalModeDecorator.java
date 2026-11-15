package fitnesstracker.decorator.decorators;

import fitnesstracker.decorator.component.Workout;

public class IntervalModeDecorator extends WorkoutDecorator {
    private static final double INTENSITY_FACTOR = 1.2;

    public IntervalModeDecorator(Workout workout) {
        super(workout);
    }

    @Override
    public String getDescription() {
        return workout.getDescription() + " + interval mode";
    }

    @Override
    public double getMet() {
        return workout.getMet() * INTENSITY_FACTOR;
    }
}
