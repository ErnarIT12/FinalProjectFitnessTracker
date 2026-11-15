package fitnesstracker.factory.product;

public class PushUps extends Exercise {

    public PushUps(int durationMinutes) {
        super("Push-ups", ExerciseType.STRENGTH, durationMinutes, 8.0);
    }

    @Override
    public String getTip() {
        return "Keep your body in a straight line.";
    }
}
