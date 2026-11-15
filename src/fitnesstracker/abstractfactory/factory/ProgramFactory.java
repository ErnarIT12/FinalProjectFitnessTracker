package fitnesstracker.abstractfactory.factory;

import fitnesstracker.abstractfactory.product.DailyGoal;
import fitnesstracker.abstractfactory.product.NutritionPlan;
import fitnesstracker.factory.product.Exercise;

import java.util.List;

/**
 * ABSTRACT FACTORY: creates a matching family of products for one fitness goal.
 * Owner: Rahat
 *
 * Family = exercises + nutrition plan + daily goal.
 * One factory always gives products that fit together (no cardio with a muscle-gain diet).
 */
public interface ProgramFactory {

    List<Exercise> createExercises();

    NutritionPlan createNutritionPlan();

    DailyGoal createDailyGoal();
}
