
public class Task {
    private String name;
    private int priority;
    private String status;

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
   
    public String toString() {
        return "Task: " + name + " | Status: " + status + " | Priority: " + priority;
    }
}
