package fitnesstracker.abstractfactory.product;


public class MuscleGainDailyGoal implements DailyGoal {

    @Override
    public int getTargetSteps() {
        return 6000;
    }

    @Override
    public int getTargetCaloriesBurned() {
        return 300;
    }

    @Override
    public String getDescription() {
        return getTargetSteps() + " steps and " + getTargetCaloriesBurned() + " kcal burned per day";
    }
}
