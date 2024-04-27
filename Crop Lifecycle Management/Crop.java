import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Crop class to represent individual crops
public class Crop {
    private String name;
    private int expirationDaysFromPlanting; // Duration in days from planting
    private LocalDate plantingDate;
    private LocalDate harvestDate;

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
    /*added planting date*/
    public LocalDate getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(LocalDate plantingDate) {
        this.plantingDate = plantingDate;
    }
    @Override
    public String toString() {
        return "Crop: " + name + " | Expiration: " + expirationDaysFromPlanting + " days from planting";
    }
}
