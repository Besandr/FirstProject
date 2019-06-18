package individual.model;

import java.util.HashMap;

public class DetergentDrawer {

    public enum DetergentType {PRE_WASH, MAIN_WASH, SOFTENER}

    private HashMap<DetergentType, DetergentDrawerCompartment> compartments;

    DetergentDrawer() {
        compartments = new HashMap<>();
        compartments.put(DetergentType.PRE_WASH, new DetergentDrawerCompartment());
        compartments.put(DetergentType.MAIN_WASH, new DetergentDrawerCompartment());
        compartments.put(DetergentType.SOFTENER, new DetergentDrawerCompartment());
    }

    public void loadDetergent(DetergentType type) {
        compartments.get(type).setFilled(true);
    }

    public void useDetergent(DetergentType type) {
        compartments.get(type).setFilled(false);
    }

    public boolean hasDetergent(DetergentType type) {
        return compartments.get(type).isFilled();
    }
}
