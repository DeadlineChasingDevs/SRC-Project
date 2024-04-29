import java.util.ArrayList;
import java.util.List;

/**
 * Represents a volunteer who can be assigned tasks.
 */
public class Volunteer {
    private String name;
    private List<Task> assignedTasks;
    private double rating;
    private String feedback;

    
    /**
     * Constructs a Volunteer object with the specified name.
     * Initializes the list of assigned tasks, rating, and feedback.
     * @param name The name of the volunteer.
     */
    public Volunteer(String name) {
        this.name = name;
        this.assignedTasks = new ArrayList<>();
        this.rating = 0;
        this.feedback = "";
    }
    
     /**
     * Retrieves the list of tasks assigned to the volunteer.
     * @return The list of assigned tasks.
     */
    public List<Task> getAssignedTasks() {
            return assignedTasks;
        }
    
     /**
     * Assigns a task to the volunteer.
     * @param task The task to be assigned.
     */
    public void assignTask(Task task) {
        assignedTasks.add(task);
    }

    /**
     * Removes a task from the volunteer's assignments.
     * @param task The task to be removed.
     */
    public void removeTask(Task task) {
        assignedTasks.remove(task);
    }

    /**
     * Prints the volunteer's assigned tasks.
     */
    public void printAssignedTasks() {
        if (assignedTasks.isEmpty()) {
            System.out.println("No tasks assigned to " + name);
        } else {
            for (Task task : assignedTasks) {
                System.out.println(task);
            }
        }
        System.out.println();
    }

    /**
     * Retrieves the name of the volunteer.
     * @return The name of the volunteer.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Provides a string representation of the volunteer.
     * @return A string representing the volunteer.
     */
    public String toString() {
        return "Volunteer: " + name;
    }

    /**
     * Sets the rating of the volunteer.
     * @param rating The rating to be set.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    /**
     * Retrieves the rating of the volunteer.
     * @return The rating of the volunteer.
     */
    public double getRating() {
        return rating;
    }
    
    /**
     * Sets the feedback for the volunteer.
     * @param feedback The feedback to be set.
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    /**
     * Retrieves the feedback for the volunteer.
     * @return The feedback for the volunteer.
     */
    public String getFeedback() {
        return feedback;
    }
}
