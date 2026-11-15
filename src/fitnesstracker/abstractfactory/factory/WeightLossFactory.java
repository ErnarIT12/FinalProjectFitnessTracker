package fitnesstracker.abstractfactory.factory;

import fitnesstracker.abstractfactory.product.DailyGoal;
import fitnesstracker.abstractfactory.product.NutritionPlan;
import fitnesstracker.abstractfactory.product.WeightLossDailyGoal;
import fitnesstracker.abstractfactory.product.WeightLossNutritionPlan;
import fitnesstracker.factory.creator.CardioExerciseFactory;
import fitnesstracker.factory.creator.ExerciseFactory;
import fitnesstracker.factory.creator.StrengthExerciseFactory;
import fitnesstracker.factory.product.Exercise;

import java.util.ArrayList;
import java.util.List;

public class WeightLossFactory implements ProgramFactory {
    private final ExerciseFactory cardio = new CardioExerciseFactory();
    private final ExerciseFactory strength = new StrengthExerciseFactory();

    @Override
    public List<Exercise> createExercises() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(cardio.create("running", 30));
        exercises.add(cardio.create("cycling", 20));
        exercises.add(strength.create("squats", 10));
        return exercises;
    }

    @Override
    public NutritionPlan createNutritionPlan() {
        return new WeightLossNutritionPlan();
    }

    @Override
    public DailyGoal createDailyGoal() {
        return new WeightLossDailyGoal();
    }
}
