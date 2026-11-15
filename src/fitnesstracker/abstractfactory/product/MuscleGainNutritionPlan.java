package fitnesstracker.abstractfactory.product;

/**
 * ABSTRACT FACTORY: Concrete Product.
 * Owner: Rahat
 */
public class MuscleGainNutritionPlan implements NutritionPlan {

    @Override
    public int getDailyCalories() {
        return 2800;
    }

    @Override
    public String getDescription() {
        return "Calorie surplus: " + getDailyCalories() + " kcal, 2 g of protein per kg of body weight";
    }
}
