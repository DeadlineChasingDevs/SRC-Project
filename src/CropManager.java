import java.util.List;
import java.util.ArrayList;

/**
 * Manages a list of crops, allowing addition and display of crops.
 */
public class CropManager {
    private List<Crop> crops;

    /**
     * Constructs a CropManager with an empty list of crops.
     */
    public CropManager() {
        this(new ArrayList<>());
    }

    /**
     * Constructs a CropManager with the specified list of crops.
     *
     * @param crops The list of crops to manage.
     */
    public CropManager(List<Crop> crops) {
        this.crops = crops;
    }

    /**
     * Adds a crop to the list of managed crops.
     *
     * @param crop The crop to add.
     */
    public void addCrop(Crop crop) {
        crops.add(crop);
    }

    /**
     * Displays the list of crops managed by this CropManager.
     */
    public void displayCrops() {
        System.out.println("Crop List:");

        for (Crop crop : crops) {
            System.out.println(crop);
        }
    }

    /**
     * Gets the list of crops managed by this CropManager.
     *
     * @return The list of crops.
     */
    public List<Crop> getCrops() {
        return crops;
    }
}

