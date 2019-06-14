package common.state;

public class UnderConsiderationState implements State {

    private Apply apply;

    UnderConsiderationState(Apply apply) {
        this.apply = apply;
    }

    @Override
    public void forward() {

        if (apply.checkComplianceWithRequirements()) {

            System.out.println("Congratulation! Apply is in compliance with requirements and forwarded to further approval");
            apply.changeState(States.POSTPONED);

        } else {

            System.out.println("Unfortunately the apply is not in compliance with requirements and will be denied.");
            apply.changeState(States.DENIED);

        }
    }
}
