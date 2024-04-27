public class TaskSchedulerDemo {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks
        Task task1 = new Task("Harvesting", 1);
        Task task2 = new Task("Gardening", 2);
        scheduler.addTask(task1);
        scheduler.addTask(task2);

        // Add volunteers
        Volunteer volunteer1 = new Volunteer("John");
        Volunteer volunteer2 = new Volunteer("Elise");
        scheduler.addVolunteer(volunteer1);
        scheduler.addVolunteer(volunteer2);

        // Schedule tasks and assign to volunteers
        scheduler.scheduleTask(task1);
        scheduler.assignTaskToVolunteer(task1, volunteer1);

        scheduler.scheduleTask(task2);
        scheduler.assignTaskToVolunteer(task2, volunteer2);

        // Display scheduled tasks and assignments
        scheduler.printSchedule();

        volunteer1.removeTask(task1);

        Task task3 = new Task("Maintenance", 1);
        Task task4 = new Task("Livestock", 2);

        scheduler.addTask(task3);
        scheduler.addTask(task4);

        scheduler.scheduleTask(task4);
        scheduler.assignTaskToVolunteer(task4, volunteer1);

        scheduler.scheduleTask(task3);
        scheduler.assignTaskToVolunteer(task3, volunteer2);

        scheduler.printSchedule();
    }
}
