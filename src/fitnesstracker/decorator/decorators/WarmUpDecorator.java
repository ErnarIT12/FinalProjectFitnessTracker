package fitnesstracker.decorator.decorators;

import fitnesstracker.decorator.component.Workout;

public class WarmUpDecorator extends WorkoutDecorator {
    private static final int WARM_UP_MINUTES = 5;

    public WarmUpDecorator(Workout workout) {
        super(workout);
    }

    @Override
    public String getDescription() {
        return workout.getDescription() + " + warm-up";
    }

    @Override
    public int getDurationMinutes() {
        return workout.getDurationMinutes() + WARM_UP_MINUTES;
    }
}
