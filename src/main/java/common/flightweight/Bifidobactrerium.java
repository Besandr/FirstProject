package common.flightweight;

public class Bifidobactrerium extends Bacterium {

    private final int breedingRate;

    Bifidobactrerium() {
        breedingRate = 60;
    }

    @Override
    public int getBreedingRate() {
        return breedingRate;
    }
}
