import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TaskScheduler {
    private List<Task> tasks;
    private Queue<Volunteer> volunteers;
    private boolean added; 

    public TaskScheduler() {
        this.tasks = new ArrayList<>();
        this.volunteers = new LinkedList<>();
    }

    // Method to add a task to the task list
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Method to add a volunteer to the volunteer queue
    public void addVolunteer(Volunteer volunteer) {
        added = false;
        for( Volunteer people : volunteers){
            if(people.equals(volunteer)){
                added= true;
            }
        }
        if( added == false){
        volunteers.add(volunteer);
        }

    }
    public List<Task> getTasks() {
        return tasks;
    }

    public boolean anyTasksAvailable() {
        return tasks.size() > 0;
    }
    
    // Method to schedule a task
    public void scheduleTask(Task task) {
        // Find the index to insert the task based on its priority
        int indexToInsert = 0;
        while (indexToInsert < tasks.size() && tasks.get(indexToInsert).getPriority() < task.getPriority()) {
            indexToInsert++;
        }
        // Insert the task at the correct position
        tasks.add(indexToInsert, task);
    }
    

    // Method to assign a task to a volunteer
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
        //volunteers.offer(volunteer); // Move the volunteer to the end of the queue 
    }

    // Method to print the current task schedule
    public void printSchedule() {
        System.out.println("Schedule:");
        for (Volunteer person : volunteers){
            System.out.println(person.getName() +":");
            person.printAssignedTasks();
        }
          
    }
    
    public List<Volunteer> getVolunteers(){
        List<Volunteer> volunteerList = new ArrayList<>();
        while (!volunteers.isEmpty()) {
            volunteerList.add(volunteers.poll()); // Removes and returns the head of the queue
        }
        return volunteerList; 
    }
    
    public Volunteer getNextVolunteer() {
        return volunteers.peek();
    }
}
