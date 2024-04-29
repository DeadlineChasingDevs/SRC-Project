import java.util.List;
/**
Class used to create a task and store all its components
**/
public class Task {
    /** 
    * Variables used for a task 
    **/
    private String name;
    private int priority;
    private boolean complete;
    private int additionalTimeNeeded; // in days
    private String completionTime;
    private String completionQuality;
    private int volunteersNeeded;
    private List<String> requiredResources;

    /** 
     * Constructor 
     * initalizes all varables for the task 
     * @param name 
     * @param volunteersNeeded
     * @param requiredResources 
     * **/
    public Task(String name, int priority, int volunteersNeeded, List<String> requiredResources) {
        this.name = name;
        this.priority = priority;
        this.volunteersNeeded = volunteersNeeded;
        this.requiredResources = requiredResources;
        this.complete = false;
        this.additionalTimeNeeded = 0;
        this.completionTime = "";
        this.completionQuality = "";
    }

    // Getters and setters
    /**
     * @return name of task
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return number of priority of the task
     */
    public int getPriority() {
        return priority;
    }
    
     /**
     * @return the number of volunteers set for task
     */
    public int getVolunteersNeeded() {
        return volunteersNeeded;
    }

     /**
     * @return the given requirements of task
     */
    public List<String> getRequiredResources() {
        return requiredResources;
    }

    /**
     * @return if task is completed with boolean complete
     */
    public boolean isComplete() {
        return complete;
    }

    /** 
     * sets task as completed 
     */
    public void markAsComplete() {
        this.complete = true;
    }
    
     /**
     * @return if task need more time till being completed
     */
    public int getAdditionalTimeNeeded() {
        return additionalTimeNeeded;
    }

    /**
     * set additional time need for task to be completed
     * @param additionalTimeNeeded given value to local AdditionalTimeNeeded
     */
    public void setAdditionalTimeNeeded(int additionalTimeNeeded) {
        this.additionalTimeNeeded = additionalTimeNeeded;
    }

    /**
     * @return the time task was completed
     */
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * sets time was completed 
     * @param completionTime new value to local completionTime
     */
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

      /**
     * @return  rating of completion quality
     */
    public String getCompletionQuality() {
        return completionQuality;
    }

    /**
     * Sets the rating of how the quality of task was when completed 
     * @param completionQuality new value to local completionQuality
     */
    public void setCompletionQuality(String completionQuality) {
        this.completionQuality = completionQuality;
    }

    /**
     * @return new toString 
     */ 
    @Override
    public String toString() {
        String statusStr = complete ? "Complete" : "Incomplete";
        if (!complete && additionalTimeNeeded > 0) {
            statusStr += " (Additional time needed: " + additionalTimeNeeded + " days)";
        }
        return "Task: " + name + " | Status: " + statusStr + " | Priority: " + priority +
                " | Volunteers needed: " + volunteersNeeded + " | Resources: " + requiredResources;
    }
}
