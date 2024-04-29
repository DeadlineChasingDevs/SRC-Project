/**
 * Main class to demonstrate the functionality of the Crop Lifecycle Management section.
 */
public class CropLifecycleManagementDemo {
    /**
     * Main method to run the demonstration of crop lifecycle management.
     *
     * @param args The command line arguments (not used in this demo).
     */
    public static void main(String[] args) {
        // Instantiate CropManager
        CropManager cropManager = new CropManager();

        // Add crops
        Crop crop1 = new Crop("Tomatoes", 60); // Expiration: 60 days from planting
        Crop crop2 = new Crop("Lettuce", 90); // Expiration: 90 days from planting
        Crop crop3 = new Crop("Carrots", 120); // Expiration: 120 days from planting
        Crop crop4 = new Crop("Broccoli", 75); // Expiration: 75 days from planting
        Crop crop5 = new Crop("Bell Peppers", 80); // Expiration: 80 days from planting

        // Add crops to CropManager
        cropManager.addCrop(crop1);
        cropManager.addCrop(crop2);
        cropManager.addCrop(crop3);
        cropManager.addCrop(crop4);
        cropManager.addCrop(crop5);

        // Display the list of crops
        cropManager.displayCrops();
    }
}

