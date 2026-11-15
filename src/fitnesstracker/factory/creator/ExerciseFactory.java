package fitnesstracker.factory.creator;

import fitnesstracker.factory.product.Exercise;

/**
 * FACTORY METHOD: Creator.
 * Owner: Rahat
 *
 * create() is the same for every factory.
 * Subclasses override createExercise() - the factory method - and decide WHICH exercise is made.
 */
public abstract class ExerciseFactory {

    public Exercise create(String name, int durationMinutes) {
        Exercise exercise = createExercise(name.trim().toLowerCase(), durationMinutes);
        System.out.println("  [Factory Method] created " + exercise.describe());
        return exercise;
    }

    protected abstract Exercise createExercise(String name, int durationMinutes);
}
