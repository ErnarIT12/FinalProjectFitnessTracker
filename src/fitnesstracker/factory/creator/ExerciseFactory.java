package fitnesstracker.factory.creator;

import fitnesstracker.factory.product.Exercise;


public abstract class ExerciseFactory {

    public Exercise create(String name, int durationMinutes) {
        Exercise exercise = createExercise(name.trim().toLowerCase(), durationMinutes);
        System.out.println("  [Factory Method] created " + exercise.describe());
        return exercise;
    }

    protected abstract Exercise createExercise(String name, int durationMinutes);
}
