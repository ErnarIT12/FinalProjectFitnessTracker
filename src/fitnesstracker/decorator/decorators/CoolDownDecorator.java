package fitnesstracker.decorator.decorators;

import fitnesstracker.decorator.component.Workout;

public class CoolDownDecorator extends WorkoutDecorator {
    private static final int COOL_DOWN_MINUTES = 5;

    public CoolDownDecorator(Workout workout) {
        super(workout);
    }

    @Override
    public String getDescription() {
        return workout.getDescription() + " + cool-down";
    }

    @Override
    public int getDurationMinutes() {
        return workout.getDurationMinutes() + COOL_DOWN_MINUTES;
    }
}
