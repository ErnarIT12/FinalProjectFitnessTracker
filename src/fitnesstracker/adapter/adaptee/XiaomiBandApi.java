package fitnesstracker.adapter.adaptee;

import java.util.Random;

public class XiaomiBandApi {
    private final Random random = new Random();

    public String getPulse() {
        return (105 + random.nextInt(45)) + " bpm";
    }

    public int getDistanceMeters() {
        return 2000 + random.nextInt(5000);
    }
}
