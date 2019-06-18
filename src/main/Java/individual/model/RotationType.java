package individual.model;

public enum RotationType {
    STOP(0), SLOW(20), NORMAL(60), LOW_SPINNING(100), MIDDLE_SPINNING(400), HIGH_SPINNING(800);

    public final int motorSpeed;

    RotationType(int motorSpeed) {
        this.motorSpeed = motorSpeed;
    }

}
