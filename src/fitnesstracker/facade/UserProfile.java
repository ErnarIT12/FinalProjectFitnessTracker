package fitnesstracker.facade;

public class UserProfile {
    private final String name;
    private final int age;
    private final double weightKg;
    private final double heightCm;

    public UserProfile(String name, int age, double weightKg, double heightCm) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (age <= 0 || weightKg <= 0 || heightCm <= 0) {
            throw new IllegalArgumentException("Age, weight and height must be positive");
        }
        this.name = name;
        this.age = age;
        this.weightKg = weightKg;
        this.heightCm = heightCm;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public double getBmi() {
        double heightM = heightCm / 100;
        return weightKg / (heightM * heightM);
    }
}
