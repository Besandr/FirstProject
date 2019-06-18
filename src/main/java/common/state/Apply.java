package common.state;

import java.util.Arrays;
import java.util.HashMap;

public class Apply {

    private HashMap<States, State> applyStates;

    State state;

    public Apply(){

        applyStates = new HashMap<>();
        StateFactory factory = new StateFactory(this);

        Arrays.stream(States.values()).forEach(s -> applyStates.put(s, factory.getState(s)));

        state = applyStates.get(States.CREATED);
    }

    void changeState(States newState) {
        state = applyStates.get(newState);
    }

    void forward(){
        state.forward();
    }

    boolean checkComplianceWithRequirements(){
        return tossACoin();
    }

    boolean isApplyModified(){
        return tossACoin();
    }

    boolean tossACoin(){
        return Math.random() > 0.5;
    }

    State getState(){
        return state;
    }

}
