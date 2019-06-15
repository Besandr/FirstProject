package individual.model;

public enum RotatingType {
    STOP(0), SLOW(20), NORMAL(60), LOW_SPINNING(100), MIDDLE_SPINNING(400), HIGH_SPINNING(800);

    private int motorSpeed;

    RotatingType(int motorSpeed) {
        this.motorSpeed = motorSpeed;
    }

    public int getMotorSpeed() {
        return motorSpeed;
    }
}
