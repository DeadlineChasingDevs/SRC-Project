import java.util.ArrayList;
import java.util.List;

public class CropManager {
    private List<Crop> crops;

    public CropManager() {
        this.crops = new ArrayList<>();
    }

    public List<Crop> getCrops() {
        return crops;
    }

    public void addCrop(Crop crop) {
        crops.add(crop);
    }
}

