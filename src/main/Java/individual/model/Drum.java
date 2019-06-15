package individual.model;

public class Drum {

    private boolean isLoaded;
    private boolean isWaterFilled;

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public boolean isWaterFilled() {
        return isWaterFilled;
    }

    public void setWaterFilled(boolean waterFilled) {
        isWaterFilled = waterFilled;
    }
}
