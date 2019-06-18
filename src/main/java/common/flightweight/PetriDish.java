package common.flightweight;

public class PetriDish {

    private Bacterium bacterium;
    private long colonyPopulation;
    private int temperature;
    private int timeInMillis;

    PetriDish() {
        temperature = 30;
    }

    public PetriDish(int temperature) {

        this.temperature = temperature;
    }

    void put(Bacterium bacterium) {
        this.bacterium = bacterium;
        colonyPopulation = 1;
    }

    void breed(int timeInMillis) {

        int breedingRate = bacterium.getBreedingRate();
        for (int i = 0; i < timeInMillis / 1000; i++) {
            for (int j = 0; j < 1000; j += breedingRate) {
                colonyPopulation *= 2;
            }


            try{
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
        }
    }

    long getColonyPopulation(){
        return colonyPopulation;
    }

    int getTemperature() {
        return temperature;
    }
}
