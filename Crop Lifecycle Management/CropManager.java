import java.util.ArrayList;
import java.util.List;

// CropManager class to manage crops
public class CropManager {
    private List<Crop> crops;

    public CropManager() {
        this.crops = new ArrayList<>();
    }

    // Method to add a crop to the list
    public void addCrop(Crop crop) {
        crops.add(crop);
    }

    // Method to display the list of crops
    public void displayCrops() {
        System.out.println("Crop List:");
        for (Crop crop : crops) {
            System.out.println(crop);
        }
    }
}
