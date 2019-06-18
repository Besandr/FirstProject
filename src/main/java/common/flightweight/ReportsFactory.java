package common.flightweight;

import java.util.HashMap;

public class ReportsFactory {

    private HashMap<BacteriumType, Report> reports = new HashMap<>();

    public Report getReport(BacteriumType type){

        if (reports.containsKey(type)) {
            return reports.get(type);
        }

        return createReport(type);
    }

    Report createReport(BacteriumType type) {

        Bacterium bacterium;

        switch (type) {
            case L_ACIDOPHILUS:
                bacterium = new LAcidophilus();
                break;
            case S_THERMOPHILUS:
                bacterium = new SThermophilus();
                break;
            case BIFIDOBACTERRIUM:
                bacterium = new Bifidobactrerium();
                break;
            default:
                throw new IllegalArgumentException("Unknown type of bacterium");

        }


        PetriDish dish = new PetriDish();
        dish.put(bacterium);
        dish.breed(3000);
        long colonyPopulation = dish.getColonyPopulation();

        Report report = new Report(bacterium.getClass().getSimpleName(), 3000, dish.getTemperature(), colonyPopulation);
        reports.put(type, report);

        return report;
    }
}
