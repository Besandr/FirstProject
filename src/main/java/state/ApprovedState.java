package state;

import state.State;

public class ApprovedState implements State {

    private Apply apply;

    ApprovedState(Apply apply) {
        this.apply = apply;
    }

    @Override
    public void forward() {

    }
}
