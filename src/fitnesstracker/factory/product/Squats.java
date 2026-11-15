package fitnesstracker.factory.product;

/**
 * FACTORY METHOD: Concrete Product - concrete exercise.
 * Owner: Rahat
 */
public class Squats extends Exercise {

    public Squats(int durationMinutes) {
        super("Squats", ExerciseType.STRENGTH, durationMinutes, 5.0);
    }

    @Override
    public String getTip() {
        return "Push your hips back, keep knees behind toes.";
    }
}
