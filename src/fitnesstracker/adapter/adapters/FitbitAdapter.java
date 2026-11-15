package fitnesstracker.adapter.adapters;

import fitnesstracker.adapter.adaptee.FitbitApi;
import fitnesstracker.adapter.target.WearableDevice;

public class FitbitAdapter implements WearableDevice {
    private final FitbitApi api;

    public FitbitAdapter(FitbitApi api) {
        this.api = api;
    }

    @Override
    public String getDeviceName() {
        return "Fitbit";
    }

    @Override
    public int getHeartRate() {
        return api.fetchBpm();
    }

    @Override
    public int getSteps() {
        return api.fetchStepCount();
    }
}
