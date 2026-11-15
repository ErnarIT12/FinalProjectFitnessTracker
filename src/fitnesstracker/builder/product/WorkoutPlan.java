package fitnesstracker.builder.product;

import fitnesstracker.factory.product.Exercise;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlan {
    private final String name;
    private final String goal;
    private final String level;
    private final int daysPerWeek;
    private final List<Exercise> exercises;

    public WorkoutPlan(String name, String goal, String level, int daysPerWeek, List<Exercise> exercises) {
        this.name = name;
        this.goal = goal;
        this.level = level;
        this.daysPerWeek = daysPerWeek;
        this.exercises = new ArrayList<>(exercises);
    }

    public String getName() {
        return name;
    }

    public String getGoal() {
        return goal;
    }

    public String getLevel() {
        return level;
    }

    public int getDaysPerWeek() {
        return daysPerWeek;
    }

    public List<Exercise> getExercises() {
        return new ArrayList<>(exercises);
    }

    public int getTotalMinutes() {
        int total = 0;
        for (Exercise exercise : exercises) {
            total += exercise.getDurationMinutes();
        }
        return total;
    }

    public double getAverageMet() {
        double sum = 0;
        for (Exercise exercise : exercises) {
            sum += exercise.getMet() * exercise.getDurationMinutes();
        }
        return sum / getTotalMinutes();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("Plan: ").append(name).append("\n");
        text.append("Goal: ").append(goal).append(" | Level: ").append(level)
                .append(" | ").append(daysPerWeek).append(" days per week\n");
        for (Exercise exercise : exercises) {
            text.append("  - ").append(exercise.describe())
                    .append(" | tip: ").append(exercise.getTip()).append("\n");
        }
        text.append("Total: ").append(getTotalMinutes()).append(" min");
        return text.toString();
    }
}
