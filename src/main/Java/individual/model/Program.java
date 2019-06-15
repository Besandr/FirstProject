package individual.model;

public class Program {

    public final boolean NEED_PRE_WASHING;
    public final int PRE_WASHING_TEMP = 30;
    public final RotatingType PRE_WASHING_ROTATING = RotatingType.SLOW;
    public final int PRE_WASHING_TIME = 3000;


    public final int WASHING_TEMPERATURE;
    public final RotatingType WASHING_ROTATING_TYPE;
    public final int WASHING_TIME = 6000;

    public final RotatingType SPINNING_ROTATING_TYPE;
    public final int SPINNING_TIME = 3000;


    public Program(boolean needPreWashing, int washingTemperature, RotatingType washingRotatingType, RotatingType spinningRotatingType) {
        this.NEED_PRE_WASHING = needPreWashing;
        this.WASHING_TEMPERATURE = washingTemperature;
        this.WASHING_ROTATING_TYPE = washingRotatingType;
        this.SPINNING_ROTATING_TYPE = spinningRotatingType;


    }



}
