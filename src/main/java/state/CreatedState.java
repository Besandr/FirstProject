package state;

public class CreatedState implements State {

    private Apply apply;

    CreatedState(Apply apply) {
        this.apply = apply;
    }

    @Override
    public void forward() {
        System.out.println("The apply is sent for consideration");
        apply.changeState(States.UNDER_CONSIDERING);
    }
}
