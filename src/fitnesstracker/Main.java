package fitnesstracker;

import fitnesstracker.facade.FitnessTrackerFacade;

import java.util.Scanner;

public class Main {
    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        FitnessTrackerFacade tracker = new FitnessTrackerFacade();
        boolean running = true;
        while (running) {
            printMenu();
            String choice = IN.nextLine().trim();
            try {
                switch (choice) {
                    case "1":
                        System.out.println(tracker.registerUser(ask("Name: "), askInt("Age: "),
                                askDouble("Weight (kg): "), askDouble("Height (cm): ")));
                        break;
                    case "2":
                        System.out.println(tracker.connectDevice(ask("Device (fitbit / apple / xiaomi): ")));
                        break;
                    case "3":
                        String goal = askInt("Goal: 1 - weight loss, 2 - muscle gain: ") == 1 ? "weight loss" : "muscle gain";
                        System.out.println(tracker.createPlan(goal));
                        break;
                    case "4":
                        System.out.println(tracker.setCalorieMethod(ask("Calorie method (met / heart / steps): ")));
                        break;
                    case "5":
                        System.out.println(tracker.startWorkout(askYes("Add warm-up?"), askYes("Add cool-down?"),
                                askYes("Add weighted vest?"), askYes("Interval mode?")));
                        break;
                    case "6":
                        tracker.generateReport(ask("Report (daily / weekly): "), ask("Format (console / txt / html): "));
                        break;
                    case "7":
                        runDemo(new FitnessTrackerFacade());
                        break;
                    case "0":
                        running = false;
                        break;
                    default:
                        System.out.println("Unknown option");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Bye!");
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== FITNESS TRACKER =====");
        System.out.println("1. Register user");
        System.out.println("2. Connect wearable device   (Adapter)");
        System.out.println("3. Create workout plan       (Abstract Factory + Factory Method + Builder)");
        System.out.println("4. Choose calorie method     (Strategy)");
        System.out.println("5. Start workout             (Decorator + Strategy)");
        System.out.println("6. Generate report           (Bridge)");
        System.out.println("7. Run full demo             (all patterns)");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void runDemo(FitnessTrackerFacade tracker) {
        title("Register user");
        System.out.println(tracker.registerUser("Yernar", 20, 75, 180));

        title("Adapter - connect Xiaomi Band");
        System.out.println(tracker.connectDevice("xiaomi"));

        title("Abstract Factory, Factory Method, Builder - create plan");
        System.out.println(tracker.createPlan("weight loss"));

        title("Decorator - warm-up and cool-down, MET formula");
        System.out.println(tracker.startWorkout(true, true, false, false));

        title("Strategy - heart rate formula, vest and intervals");
        System.out.println(tracker.setCalorieMethod("heart"));
        System.out.println(tracker.startWorkout(false, false, true, true));

        title("Bridge - daily report");
        tracker.generateReport("daily", "console");

        title("Bridge - weekly report in 3 formats");
        tracker.generateReport("weekly", "console");
        tracker.generateReport("weekly", "txt");
        tracker.generateReport("weekly", "html");
    }

    private static void title(String text) {
        System.out.println();
        System.out.println(">>> " + text);
    }

    private static String ask(String prompt) {
        System.out.print(prompt);
        return IN.nextLine().trim();
    }

    private static int askInt(String prompt) {
        return Integer.parseInt(ask(prompt));
    }

    private static double askDouble(String prompt) {
        return Double.parseDouble(ask(prompt));
    }

    private static boolean askYes(String question) {
        return ask(question + " (y/n): ").equalsIgnoreCase("y");
    }
}
