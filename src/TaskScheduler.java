import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
/**
* Manages the tasks, assigns tasks to volunteers, and shows the schedule  of the volunteers 
**/
public class TaskScheduler {
    private List<Task> tasks;
    private Queue<Volunteer> volunteers;
    private boolean added;

    /**
    *Constructs a TaskScheduler object.
    * Initializes the task list and the volunteer queue.
    **/
    public TaskScheduler() {
        this.tasks = new ArrayList<>();
        this.volunteers = new LinkedList<>();
    }

    /**
    *Method to add a task to the task list
    **/
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Adds a volunteer to the list if they are not already present.
     * @param volunteer The volunteer to be added.
     */
    public void addVolunteer(Volunteer volunteer) {
        added = false;
        for (Volunteer people : volunteers) {
            if (people.equals(volunteer)) {
                added = true;
            }
        }
        if (added == false) {
            volunteers.add(volunteer);
        }

    }

    /**
     * Retrieves the list of tasks.
     * @return The list of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }
    
    /**
     * Checks if any tasks are available. 
     * @return True if there are tasks available, otherwise false.
     */
    public boolean anyTasksAvailable() {
        return tasks.size() > 0;
    }

    /**
     * Method to schedule a task based on its priority.
     * @param task The task to be scheduled.
     */
    public void scheduleTask(Task task) {
        // Find the index to insert the task based on its priority
        int indexToInsert = 0;
        while (indexToInsert < tasks.size() && tasks.get(indexToInsert).getPriority() < task.getPriority()) {
            indexToInsert++;
        }
        // Insert the task at the correct position
        tasks.add(indexToInsert, task);
    }

    /**
     * Method to assign a task to a volunteer.
     * @param task      The task to be assigned.
     * @param volunteer The volunteer to whom the task will be assigned.
     */
    public void assignTaskToVolunteer(Task task, Volunteer volunteer) {
        if (!tasks.contains(task)) {
            System.out.println("Task not found.");
            return;
        }
        if (volunteers.isEmpty()) {
            System.out.println("No volunteers available.");
            return;
        }
        // Assign the task to the volunteer
        volunteer.assignTask(task);
        tasks.remove(task); // Remove the task from the task list
        // volunteers.offer(volunteer); // Move the volunteer to the end of the queue
    }

    /**
     * Method to print the current task schedule.
     */
    public void printSchedule() {
        System.out.println("Schedule:");
        for (Volunteer person : volunteers) {
            System.out.println(person.getName() + ":");
            person.printAssignedTasks();
        }

    }

    /**
     * Retrieves the list of volunteers, removing them from the internal queue.
     * @return The list of volunteers.
     */
    public List<Volunteer> getVolunteers() {
        List<Volunteer> volunteerList = new ArrayList<>();
        while (!volunteers.isEmpty()) {
            volunteerList.add(volunteers.poll()); // Removes and returns the head of the queue
        }
        return volunteerList;
    }

    /**
     * Retrieves the next volunteer in the queue without removing them.
     * @return The next volunteer in the queue.
     */
    public Volunteer getNextVolunteer() {
        return volunteers.peek();
    }
}
