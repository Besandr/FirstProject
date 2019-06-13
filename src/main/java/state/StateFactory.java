package state;

public class StateFactory {

    private Apply apply;

    StateFactory(Apply apply) {
        this.apply = apply;
    }

    public State getState(States stateType){
        switch (stateType) {
            case CREATED:
                return new CreatedState(apply);
            case UNDER_CONSIDERING:
                return new UnderConsiderationState(apply);
            case POSTPONED:
                return new PostponedState(apply);
            case APPROVED:
                return new ApprovedState(apply);
            case DENIED:
                return new DeniedState(apply);
            case WITHDRAWN:
                return new WithdrawnState(apply);
            default:
                throw  new IllegalArgumentException("There's an unknown state");
        }
    }
}
