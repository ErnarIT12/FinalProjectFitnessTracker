package fitnesstracker.bridge.abstraction;

import fitnesstracker.bridge.implementor.ReportFormat;

public class DailyReport extends Report {
    private final String userName;
    private final String workout;
    private final int minutes;
    private final double calories;

    public DailyReport(ReportFormat format, String userName, String workout, int minutes, double calories) {
        super(format);
        this.userName = userName;
        this.workout = workout;
        this.minutes = minutes;
        this.calories = calories;
    }

    @Override
    public void generate() {
        format.renderTitle("Daily report - " + userName);
        format.renderLine("Workout", workout);
        format.renderLine("Duration", minutes + " min");
        format.renderLine("Calories burned", String.format("%.1f kcal", calories));
        format.finish();
    }
}
