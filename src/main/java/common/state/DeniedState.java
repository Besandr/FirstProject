package common.state;

public class DeniedState implements State {

    private Apply apply;

    DeniedState(Apply apply) {
        this.apply = apply;
    }

    @Override
    public void forward() {
        System.out.println("The apply is denied and can't be forwarded. Good luck next time!");
    }
}
