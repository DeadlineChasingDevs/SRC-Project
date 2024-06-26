import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * This class generates various reports related to crops, tasks, and volunteer performance.
 */
public class ReportGenerator {
    private Scanner scanner;
     /**
     * Constructs a ReportGenerator object.
     * Initializes the scanner to read input from the console.
     */
    public ReportGenerator() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Generates a report detailing the growth status of crops.
     *
     * @param crops A list of Crop objects to generate the report for.
     */
    public void generateCropGrowthReport(List<Crop> crops) {
        System.out.println("Crop Growth Report:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%-20s%n", "Crop", "Planting Date", "Harvest Date", "Expiration Date");
        System.out.println("--------------------------------------------------");
        for (Crop crop : crops) {
            String plantingDate = crop.getPlantingDate() != null
                    ? crop.getPlantingDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    : "Not set";
            String harvestDate = crop.getHarvestDate() != null
                    ? crop.getHarvestDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    : "Not set";
            String expirationDate = crop.calculateExpirationDate() != null
                    ? crop.calculateExpirationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    : "Not set";
            System.out.printf("%-20s%-20s%-20s%-20s%n", crop.getName(), plantingDate, harvestDate, expirationDate);
        }
        System.out.println("--------------------------------------------------");
    }

      /**
     * Generates a report detailing the completion status of tasks and allows user input for incomplete tasks.
     *
     * @param taskScheduler The TaskScheduler object containing tasks to generate the report for.
     */
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
        System.out.println("--------------------------------------------------");
    }

     /**
     * Allows rating and providing feedback for a volunteer.
     *
     * @param volunteer The Volunteer object to rate and provide feedback for.
     */
    public void rateVolunteer(Volunteer volunteer) {
        System.out.print("Rate volunteer " + volunteer.getName() + " (1 to 5): ");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        volunteer.setRating(rating);
        if (rating < 2.5) {
            System.out.println("Volunteer rated below 2.5. Do not assign tasks to them again.");
        } else {
            System.out.print("Provide feedback to volunteer " + volunteer.getName() + ": ");
            String feedback = scanner.nextLine();
            // Store the feedback
            volunteer.setFeedback(feedback);
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Generates a report detailing the ratings and feedback of volunteers.
     *
     * @param volunteers A list of Volunteer objects to generate the report for.
     */
    public void generateVolunteerRatingReport(List<Volunteer> volunteers) {
        System.out.println("Volunteers and Their Ratings / Feedback");

        for (Volunteer volunteer : volunteers) {
            System.out.println("Volunteer: " + volunteer.getName());
            System.out.println("Rating: " + volunteer.getRating());
            System.out.println("Feedback: " + volunteer.getFeedback());
            System.out.println();
        }

        System.out.println("--------------------------------------------------");
    }

    /**
     * Lists the volunteers along with their assigned tasks and expected finish times.
     *
     * @param volunteers A list of Volunteer objects to list their assigned tasks for.
     */
    public void listVolunteersAndTasks(List<Volunteer> volunteers) {
        System.out.println("Volunteers and Their Assigned Tasks:");
        for (Volunteer volunteer : volunteers) {
            System.out.println("Volunteer: " + volunteer.getName());
            if (volunteer.getAssignedTasks().isEmpty()) {
                System.out.println("No tasks assigned.");
            } else {
                for (Task task : volunteer.getAssignedTasks()) {
                    System.out.println("- Task: " + task.getName() + ", Expected Finish Time: " + task.getCompletionTime());
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }
    
     /**
     * Closes the scanner used for user input.
     */
    public void closeScanner() {
        scanner.close();
    }
}
