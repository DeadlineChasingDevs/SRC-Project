import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/** 
 * A centralized management app that keeps task scheduling, crop management, farm analytics, 
 * and a farm report all in one place, enabling higher farm productivity and efficiency.
 * Note: This is a concept application; data is not saved in between uses.
 */
public class CentralManagementApp {
	private static TaskScheduler taskScheduler = new TaskScheduler();
	private static CropManager cropManager = new CropManager();
	private static ReportGenerator report = new ReportGenerator();
	
	public static void main(String[] args) {
		boolean isRunning = true;
		Scanner scan = new Scanner(System.in);
		
		while (isRunning) {
			displayMainMenu();
			String choice = scan.nextLine();
			
			switch (choice) {
				case "1": 
					manageTasks();
					break;
				case "2":
					manageCrops();
					break;
				case "3":
					generateReport();
					break;
				case "4":
					manageInventory();
					break;
				case "5":
					isRunning = false;
					break;
				default:
					System.out.print("Please try again: ");
			}
		}
		scan.close();
		System.out.println("Closing application...");
		System.out.println();
	}

	private static void manageTasks() {
		Scanner scan = new Scanner(System.in);

		System.out.println(taskScheduler.getTasks()); // Display all tasks
		System.out.println();
		taskScheduler.printSchedule(); // Display ongoing assignments

		boolean isManagingTasks = true;
		
		while (isManagingTasks) {
			System.out.println();
			System.out.println("1) Schedule a new Task");
			System.out.println("2) Manage Volunteers");
			System.out.println("3) Return to Main Menu");
			System.out.print("Enter number choice: ");
			String choice = scan.nextLine();

			switch (choice) {
				case "1":
					System.out.print("Enter new task name: ");
					String taskName = scan.nextLine();
					System.out.println("Enter the resources required one at a time (type 'done' to end list):");
					List<String> resources = new ArrayList<>();
					String resource = scan.nextLine();
					while (!resource.equals("done")) {
						resources.add(resource);
						resource = scan.nextLine();
					}
					System.out.print("Enter task priority: ");
					int priority = scan.nextInt();
					System.out.print("How many volunteers needed for task? ");
					int volunteersNeeded = scan.nextInt();

					Task newTask = new Task(taskName, priority, volunteersNeeded, resources)
	
					taskScheduler.scheduleTask(newTask);

					System.out.print("Would you like to assign this task to the next available Volunteer (Y/N)? ");
					boolean assigned = scan.nextLine().equalsIgnoreCase("Y");
					if (assigned)
						taskScheduler.assignTaskToVolunteer(newTask, taskScheduler.getNextVolunteer());

					break;
	
				case "2":

					break;
	
				case "3":
					isManagingTasks = false;
					break;
	
				default:
					break;
			}
		}
		scan.close();
	}

	private static void manageCrops() {
		System.out.println("Crop Management");
		// ...
	}

	private static void generateReport() {
		Scanner input = new Scanner(System.in);
		boolean viewingReports = true;
		
		while (viewingReports) {
			System.out.println();
			System.out.println("a) Crop Growth Report");
			System.out.println("b) Task Completion Report");
			System.out.println("c) Volunteer Rating Survey");
			System.out.println("d) Volunteers and Task Report");
			System.out.println("e) Return to Main Menu");
			System.out.print("Select Desired Report letter: ");
			String choice = input.nextLine();

			switch (choice) {
				case "a":
					boolean cropsEmpty = (cropManager.getCrops()).isEmpty();
					if (cropsEmpty) {
						System.out.println("Crop List Empty");
					} 
					else {
						report.generateCropGrowthReport(cropManager.getCrops());
					}
					break; 

				case "b": 
					report.generateTaskCompletionReport(taskScheduler);
					break;

				case "c": 
					System.out.print("Enter Volunteer's Name: ");
					String volunteerName = input.nextLine(); 
					boolean volunteerFound = false;
				
					for (Volunteer person : taskScheduler.getVolunteers()) {
						if (person.getName().equalsIgnoreCase(volunteerName))
							volunteerFound = true;
					}

					if (volunteerFound) {
						System.out.println("Volunteer Found...");
						report.rateVolunteer(person);
					}
					else
						System.out.println("Volunteer Not Found");
					break; 

				case "d": 
					report.listVolunteersAndTasks(taskScheduler.getVolunteers());
					break;

				case "e":
					viewingReports = false;
					break;
					
				default: 
					break; 
			}
		}
		input.close();
	}

	private static void manageInventory() {
		//
	}

	private static void displayMainMenu() {
		System.out.println("Lopez Urban Farm Management App 1.0");
		System.out.println("-----------------------------------");
		System.out.println("1) Task Management");
		System.out.println("2) Crop Management");
		System.out.println("3) Farm Report");
		System.out.println("4) Inventory Analytics");
		System.out.println("5) Exit");
		System.out.println();

		System.out.print("Enter number choice: ");
	}
}