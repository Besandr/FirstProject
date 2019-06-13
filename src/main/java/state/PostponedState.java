package state;

import state.State;

public class PostponedState implements State {

    private Apply apply;

    PostponedState(Apply apply) {
        this.apply = apply;
    }

    @Override
    public void forward() {
        if (isThereLackOfFunds()) {
            System.out.println("Unfortunately there is lack of funds now. The apply will be postponed for a while");
        } else {
            System.out.println("Congratulation! Apply is approved now");
            apply.changeState(States.APPROVED);
        }
    }

    // toss a coin ... again
    private boolean isThereLackOfFunds(){
        return apply.tossACoin();
    }
}
