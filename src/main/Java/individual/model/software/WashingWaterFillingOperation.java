package individual.model.software;

import individual.model.DetergentDrawer;

public class WashingWaterFillingOperation extends DrumWaterFillingOperation {

    WashingWaterFillingOperation(MicroOS microOs) {
        super(microOs);
    }

    @Override
    protected void setDetergentAsUsed() {
        machine.getDetergentDrawer().useDetergent(DetergentDrawer.DetergentType.MAIN_WASH);
    }

    @Override
    protected void closeWaterFeedValve() {
        microOs.getMicroprocessor().openWashingWaterFeedValve();
    }

    @Override
    protected void openWaterFeedValve() {
        microOs.getMicroprocessor().closeWashingWaterFeedValve();
    }
}
