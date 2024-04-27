import java.util.ArrayList;
import java.util.List;

public class Crop {
    private String name;
    private int expirationDuration; // in days
    private List<Task> tasks;

    public Crop(String name, int expirationDuration) {
        this.name = name;
        this.expirationDuration = expirationDuration;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getExpirationDuration() {
        return expirationDuration;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public String toString() {
        return "Crop: " + name + " | Expiration: " + expirationDuration + " days from planting";
    }
}
