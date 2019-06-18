package individual.model.software;

import individual.model.RotationType;

public class Instruction implements Comparable<Instruction> {

    public enum TYPE {
        PRE_WASHING(1), WASHING(2), RINSING(3), SPINNING(4);

        public final int priority;

        TYPE(int priority) {
            this.priority = priority;
        }
    }

    public final TYPE currentType;
    public final boolean IS_ACTIVE;
    public final int WATER_TEMP;
    public final RotationType MOTOR_ROTATION_TYPE;
    public final int ROTATION_TIME;

    public Instruction(TYPE currentType, boolean IS_ACTIVE, int WATER_TEMP, RotationType MOTOR_ROTATION_TYPE, int ROTATION_TIME) {
        this.currentType = currentType;
        this.IS_ACTIVE = IS_ACTIVE;
        this.WATER_TEMP = WATER_TEMP;
        this.MOTOR_ROTATION_TYPE = MOTOR_ROTATION_TYPE;
        this.ROTATION_TIME = ROTATION_TIME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instruction that = (Instruction) o;

        if (IS_ACTIVE != that.IS_ACTIVE) return false;
        if (WATER_TEMP != that.WATER_TEMP) return false;
        if (ROTATION_TIME != that.ROTATION_TIME) return false;
        if (currentType != that.currentType) return false;
        return MOTOR_ROTATION_TYPE == that.MOTOR_ROTATION_TYPE;

    }

    @Override
    public int hashCode() {
        return currentType.priority;
    }

    @Override
    public int compareTo(Instruction o) {

        if (currentType.priority != o.currentType.priority) {
            return Integer.compare(currentType.priority, o.currentType.priority);
        }

        if (MOTOR_ROTATION_TYPE.motorSpeed != o.MOTOR_ROTATION_TYPE.motorSpeed) {
            return Integer.compare(MOTOR_ROTATION_TYPE.motorSpeed, o.MOTOR_ROTATION_TYPE.motorSpeed);
        }

        return Integer.compare(WATER_TEMP, o.WATER_TEMP) * 11 +
                Integer.compare(ROTATION_TIME, o.ROTATION_TIME) * 31;
    }
}
