package fitnesstracker.decorator.component;

public class BasicWorkout implements Workout {
    private final String name;
    private final int durationMinutes;
    private final double met;

    public BasicWorkout(String name, int durationMinutes, double met) {
        if (durationMinutes <= 0 || met <= 0) {
            throw new IllegalArgumentException("Duration and MET must be positive");
        }
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.met = met;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public double getMet() {
        return met;
    }
}
