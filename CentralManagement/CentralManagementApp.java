import java.util.Scanner;

/** 
 * A centralized management app that keeps task scheduling, crop management, farm analytics, 
 * and a farm report all in one place, enabling higher farm productivity and efficiency.
 */

public class CentralManagementApp {
	public static void main(String[] args) {

		System.out.println("Lopez Urban Farm Management App 1.0");
		
		boolean isRunning = true;
		Scanner scan = new Scanner(System.in);

		displayMainMenu();

		while (isRunning) {
			String choice = scan.nextLine();

			switch (choice) {
				case "1": 
					manageTasks();
					break;
				case "2":
					manageCrops();
					break;
				case "3":
					farmAnalytics();
					break;
				case "4":
					generateReport();
					break;
				case "5":
					isRunning = false;
					break;
				default:
					System.out.print("Please try again: ");
			}
		}

		System.out.println("Closing application...");
		System.out.println();
		scan.close();
	}

	private static void manageTasks() {
		TaskScheduler taskScheduler = new TaskScheduler();
		
		// display all tasks
		displayTasks();

		// display ongoing assignments
		taskScheduler.printSchedule();

		// does user want to interact with tasks?

		// ask user to exit program or return to main menu

	}

	private static void displayTasks() {
		

	}

	private static void manageCrops() {
		System.out.println("Crop Management");
		// ...
	}

	private static void farmAnalytics() {
		System.out.println("Farm Analytics");
		// ...
	}

	private static void generateReport() {
		System.out.println("Generating your report...");
		// ...
	}

	private static void displayMainMenu() {
		System.out.println("1) Task Management");
		System.out.println("2) Crop Management");
		System.out.println("3) Farm Analytics");
		System.out.println("4) Farm Report");
		System.out.println("5) Exit");
		System.out.println();

		System.out.print("Enter number choice: ");
	}
}