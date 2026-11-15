package fitnesstracker.bridge.implementor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FileFormat implements ReportFormat {
    private static final String FOLDER = "reports";
    private final String fileName;
    protected final StringBuilder content = new StringBuilder();

    protected FileFormat(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void finish() {
        new File(FOLDER).mkdirs();
        File file = new File(FOLDER, fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content.toString());
            System.out.println("Report saved to " + file.getPath());
        } catch (IOException e) {
            System.out.println("Could not save report: " + e.getMessage());
        }
        content.setLength(0);
    }
}
