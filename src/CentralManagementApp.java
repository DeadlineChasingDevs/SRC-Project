import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * A centralized management app that keeps task scheduling, crop management, farm analytics,
 * and farm reports all in one place, enabling higher farm productivity and efficiency.
 * Note: This is a concept application; data is not saved in between uses.
 */
public class CentralManagementApp {
	private static TaskScheduler taskScheduler = new TaskScheduler();
	private static CropManager cropManager = new CropManager();
	private static ReportGenerator report = new ReportGenerator();
	private static InventoryAnalytics inventory = new InventoryAnalytics();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		initalizeTestValues(); // Set up application with values for Demo purposes

		boolean isRunning = true;
		String choice;

		while (isRunning) {
			displayMainMenu();
			choice = scan.nextLine();
			System.out.println();

			switch (choice) {
				case "1":
					System.out.println("Task / Volunteer Management");
					System.out.println("---------------------------");
					manageTasks();
					break;

				case "2":
					System.out.println("Crop Management");
					System.out.println("---------------");
					manageCrops();
					break;

				case "3":
					System.out.println("Farm Reports");
					System.out.println("------------");
					generateReport();
					break;

				case "4":
					System.out.println("Inventory Analytics");
					System.out.println("-------------------");
					manageInventory();
					break;

				case "5":
					isRunning = false;
					break;

				default:
					System.out.print("Please try again...");
					System.out.println();
			}
		}
		scan.close();
		System.out.println("Closing application...");
		System.out.println();
	}

	// Case 1: Task Management
	private static void manageTasks() {
		if (taskScheduler.anyTasksAvailable()) {
			System.out.println("Available Tasks");
			for (Task task : taskScheduler.getTasks())
				System.out.println(task);
		} else
			System.out.println("No tasks available");
		System.out.println();
		taskScheduler.printSchedule(); // Display ongoing assignments

		boolean isManagingTasks = true;

		while (isManagingTasks) {

			System.out.printf("%n1) Schedule a new Task%n" +
							  "2) Manage Volunteers%n" +
							  "3) View All Tasks and Assigned Schedulet%n" +
							  "4) Return to Main Menu%n%n");
			System.out.print("Enter number choice: ");
			String choice = scan.nextLine();
			System.out.println();

			switch (choice) {
				// Schedule a new task
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

					Task newTask = new Task(taskName, priority, volunteersNeeded, resources);
					taskScheduler.scheduleTask(newTask);

					break;

				// Manage volunteers
				case "2":
					boolean managingVolunteers = true;

					while (managingVolunteers) {
						System.out.printf("%n1) Add a new Volunteer%n" +
										  "2) Give Feedback and Rating to Volunteer%n" +
										  "3) Assign a Task to a Volunteer%n" +
										  "4) View Task Assignments%n" +
										  "5) Exit Volunteer Management Menu%n%n");
						System.out.print("Enter number choice: ");
						String volOption = scan.nextLine();
						System.out.println();
	
						switch (volOption) {
							// Add volunteer
							case "1":
								System.out.print("Enter volunteer name: ");
								String newVol = scan.nextLine();
								taskScheduler.addVolunteer(new Volunteer(newVol));
								break;

							// Rate and give feedback to volunteer
							case "2":
								System.out.print("Enter volunteer name: ");
								String volToRate = scan.nextLine();

								Volunteer targetVol = findVolunteerByName(volToRate);

								if (targetVol == null)
									System.out.println("Volunteer Not Found");
								else
									report.rateVolunteer(targetVol);
								break;
	
							// Assign task
							case "3":
								System.out.print("Enter volunteer name: ");
								String volToAssign = scan.nextLine();

								Volunteer volunteer = findVolunteerByName(volToAssign);

								if (volunteer != null) {
									System.out.print("Enter task name: ");
									String taskToAssign = scan.nextLine();

									Task targetTask = findTaskByName(taskToAssign);
									if (targetTask == null)
										System.out.println("Task Not Found");
									else
										taskScheduler.assignTaskToVolunteer(targetTask, volunteer);

								} else
									System.out.println("Volunteer Not Found");
								break;
	
							// View task assignments
							case "4":
								taskScheduler.printSchedule();
								break;
	
							// Exit Volunteer Management Menu
							case "5":
								managingVolunteers = false;
								break;
	
							default:
								break;
						}
					}
					break;

				// View tasks and schedule
				case "3":
					if (taskScheduler.anyTasksAvailable()) {
						System.out.println("Available Tasks");
						for (Task task : taskScheduler.getTasks())
							System.out.println(task);
					} else
						System.out.println("No tasks available");
					System.out.println();
					taskScheduler.printSchedule();
					break;

				// Return to main menu
				case "4":
					isManagingTasks = false;
					break;

				default:
					break;
			}
		}
	}

	// Case 2: Crop Management
	private static void manageCrops() {
		System.out.println("Crop Management");
		// ...
	}

	// Case 3: Report Generator
	private static void generateReport() {
		boolean viewingReports = true;

		while (viewingReports) {
			System.out.printf("%n1) Crop Growth Report%n" +
							  "2) Task Completion Report%n" +
							  "3) Volunteer Rating Report%n" +
							  "4) Volunteers and Tasks Report%n" +
							  "5) Return to Main Menu%n%n");
			System.out.print("Enter number choice: ");
			String choice = scan.nextLine();
			System.out.println();

			switch (choice) {
				// Crop Growth Report
				case "1":
					boolean cropsEmpty = (cropManager.getCrops()).isEmpty();
					if (cropsEmpty)
						System.out.println("Crop List is Empty");
					else
						report.generateCropGrowthReport(cropManager.getCrops());
					break;

				// Task Completion Report
				case "2":
					report.generateTaskCompletionReport(taskScheduler);
					break;

				// Volunteer Rating Report
				case "3":
					report.generateVolunteerRatingReport(taskScheduler.getVolunteers());
					break;

				// Volunteers and Tasks Report
				case "4":
					report.listVolunteersAndTasks(taskScheduler.getVolunteers());
					break;

				// Return to main menu
				case "5":
					viewingReports = false;
					break;

				default:
					break;
			}
		}
	}

	// Case 4: Inventory Management
	private static void manageInventory() {

		inventory.getInventory(); // Display current inventory
		boolean isManagingInventory = true;

		while (isManagingInventory) {
			System.out.printf("%n1) Add a Product%n" +
							  "2) Remove a Product%n" +
							  "3) Modify Product Details%n" +
							  "4) Sell Product%n" +
							  "5) See Revenue and Expenses%n" +
							  "6) See Turnover Rate and Inventory Worth%n" +
							  "7) View Inventory%n" +
							  "8) Return to Main Menu%n%n"			 
							  );
			System.out.print("Enter number choice: ");
			String choice = scan.nextLine();
			System.out.println();

			switch (choice) {
				// Add a product
				case "1":
					System.out.print("Enter product name: ");
					String addProduct = scan.nextLine();
					System.out.print("Enter quantity of product: ");
					int quantity = scan.nextInt();
					System.out.print("Enter amount sold: ");
					int sold = scan.nextInt();
					System.err.print("Enter number of days until expiration: ");
					int expire = scan.nextInt();
					System.out.print("Enter sale price: ");
					double price = scan.nextDouble();
					System.out.print("Enter the $ amount invested into product: ");
					double invested = scan.nextDouble();

					inventory.addProduct(new Product(addProduct, quantity, sold, price, invested, expire));
					break;

				// Remove a product
				case "2":
					System.out.print("Enter product name: ");
					String removeProduct = scan.nextLine();

					Product removeTarget = inventory.getProduct(removeProduct);

					if (removeTarget != null)
						inventory.removeProduct(removeTarget);
					else
						System.out.println("Product not found.");

					break;

				// Modify Product Details
				case "3":
					System.out.print("Enter to-be-modified product name: ");
					String modifyProduct = scan.nextLine();
					boolean modifyingProduct = true;
					Product modifyTarget = inventory.getProduct(modifyProduct);

					if (modifyTarget == null)
						System.out.println("Product not found.");

					while (modifyingProduct) {
						System.out.printf("%n1) Sell Price%n" +
										  "2) Quantity Available%n" +
										  "3) Expiration Date%n" +
										  "4) Exit Modification%n%n");
						System.out.print("What would you like to modify? ");
						String modOption = scan.nextLine();
						System.out.println();

						switch (modOption) {
							// Sell Price
							case "1":
								System.out.print("What is the new sell price? ");
								int newPrice = scan.nextInt();
								modifyTarget.setSellPrice(newPrice);
								break;

							// Quantity Available
							case "2":
								System.out.print("How much product is available? ");
								int newQuantity = scan.nextInt();
								modifyTarget.setQuantity(newQuantity);
								break;

							// Expiration Date
							case "3":
								System.out.print("How many days until the product expires? ");
								int newDays = scan.nextInt();
								modifyTarget.setExpiration(newDays);
								break;

							// Exit Modification Menu
							case "4":
								modifyingProduct = false;
								break;

							default:
								break;
						}
					}
					break;

				// Sell product
				case "4":
					System.out.print("Enter purchased product name: ");
					String productSoldName = scan.nextLine();
					Product targetSold = inventory.getProduct(productSoldName);

					if (targetSold == null)
						System.out.println("Product not found.");

					System.out.print("Enter amount sold: ");
					int soldAmount = scan.nextInt();

					inventory.sellItem(targetSold, soldAmount);

					break;

				// See revenue and expenses
				case "5":
					System.out.println("Revenue: " + inventory.getRevenue());
					System.out.println("Expenses: " + inventory.getExpenses());
					System.out.println("Calculated Profits: " + inventory.getProfits());
					break;

				// See turnover tate and inventory worth
				case "6":
					System.out.println("Inventory Turnover Rate: " + inventory.getTurnoverRate());
					System.out.println("Amount Invested into Inventory: " + inventory.getValInventory());
					break;

				// View inventory
				case "7":
					inventory.getInventory();
					break;

				// Return to main menu
				case "8":
					isManagingInventory = false;
					break;

				default:
					break;
			}
		}
	}

	private static void displayMainMenu() {

		System.out.printf("%nLopez Urban Farm Management App 1.0%n" +
						  "-----------------------------------%n" +
						  "1) Task / Volunteer Management%n" +
						  "2) Crop Management%n" +
						  "3) Farm Reports%n" +
						  "4) Inventory Analytics%n" +
						  "5) Exit%n%n");

		System.out.print("Enter number choice: ");
	}

	// Since data is not saved in between uses, we set up values for Demo purposes for each use
	private static void initalizeTestValues() {

		// Volunteers
		Volunteer v = new Volunteer("Prakriti");
		taskScheduler.addVolunteer(new Volunteer("Liam"));
		taskScheduler.addVolunteer(new Volunteer("Jazmin"));
		taskScheduler.addVolunteer(new Volunteer("Guanlin"));
		taskScheduler.addVolunteer(new Volunteer("Eric"));
		taskScheduler.addVolunteer(v);

		// Tasks
		List<String> gardeningList = new ArrayList<>();
		gardeningList.add("shovel");
		gardeningList.add("seeds");
		Task garden = new Task("Garden", 3, 2, gardeningList);

		List<String> tourList = new ArrayList<>();
		tourList.add("farm map");
		Task tour = new Task("Farm Tour", 1, 1, tourList);

		taskScheduler.scheduleTask(garden);
		taskScheduler.scheduleTask(tour);

		taskScheduler.assignTaskToVolunteer(tour, v);

		// Crop Management
		cropManager.addCrop(new Crop("Tomatoes", 60));
		cropManager.addCrop(new Crop("Lettuce", 90));
		cropManager.addCrop(new Crop("Carrots", 120));

		// Farm Analytics
		inventory.addProduct(new Product("Tomato", 100, 0, 10.00, 8.00, 30));
		inventory.addProduct(new Product("Corn", 50, 0, 20.00, 15.00, 60));
		inventory.setExpenses(50.0);
	}

	private static Volunteer findVolunteerByName(String name) {
		List<Volunteer> volunteers = taskScheduler.getVolunteers();
		Volunteer target = null;
		boolean volunteerFound = false;
		int next = 0;

		while (!volunteerFound && next < volunteers.size()) {
			target = volunteers.get(next);
			if (name.equalsIgnoreCase(target.getName()))
				volunteerFound = true;
		}

		if (volunteerFound) 
			return target;
		return null;
	}

	private static Task findTaskByName(String name) {
		List<Task> tasks = taskScheduler.getTasks();
		Task target = null;
		boolean taskFound = false;
		int next = 0;

		while (!taskFound && next < tasks.size()) {
			target = tasks.get(next);
			if (name.equalsIgnoreCase(target.getName()))
				taskFound = true;
		}

		if (taskFound) 
			return target;
		return null;
	}
}