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
	private static InventoryAnalytics inventory = new InventoryAnalytics();
	
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

	// Case 1: Task Management
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
			System.out.println("3) View Tasks and Schedule");
			System.out.println("4) Return to Main Menu");
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
					System.out.println(taskScheduler.getTasks());
					System.out.println();
					taskScheduler.printSchedule();
					break;
	
				case "4":
					isManagingTasks = false;
					break;
	
				default:
					break;
			}
		}
		scan.close();
	}

	// Case 2: Crop Management
	private static void manageCrops() {
		System.out.println("Crop Management");
		// ...
	}

	// Case 3: Report Generator
	private static void generateReport() {
		Scanner input = new Scanner(System.in);
		boolean viewingReports = true;
		
		while (viewingReports) {
			System.out.println();
			System.out.println("1) Crop Growth Report");
			System.out.println("2) Task Completion Report");
			System.out.println("3) Volunteer Rating Survey");
			System.out.println("4) Volunteers and Task Report");
			System.out.println("5) Return to Main Menu");
			System.out.print("Enter number choice: ");
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

	// Case 4: Inventory Management
	private static void manageInventory() {
		Scanner scan = new Scanner(System.in);

		inventory.getInventory(); // Display current inventory
		boolean isManagingInventory = true;

		while (isManagingInventory) {
			System.out.println();
			System.out.println("1) Add a Product");
			System.out.println("2) Remove a Product");
			System.out.println("3) Modify Product Details");
			System.out.println("4) Sell an Item");
			System.out.println("5) See Revenue, Profits, and Expenses");
			System.out.println("6) See Turnover Rate and Inventory Worth");
			System.out.println("7) View Inventory");
			System.out.println("8) Return to Main Menu");
			System.out.print("Enter number choice: ");
			String choice = scan.nextLine();

			switch (choice) {
				case "1":
					System.out.print("Enter product name: ");
					String product = scan.nextLine();
					System.out.print("Enter quantity of product: ");
					int quantity = scan.nextInt();
					System.out.print("Enter amount sold: ");
					int sold = scan.nextInt();
					System.err.println("Enter number of days until experation: ");
					int expire = scan.nextInt();
					System.out.print("Enter sale price: ");
					double price = scan.nextDouble();
					System.out.print("Enter the $ amount invested into product: ");
					double invested = scan.nextDouble();

					inventory.addProduct(new Product(product, quantity, sold, price, invested, expire));
					break;

				case "2":
					System.out.print("Enter product name: ");
					String product = scan.nextLine();

					Product target = inventory.getProduct(product);

					if (target != null)
						inventory.removeProduct(target);
					else
						System.out.println("Product not found.");

					break;

				case "3":
					
					break;

				case "4":
					break;

				case "5":
					break;

				case "6":
					inventory.calcTurnoverRate();
					inventory.calcValInventory();
					System.out.println("Inventory Turnover Rate: " + inventory.getTurnoverRate());
					System.out.println("Amount Invested into Inventory: " + inventory.getValInventory());
					break;

				case "7":
					inventory.getInventory();
					break;

				case "8":
					isManagingInventory = false;
					break;

				default:
					break;
			}
		}
		scan.close();
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