package individual.model;

public class Motor {

    int currentMotorSpeed;
    boolean isMotorOn;

    public int getCurrentMotorSpeed() {
        return currentMotorSpeed;
    }

    public void setCurrentMotorSpeed(RotatingType type) {
        currentMotorSpeed = type.getMotorSpeed();
    }

    public boolean isMotorOn() {
        return isMotorOn;
    }

    public void setIsMotorOn(boolean motorOn) {
        isMotorOn = motorOn;
    }
}
