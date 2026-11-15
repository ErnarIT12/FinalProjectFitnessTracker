package fitnesstracker.abstractfactory.factory;

import fitnesstracker.abstractfactory.product.DailyGoal;
import fitnesstracker.abstractfactory.product.NutritionPlan;
import fitnesstracker.factory.product.Exercise;

import java.util.List;


public interface ProgramFactory {

    List<Exercise> createExercises();

    NutritionPlan createNutritionPlan();

    DailyGoal createDailyGoal();
}
