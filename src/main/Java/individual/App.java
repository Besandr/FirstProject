package individual;

import individual.model.WashingMachine;

public class App {

    public static void main(String[] args) {
        new App().go();
    }

    public void go() {

        WashingMachine machine = new WashingMachine();

        machine.plugIn();

    }
}
