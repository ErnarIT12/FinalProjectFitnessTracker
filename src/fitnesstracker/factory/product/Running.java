package fitnesstracker.factory.product;

/**
 * FACTORY METHOD: Concrete Product - concrete exercise.
 * Owner: Rahat
 */
public class Running extends Exercise {

    public Running(int durationMinutes) {
        super("Running", ExerciseType.CARDIO, durationMinutes, 9.8);
    }

    @Override
    public String getTip() {
        return "Keep a steady pace and breathe evenly.";
    }
}
