package fitnesstracker.builder;

import fitnesstracker.builder.product.WorkoutPlan;
import fitnesstracker.factory.product.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * BUILDER: step-by-step construction of WorkoutPlan.
 * Owner: Rahat
 *
 * Every setter returns "this", so calls can be chained:
 * new WorkoutPlanBuilder().setName("My plan").addExercise(...).build();
 * Optional fields have default values, build() checks the required ones.
 */
public class WorkoutPlanBuilder {
    private String name;
    private String goal = "General fitness";
    private String level = "Beginner";
    private int daysPerWeek = 3;
    private final List<Exercise> exercises = new ArrayList<>();

    public WorkoutPlanBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WorkoutPlanBuilder setGoal(String goal) {
        this.goal = goal;
        return this;
    }

    public WorkoutPlanBuilder setLevel(String level) {
        this.level = level;
        return this;
    }

    public WorkoutPlanBuilder setDaysPerWeek(int daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
        return this;
    }

    public WorkoutPlanBuilder addExercise(Exercise exercise) {
        exercises.add(exercise);
        return this;
    }

    public WorkoutPlanBuilder addExercises(List<Exercise> newExercises) {
        exercises.addAll(newExercises);
        return this;
    }

    public WorkoutPlan build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Plan name is required");
        }
        if (exercises.isEmpty()) {
            throw new IllegalStateException("Plan needs at least one exercise");
        }
        if (daysPerWeek < 1 || daysPerWeek > 7) {
            throw new IllegalStateException("Days per week must be from 1 to 7");
        }
        return new WorkoutPlan(name, goal, level, daysPerWeek, exercises);
    }
}
