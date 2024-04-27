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
    /*added planting date,harvesting date*/
    public LocalDate getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(LocalDate plantingDate) {
        this.plantingDate = plantingDate;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    public LocalDate calculateExpirationDate() {
        if (plantingDate != null) {
            return plantingDate.plusDays(expirationDaysFromPlanting);
        } else {
            return null;
        }
    }

    public String formatDate(LocalDate date) {
        if (date != null) {
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            return "Not set";
        }
    }
    @Override
    public String toString() {
        return "Crop: " + name + " | Expiration: " + expirationDaysFromPlanting + " days from planting";
    }
}
