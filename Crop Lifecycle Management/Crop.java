import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Crop class to represent individual crops
public class Crop {
    private String name;
    private int expirationDaysFromPlanting; // Duration in days from planting

    public Crop(String name, int expirationDaysFromPlanting) {
        this.name = name;
        this.expirationDaysFromPlanting = expirationDaysFromPlanting;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getExpirationDaysFromPlanting() {
        return expirationDaysFromPlanting;
    }

    @Override
    public String toString() {
        return "Crop: " + name + " | Expiration: " + expirationDaysFromPlanting + " days from planting";
    }
}
