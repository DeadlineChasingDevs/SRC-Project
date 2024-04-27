import java.util.List;

public class Task {
    private String name;
    private int priority;
    private boolean complete;
    private int additionalTimeNeeded; // in days
    private String completionTime;
    private String completionQuality;
    private int volunteersNeeded;
    private List<String> requiredResources;

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

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getVolunteersNeeded() {
        return volunteersNeeded;
    }

    public List<String> getRequiredResources() {
        return requiredResources;
    }

    public boolean isComplete() {
        return complete;
    }

    public void markAsComplete() {
        this.complete = true;
    }

    public int getAdditionalTimeNeeded() {
        return additionalTimeNeeded;
    }

    public void setAdditionalTimeNeeded(int additionalTimeNeeded) {
        this.additionalTimeNeeded = additionalTimeNeeded;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public String getCompletionQuality() {
        return completionQuality;
    }

    public void setCompletionQuality(String completionQuality) {
        this.completionQuality = completionQuality;
    }

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
