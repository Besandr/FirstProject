package common.state;

public class ApprovedState implements State {

    private Apply apply;

    ApprovedState(Apply apply) {
        this.apply = apply;
    }

    @Override
    public void forward() {
        System.out.println("Your cash is on their way! Be patient.");
    }
}
