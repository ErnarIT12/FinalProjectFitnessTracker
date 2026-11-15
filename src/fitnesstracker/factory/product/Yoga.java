package fitnesstracker.factory.product;

public class Yoga extends Exercise {

    public Yoga(int durationMinutes) {
        super("Yoga", ExerciseType.FLEXIBILITY, durationMinutes, 3.0);
    }

    @Override
    public String getTip() {
        return "Move slowly and focus on breathing.";
    }
}
