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
			System.out.println("Lopez Urban Farm Management App 1.0");
           		System.out.println("-----------------------------------");
			
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

		System.out.println("1) Schedule a new Task");
		System.out.println("2) Manage Volunteers");
		System.out.println("3) Return to Main Menu");
		System.out.println("Enter number choice: ");
		String choice = scan.nextLine();

		boolean isManagingTasks = true;

		while (isManagingTasks) {
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
					System.out.println("How many volunteers needed for task? ");
					int volunteersNeeded = scan.nextInt();

					Task newTask = new Task(taskName, priority, volunteersNeeded, resources)
	
					taskScheduler.scheduleTask(newTask);

					System.out.println("Would you like to assign this task to the next available Volunteer? (Y/N)");
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
			System.out.println("Enter number choice: ");
		}
	}

	private static void manageCrops() {
		System.out.println("Crop Management");
		// ...
	}

	private static void generateReport() {
        Scanner input = new Scanner(System.in);
        boolean reportGiven = false;
        while (!reportGiven) {

            System.out.println(" Select Desired Report:\n a) Crop Growth Report \n b) Task Completion Report \n c) Volunteer Rating Report \n d) Volunteers and Task Report");
            String option = input.nextLine();
            switch(option) {
                case "a":
                System.out.println("Crop"); 
                    //report.generateCropGrowthReport(null);
                    reportGiven = true;
                    break;
                case "b": 
                    System.out.println("Task"); 
                    //report.generateTaskCompletionReport(taskScheduler);
                    reportGiven = true;
                    break;
                case "c": 
                    boolean volunteerFound =false;
                    while(!volunteerFound){
                        System.out.println("Enter Volunteer's Name");
                        String gnInput= input.nextLine(); 
                    
                        for(Volunteer person: taskScheduler.getVolunteers()){
                            if((person.getName()).equalsIgnoreCase(gnInput)){
                                System.out.println("Volunteer Found");
                                System.out.println("Generating Report");
                                report.rateVolunteer(person);
                                reportGiven = true;
                                break;
                            }
                        }

                        System.out.println("Volunteer Not Found");

                        boolean tryAgain = false;
                        while (!tryAgain){
                            System.out.println("Would you like to Input Another Name? (Y/N)");
                            String choice = input.nextLine(); 
                            switch(choice) {
                                case "Y":
                                    volunteerFound = false;
                                    tryAgain = true;
                                    break;
                                case "N":
                                volunteerFound = true;
                                tryAgain = true;
                                    break;    
                                default:
                                    System.out.println("Please enter Y or N ");
                                    volunteerFound = false;
                                    tryAgain = false;
                                    break ;    
                            }
                        }
                    }
                    break; 
                case "d": 
                    System.out.println("Task and Volunnterr"); 
                    //report.listVolunteersAndTasks(null);
                    reportGiven = true;
                    break;
                default: 
                    break; 
                }
                
                boolean tryAgain = false;
                while (!tryAgain){
                    System.out.println("Would you like to print another report? (Y/N)");
                    String answer = input.nextLine(); 
                    switch (answer) {
                        case "Y":
                            reportGiven = false;  
                            tryAgain = true;
                            break;
                        case "N": 
                            reportGiven = true;
                            tryAgain = true;
                            break;
                        default:
                            System.out.println("Option given isn't valid input");
                            break;
                    }
                }
            }
            input.close();

	    }

	private static void displayMainMenu() {
		System.out.println("1) Task Management");
		System.out.println("2) Crop Management");
		System.out.println("3) Farm Report");
		System.out.println("4) Exit");
		System.out.println();

		System.out.print("Enter number choice: ");
	}
}
