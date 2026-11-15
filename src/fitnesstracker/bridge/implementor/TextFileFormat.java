package fitnesstracker.bridge.implementor;

public class TextFileFormat extends FileFormat {

    public TextFileFormat() {
        super("report.txt");
    }

    @Override
    public void renderTitle(String title) {
        content.append(title.toUpperCase()).append("\n");
        content.append("-".repeat(title.length())).append("\n");
    }

    @Override
    public void renderLine(String key, String value) {
        content.append(key).append(": ").append(value).append("\n");
    }
}
