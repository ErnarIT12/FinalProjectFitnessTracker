package fitnesstracker.abstractfactory.product;

/**
 * ABSTRACT FACTORY: Abstract Product.
 * Owner: Rahat
 */
public interface DailyGoal {

    int getTargetSteps();

    int getTargetCaloriesBurned();

    String getDescription();
}
