import java.util.ArrayList;
import java.util.List;

public class Volunteer {
    private String name;
    private List<Task> assignedTasks;
    private double rating;
    private String feedback;

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }
    
    public Volunteer(String name) {
        this.name = name;
        this.assignedTasks = new ArrayList<>();
        this.rating = 0;
        this.feedback = "";
    }

    // Method to assign a task to the volunteer
    public void assignTask(Task task) {
        assignedTasks.add(task);
    }

    // Method to remove a task from the volunteer's assignments
    public void removeTask(Task task) {
        assignedTasks.remove(task);
    }

    // Method to print the volunteer's assigned tasks
    public void printAssignedTasks() {
        if (assignedTasks.isEmpty()) {
        System.out.println("No tasks assigned to " + name);
    } else {
        System.out.println(name + "'s Assigned Tasks:");
        for (Task task : assignedTasks) {
            System.out.println(task);
        }
    }
        
    }

    public String getName(){
        return name;
    }


    public String toString() {
        return "Volunteer: " + name;
    }
     public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }
}
