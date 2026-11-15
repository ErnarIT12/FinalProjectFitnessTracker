package fitnesstracker.abstractfactory.product;

public class WeightLossDailyGoal implements DailyGoal {

    @Override
    public int getTargetSteps() {
        return 10000;
    }

    @Override
    public int getTargetCaloriesBurned() {
        return 500;
    }

    @Override
    public String getDescription() {
        return getTargetSteps() + " steps and " + getTargetCaloriesBurned() + " kcal burned per day";
    }
}
