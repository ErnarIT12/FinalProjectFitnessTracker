package fitnesstracker.facade;

import fitnesstracker.abstractfactory.factory.MuscleGainFactory;
import fitnesstracker.abstractfactory.factory.ProgramFactory;
import fitnesstracker.abstractfactory.factory.WeightLossFactory;
import fitnesstracker.abstractfactory.product.DailyGoal;
import fitnesstracker.abstractfactory.product.NutritionPlan;
import fitnesstracker.adapter.adaptee.AppleWatchApi;
import fitnesstracker.adapter.adaptee.FitbitApi;
import fitnesstracker.adapter.adaptee.XiaomiBandApi;
import fitnesstracker.adapter.adapters.AppleWatchAdapter;
import fitnesstracker.adapter.adapters.FitbitAdapter;
import fitnesstracker.adapter.adapters.XiaomiBandAdapter;
import fitnesstracker.adapter.target.WearableDevice;
import fitnesstracker.bridge.abstraction.DailyReport;
import fitnesstracker.bridge.abstraction.Report;
import fitnesstracker.bridge.abstraction.WeeklyReport;
import fitnesstracker.bridge.implementor.ConsoleFormat;
import fitnesstracker.bridge.implementor.HtmlFormat;
import fitnesstracker.bridge.implementor.ReportFormat;
import fitnesstracker.bridge.implementor.TextFileFormat;
import fitnesstracker.builder.WorkoutPlanBuilder;
import fitnesstracker.builder.product.WorkoutPlan;
import fitnesstracker.decorator.component.BasicWorkout;
import fitnesstracker.decorator.component.Workout;
import fitnesstracker.decorator.decorators.CoolDownDecorator;
import fitnesstracker.decorator.decorators.IntervalModeDecorator;
import fitnesstracker.decorator.decorators.WarmUpDecorator;
import fitnesstracker.decorator.decorators.WeightedVestDecorator;
import fitnesstracker.strategy.context.CalorieCalculator;
import fitnesstracker.strategy.strategies.HeartRateCalorieStrategy;
import fitnesstracker.strategy.strategies.MetCalorieStrategy;
import fitnesstracker.strategy.strategies.StepsCalorieStrategy;
public class FitnessTrackerFacade {
    private UserProfile user;
    private WearableDevice device;
    private WorkoutPlan plan;
    private final CalorieCalculator calculator = new CalorieCalculator(new MetCalorieStrategy());

    private Workout lastWorkout;
    private double lastCalories;
    private int sessions;
    private int totalMinutes;
    private double totalCalories;

    public String registerUser(String name, int age, double weightKg, double heightCm) {
        user = new UserProfile(name, age, weightKg, heightCm);
        return "Welcome, " + name + "! Your BMI: " + String.format("%.1f", user.getBmi());
    }

    public String connectDevice(String deviceName) {
        switch (deviceName.trim().toLowerCase()) {
            case "fitbit":
                device = new FitbitAdapter(new FitbitApi());
                break;
            case "apple":
                device = new AppleWatchAdapter(new AppleWatchApi());
                break;
            case "xiaomi":
                device = new XiaomiBandAdapter(new XiaomiBandApi());
                break;
            default:
                throw new IllegalArgumentException("Unknown device: " + deviceName);
        }
        return "Connected " + device.getDeviceName()
                + " | heart rate: " + device.getHeartRate() + " bpm, steps: " + device.getSteps();
    }

    public String createPlan(String goal) {
        requireUser();
        ProgramFactory program = chooseProgram(goal);
        plan = new WorkoutPlanBuilder()
                .setName(user.getName() + "'s " + goal + " plan")
                .setGoal(goal)
                .setLevel("Beginner")
                .setDaysPerWeek(3)
                .addExercises(program.createExercises())
                .build();
        NutritionPlan nutrition = program.createNutritionPlan();
        DailyGoal dailyGoal = program.createDailyGoal();
        return plan
                + "\nNutrition: " + nutrition.getDescription()
                + "\nDaily goal: " + dailyGoal.getDescription();
    }

    public String setCalorieMethod(String method) {
        switch (method.trim().toLowerCase()) {
            case "met":
                calculator.setStrategy(new MetCalorieStrategy());
                break;
            case "heart":
                calculator.setStrategy(new HeartRateCalorieStrategy());
                break;
            case "steps":
                calculator.setStrategy(new StepsCalorieStrategy());
                break;
            default:
                throw new IllegalArgumentException("Unknown calorie method: " + method);
        }
        return "Calorie method: " + calculator.getStrategy().getName();
    }

    public String startWorkout(boolean warmUp, boolean coolDown, boolean weightedVest, boolean intervals) {
        requireUser();
        requirePlan();
        requireDevice();
        Workout workout = new BasicWorkout(plan.getName(), plan.getTotalMinutes(), plan.getAverageMet());
        if (warmUp) {
            workout = new WarmUpDecorator(workout);
        }
        if (coolDown) {
            workout = new CoolDownDecorator(workout);
        }
        if (weightedVest) {
            workout = new WeightedVestDecorator(workout);
        }
        if (intervals) {
            workout = new IntervalModeDecorator(workout);
        }

        lastWorkout = workout;
        lastCalories = calculator.calculate(user.getWeightKg(), workout, device);
        sessions++;
        totalMinutes += workout.getDurationMinutes();
        totalCalories += lastCalories;

        return "Workout: " + workout.getDescription()
                + "\nDuration: " + workout.getDurationMinutes() + " min, intensity (MET): "
                + String.format("%.1f", workout.getMet())
                + "\nCalories (" + calculator.getStrategy().getName() + "): "
                + String.format("%.1f kcal", lastCalories);
    }

    public void generateReport(String type, String formatName) {
        requireUser();
        requireWorkout();
        ReportFormat format = chooseFormat(formatName);
        Report report;
        switch (type.trim().toLowerCase()) {
            case "daily":
                report = new DailyReport(format, user.getName(), lastWorkout.getDescription(),
                        lastWorkout.getDurationMinutes(), lastCalories);
                break;
            case "weekly":
                report = new WeeklyReport(format, user.getName(), sessions, totalMinutes, totalCalories);
                break;
            default:
                throw new IllegalArgumentException("Unknown report type: " + type);
        }
        report.generate();
    }

    private ProgramFactory chooseProgram(String goal) {
        switch (goal.trim().toLowerCase()) {
            case "weight loss":
                return new WeightLossFactory();
            case "muscle gain":
                return new MuscleGainFactory();
            default:
                throw new IllegalArgumentException("Unknown goal: " + goal);
        }
    }

    private ReportFormat chooseFormat(String formatName) {
        switch (formatName.trim().toLowerCase()) {
            case "console":
                return new ConsoleFormat();
            case "txt":
                return new TextFileFormat();
            case "html":
                return new HtmlFormat();
            default:
                throw new IllegalArgumentException("Unknown format: " + formatName);
        }
    }

    private void requireUser() {
        if (user == null) {
            throw new IllegalStateException("Register a user first");
        }
    }

    private void requirePlan() {
        if (plan == null) {
            throw new IllegalStateException("Create a workout plan first");
        }
    }

    private void requireDevice() {
        if (device == null) {
            throw new IllegalStateException("Connect a wearable device first");
        }
    }

    private void requireWorkout() {
        if (sessions == 0) {
            throw new IllegalStateException("Do at least one workout first");
        }
    }
}
