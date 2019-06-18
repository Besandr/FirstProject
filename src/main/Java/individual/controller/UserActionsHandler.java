package individual.controller;

import individual.model.DetergentDrawer;
import individual.model.WashingMachine;
import individual.model.software.MicroOS;
import individual.view.UserActions;

public class UserActionsHandler {

    private MicroOS microOS;
    private WashingMachine machine;

    public UserActionsHandler(MicroOS microOS) {
        this.microOS = microOS;

        machine = microOS.getMicroprocessor().getMachine();
    }

    public void addDetergent(DetergentDrawer.DetergentType type){
       machine.getDetergentDrawer().loadDetergent(type);
    }

    public boolean isMachineHasDetergent(DetergentDrawer.DetergentType type) {
        return machine.getDetergentDrawer().hasDetergent(type);
    }

    public boolean isLaundryLoaded(){
        return machine.isLaundryLoaded();
    }

    public boolean loadLaundry(){
        return machine.loadLaundry();
    }

    public boolean unloadLaundry(){
        return machine.unloadLaundry();
    }

    public boolean isDoorOpened() {
        return machine.isDoorOpened();
    }

    public boolean openDoor(){
        return machine.openDoor();
    }

    public void closeDoor() {
        machine.closeDoor();
    }

}
