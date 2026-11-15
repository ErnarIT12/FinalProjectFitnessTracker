package fitnesstracker.factory.product;

public abstract class Exercise {
    private final String name;
    private final ExerciseType type;
    private final int durationMinutes;
    private final double met;

    protected Exercise(String name, ExerciseType type, int durationMinutes, double met) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.name = name;
        this.type = type;
        this.durationMinutes = durationMinutes;
        this.met = met;
    }

    public String getName() {
        return name;
    }

    public ExerciseType getType() {
        return type;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public double getMet() {
        return met;
    }

    public abstract String getTip();

    public String describe() {
        return name + " - " + durationMinutes + " min (" + type + ")";
    }
}
