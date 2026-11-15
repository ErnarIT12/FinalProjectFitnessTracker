package fitnesstracker.bridge.implementor;

public interface ReportFormat {

    void renderTitle(String title);

    void renderLine(String key, String value);

    void finish();
}
