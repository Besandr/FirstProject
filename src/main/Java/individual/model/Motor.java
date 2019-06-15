package individual.model;

public class Motor {

    public enum RotatingType {
        SLOW(20), NORMAL(60), DRYING(800);

        private int motorSpeed;

        RotatingType(int motorSpeed) {
            this.motorSpeed = motorSpeed;
        }

        public int getMotorSpeed() {
            return motorSpeed;
        }
    }

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
