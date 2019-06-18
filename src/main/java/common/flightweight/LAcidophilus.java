package common.flightweight;

public class LAcidophilus extends Bacterium {

    private final int breedingRate;


    LAcidophilus() {
        breedingRate = 90;
    }

    @Override
    public int getBreedingRate() {
        return breedingRate;
    }
}
