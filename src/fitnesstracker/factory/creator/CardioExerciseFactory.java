package fitnesstracker.factory.creator;

import fitnesstracker.factory.product.Cycling;
import fitnesstracker.factory.product.Exercise;
import fitnesstracker.factory.product.Running;

/**
 * FACTORY METHOD: Concrete Creator for cardio exercises.
 * Owner: Rahat
 */
public class CardioExerciseFactory extends ExerciseFactory {

    @Override
    protected Exercise createExercise(String name, int durationMinutes) {
        switch (name) {
            case "running":
                return new Running(durationMinutes);
            case "cycling":
                return new Cycling(durationMinutes);
            default:
                throw new IllegalArgumentException("Unknown cardio exercise: " + name);
        }
    }
}
