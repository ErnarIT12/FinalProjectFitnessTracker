package fitnesstracker.bridge.abstraction;

import fitnesstracker.bridge.implementor.ReportFormat;

public class WeeklyReport extends Report {
    private final String userName;
    private final int sessions;
    private final int totalMinutes;
    private final double totalCalories;

    public WeeklyReport(ReportFormat format, String userName, int sessions, int totalMinutes, double totalCalories) {
        super(format);
        this.userName = userName;
        this.sessions = sessions;
        this.totalMinutes = totalMinutes;
        this.totalCalories = totalCalories;
    }

    @Override
    public void generate() {
        format.renderTitle("Weekly report - " + userName);
        format.renderLine("Workouts", String.valueOf(sessions));
        format.renderLine("Total time", totalMinutes + " min");
        format.renderLine("Total calories", String.format("%.1f kcal", totalCalories));
        format.renderLine("Average per workout", String.format("%.1f kcal", totalCalories / sessions));
        format.finish();
    }
}
