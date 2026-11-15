package fitnesstracker.abstractfactory.product;

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
