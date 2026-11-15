package fitnesstracker.abstractfactory.product;


public class WeightLossNutritionPlan implements NutritionPlan {

    @Override
    public int getDailyCalories() {
        return 1800;
    }

    @Override
    public String getDescription() {
        return "Calorie deficit: " + getDailyCalories() + " kcal, more vegetables and protein, less sugar";
    }
}
