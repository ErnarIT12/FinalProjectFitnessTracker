package fitnesstracker.bridge.abstraction;

import fitnesstracker.bridge.implementor.ReportFormat;

public abstract class Report {
    protected final ReportFormat format;

    protected Report(ReportFormat format) {
        this.format = format;
    }

    public abstract void generate();
}
