
public class Task {
    private String name;
    private int priority;
    private String status;
    /*added functions*/
    private boolean complete;
    private int additionalTimeNeeded;
    private String completionTime;
    private String completionQuality;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.status = "unassigned"; // Initial status
    }

    public String getName(){
        return name; 
    }

    public void setName(String name){
        this.name = name; 
    }

    public int getPriority(){
        return priority; 
    }

    public void setPriority(int priority){
        this.priority = priority; 
    }

    public String getStatus(){
        return status; 
    }

    public void setStatus (String status){
        this.status = status; 
    }

    
   /*added getters and setters*/
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
    public String toString() {
        String statusStr = complete ? "Complete" : "Incomplete";
        if (!complete && additionalTimeNeeded > 0) {
            statusStr += " (Additional time needed: " + additionalTimeNeeded + " days)";
        }
        return "Task: " + name + " | Status: " + statusStr + " | Priority: " + priority;
    }
}
