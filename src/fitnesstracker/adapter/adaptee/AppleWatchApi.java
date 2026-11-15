package fitnesstracker.adapter.adaptee;

import java.util.Random;

public class AppleWatchApi {
    private final Random random = new Random();

    public double readHeartRateBpm() {
        return 100 + random.nextDouble() * 50;
    }

    public long readStepsToday() {
        return 3000 + random.nextInt(7000);
    }
}
