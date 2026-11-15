package fitnesstracker.bridge.implementor;

public class ConsoleFormat implements ReportFormat {

    @Override
    public void renderTitle(String title) {
        System.out.println("===== " + title + " =====");
    }

    @Override
    public void renderLine(String key, String value) {
        System.out.println(key + ": " + value);
    }

    @Override
    public void finish() {
        System.out.println("==============================");
    }
}
