import java.util.List;

public class CropManager {
    private List<Crop> crops;

    public CropManager() {
        this(new ArrayList<>());
    }

    public CropManager(List<Crop> crops) {
        this.crops = crops;
    }

    public void addCrop(Crop crop) {
        crops.add(crop);
    }
    
    public void displayCrops() {
        System.out.println("Crop List:");

        for (Crop crop : crops) {
            System.out.println(crop);
        }
    }
}