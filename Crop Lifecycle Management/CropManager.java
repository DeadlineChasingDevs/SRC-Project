import java.util.List;

public class CropManager {
    private List<Crop> crops;

    public CropManager(List<Crop> crops) {
        this.crops = crops;
    }

    public void displayCrops() {
        System.out.println("List of Crops:");
        for (Crop crop : crops) {
            System.out.println(crop);
        }
    }
}


