package fitnesstracker.factory.creator;

import fitnesstracker.factory.product.Exercise;
import fitnesstracker.factory.product.Yoga;

public class FlexibilityExerciseFactory extends ExerciseFactory {

    @Override
    protected Exercise createExercise(String name, int durationMinutes) {
        switch (name) {
            case "yoga":
                return new Yoga(durationMinutes);
            default:
                throw new IllegalArgumentException("Unknown flexibility exercise: " + name);
        }
    }
}
