package common.flightweight;

public class SThermophilus extends Bacterium {

    private final int breedingRate;

    SThermophilus() {
        breedingRate = 120;
    }

    @Override
    public int getBreedingRate() {
        return breedingRate;
    }
}
