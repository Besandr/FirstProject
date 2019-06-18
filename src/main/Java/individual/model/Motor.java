package individual.model;

public class Motor {

    private int currentMotorSpeed;
    private boolean isMotorOn;

    public int getCurrentMotorSpeed() {
        return currentMotorSpeed;
    }

    void setCurrentMotorSpeed(RotationType type) {
        currentMotorSpeed = type.motorSpeed;
    }

    public boolean isMotorOn() {
        return isMotorOn;
    }

    public void setIsMotorOn(boolean motorOn) {
        isMotorOn = motorOn;
    }
}
