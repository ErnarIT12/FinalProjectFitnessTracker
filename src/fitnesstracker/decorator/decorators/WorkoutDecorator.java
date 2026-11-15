package fitnesstracker.decorator.decorators;

import fitnesstracker.decorator.component.Workout;

public abstract class WorkoutDecorator implements Workout {
    protected final Workout workout;

    protected WorkoutDecorator(Workout workout) {
        this.workout = workout;
    }

    @Override
    public String getDescription() {
        return workout.getDescription();
    }

    @Override
    public int getDurationMinutes() {
        return workout.getDurationMinutes();
    }

    @Override
    public double getMet() {
        return workout.getMet();
    }
}
