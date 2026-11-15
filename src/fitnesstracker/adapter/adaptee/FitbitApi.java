package fitnesstracker.adapter.adaptee;

import java.util.Random;

public class FitbitApi {
    private final Random random = new Random();

    public int fetchBpm() {
        return 110 + random.nextInt(40);
    }

    public int fetchStepCount() {
        return 4000 + random.nextInt(6000);
    }
}
