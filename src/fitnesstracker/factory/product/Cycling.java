package fitnesstracker.factory.product;


public class Cycling extends Exercise {

    public Cycling(int durationMinutes) {
        super("Cycling", ExerciseType.CARDIO, durationMinutes, 7.5);
    }

    @Override
    public String getTip() {
        return "Keep your back straight.";
    }
}
