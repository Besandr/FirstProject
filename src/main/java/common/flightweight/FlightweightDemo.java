package common.flightweight;

public class FlightweightDemo {
    public static void main(String[] args) {
        new FlightweightDemo().go();
    }

    public void go(){

        ReportsFactory reportsFactory = new ReportsFactory();

        System.out.println("Start reporting:");

        Report bifidoReport = reportsFactory.getReport(BacteriumType.BIFIDOBACTERRIUM);
        System.out.println(bifidoReport);
        System.out.println("========");

        Report lAcidofilusReport = reportsFactory.getReport(BacteriumType.L_ACIDOPHILUS);
        System.out.println(lAcidofilusReport);
        System.out.println("========");

        Report sThermophilis = reportsFactory.getReport(BacteriumType.S_THERMOPHILUS);
        System.out.println(sThermophilis);
        System.out.println("========");

        Report newBifidoReport = reportsFactory.getReport(BacteriumType.BIFIDOBACTERRIUM);
        System.out.println(newBifidoReport);
    }
}
