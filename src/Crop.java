import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents an individual crop with its name, expiration duration from planting,
 * planting date, and harvest date.
 */
public class Crop {
    private String name;
    private int expirationDaysFromPlanting; // Duration in days from planting
    private LocalDate plantingDate;
    private LocalDate harvestDate;

    /**
     * Constructs a crop with the given name and expiration duration from planting.
     *
     * @param name                        The name of the crop.
     * @param expirationDaysFromPlanting The expiration duration from planting in days.
     */
    public Crop(String name, int expirationDaysFromPlanting) {
        this.name = name;
        this.expirationDaysFromPlanting = expirationDaysFromPlanting;
    }

    // Getters and setters

    /**
     * Gets the name of the crop.
     *
     * @return The name of the crop.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the expiration duration from planting in days.
     *
     * @return The expiration duration from planting in days.
     */
    public int getExpirationDaysFromPlanting() {
        return expirationDaysFromPlanting;
    }

    /**
     * Gets the planting date of the crop.
     *
     * @return The planting date of the crop.
     */
    public LocalDate getPlantingDate() {
        return plantingDate;
    }

    /**
     * Sets the planting date of the crop.
     *
     * @param plantingDate The planting date of the crop.
     */
    public void setPlantingDate(LocalDate plantingDate) {
        this.plantingDate = plantingDate;
    }

    /**
     * Gets the harvest date of the crop.
     *
     * @return The harvest date of the crop.
     */
    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    /**
     * Sets the harvest date of the crop.
     *
     * @param harvestDate The harvest date of the crop.
     */
    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    /**
     * Calculates the expiration date of the crop based on the planting date
     * and expiration duration.
     *
     * @return The expiration date of the crop.
     */
    public LocalDate calculateExpirationDate() {
        if (plantingDate != null) {
            return plantingDate.plusDays(expirationDaysFromPlanting);
        } else {
            return null;
        }
    }

    /**
     * Formats the given date into a string in the format "yyyy-MM-dd".
     *
     * @param date The date to format.
     * @return The formatted date string, or "Not set" if the date is null.
     */
    public String formatDate(LocalDate date) {
        if (date != null) {
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            return "Not set";
        }
    }

    /**
     * Returns a string representation of the crop, including its name and
     * expiration duration from planting.
     *
     * @return A string representation of the crop.
     */
    @Override
    public String toString() {
        return "Crop: " + name + " | Expiration: " + expirationDaysFromPlanting + " days from planting";
    }
}


