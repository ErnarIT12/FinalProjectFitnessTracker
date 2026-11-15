package fitnesstracker.adapter.adapters;

import fitnesstracker.adapter.adaptee.AppleWatchApi;
import fitnesstracker.adapter.target.WearableDevice;

public class AppleWatchAdapter implements WearableDevice {
    private final AppleWatchApi api;

    public AppleWatchAdapter(AppleWatchApi api) {
        this.api = api;
    }

    @Override
    public String getDeviceName() {
        return "Apple Watch";
    }

    @Override
    public int getHeartRate() {
        return (int) Math.round(api.readHeartRateBpm());
    }

    @Override
    public int getSteps() {
        return (int) api.readStepsToday();
    }
}
