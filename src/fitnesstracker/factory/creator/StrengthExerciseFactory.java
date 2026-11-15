package fitnesstracker.factory.creator;

import fitnesstracker.factory.product.Exercise;
import fitnesstracker.factory.product.PushUps;
import fitnesstracker.factory.product.Squats;

/**
 * FACTORY METHOD: Concrete Creator for strength exercises.
 * Owner: Rahat
 */
public class StrengthExerciseFactory extends ExerciseFactory {

    @Override
    protected Exercise createExercise(String name, int durationMinutes) {
        switch (name) {
            case "pushups":
                return new PushUps(durationMinutes);
            case "squats":
                return new Squats(durationMinutes);
            default:
                throw new IllegalArgumentException("Unknown strength exercise: " + name);
        }
    }
}
