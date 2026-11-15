package fitnesstracker.abstractfactory.factory;

import fitnesstracker.abstractfactory.product.DailyGoal;
import fitnesstracker.abstractfactory.product.MuscleGainDailyGoal;
import fitnesstracker.abstractfactory.product.MuscleGainNutritionPlan;
import fitnesstracker.abstractfactory.product.NutritionPlan;
import fitnesstracker.factory.creator.ExerciseFactory;
import fitnesstracker.factory.creator.FlexibilityExerciseFactory;
import fitnesstracker.factory.creator.StrengthExerciseFactory;
import fitnesstracker.factory.product.Exercise;

import java.util.ArrayList;
import java.util.List;

public class MuscleGainFactory implements ProgramFactory {
    private final ExerciseFactory strength = new StrengthExerciseFactory();
    private final ExerciseFactory flexibility = new FlexibilityExerciseFactory();

    @Override
    public List<Exercise> createExercises() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(strength.create("pushups", 15));
        exercises.add(strength.create("squats", 20));
        exercises.add(flexibility.create("yoga", 10));
        return exercises;
    }

    @Override
    public NutritionPlan createNutritionPlan() {
        return new MuscleGainNutritionPlan();
    }

    @Override
    public DailyGoal createDailyGoal() {
        return new MuscleGainDailyGoal();
    }
}
