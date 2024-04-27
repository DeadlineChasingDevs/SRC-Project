
import java.util.List;
import java.util.Scanner;

public class ReportGenerator {
    private Scanner scanner;

    public ReportGenerator() {
        this.scanner = new Scanner(System.in);
    }

    // Method to generate crop growth report

    // Method to generate task completion report
    public void generateTaskCompletionReport(TaskScheduler taskScheduler) {
        System.out.println("Task Completion Report:");
        List<Task> tasks = taskScheduler.getTasks();
        for (Task task : tasks) {
            System.out.println(task);
            if (!task.isComplete()) {
                System.out.print("Is task complete? (yes/no): ");
                String complete = scanner.nextLine().toLowerCase();
                if (complete.equals("no")) {
                    System.out.print("How many more days needed? ");
                    int daysNeeded = scanner.nextInt();
                    task.setAdditionalTimeNeeded(daysNeeded);
                    scanner.nextLine(); // Consume newline
                } else if (complete.equals("yes")) {
                    System.out.print("Enter completion time: ");
                    String completionTime = scanner.nextLine();
                    task.setCompletionTime(completionTime);
                    System.out.print("Enter completion quality: ");
                    String completionQuality = scanner.nextLine();
                    task.setCompletionQuality(completionQuality);
                }
            }
        }
    }

    // Method to generate volunteer performance report

    public void closeScanner() {
        scanner.close();
    }
}
