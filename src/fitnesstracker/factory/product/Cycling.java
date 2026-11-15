package fitnesstracker.factory.product;

/**
 * FACTORY METHOD: Concrete Product - concrete exercise.
 * Owner: Rahat
 */
public class Cycling extends Exercise {

    public Cycling(int durationMinutes) {
        super("Cycling", ExerciseType.CARDIO, durationMinutes, 7.5);
    }

    @Override
    public String getTip() {
        return "Keep your back straight.";
    }
}
