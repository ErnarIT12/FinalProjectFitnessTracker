package fitnesstracker.adapter.adapters;

import fitnesstracker.adapter.adaptee.XiaomiBandApi;
import fitnesstracker.adapter.target.WearableDevice;

public class XiaomiBandAdapter implements WearableDevice {
    private static final double STEP_LENGTH_METERS = 0.75;
    private final XiaomiBandApi api;

    public XiaomiBandAdapter(XiaomiBandApi api) {
        this.api = api;
    }

    @Override
    public String getDeviceName() {
        return "Xiaomi Band";
    }

    @Override
    public int getHeartRate() {
        String pulse = api.getPulse().replace(" bpm", "");
        return Integer.parseInt(pulse);
    }

    @Override
    public int getSteps() {
        return (int) (api.getDistanceMeters() / STEP_LENGTH_METERS);
    }
}
