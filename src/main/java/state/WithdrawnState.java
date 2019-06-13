package state;


public class WithdrawnState implements State {

    private Apply apply;

    WithdrawnState(Apply apply) {
        this.apply = apply;
    }

    @Override
    public void forward() {
        if (apply.isApplyModified()) {
            System.out.println("Apply is successfully modified after withdrawing and ready for forward to consideration");
            apply.changeState(States.CREATED);
        } else {
            System.out.println("Apply still need to be modified for further forwarding");
        }
    }
}
