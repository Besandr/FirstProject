package individual.model.software;

import individual.model.DetergentDrawer;

public class PreWashingWaterFillingOperation extends DrumWaterFillingOperation {

    PreWashingWaterFillingOperation(MicroOS microOs) {
        super(microOs);
    }

    @Override
    protected void setDetergentAsUsed() {
        machine.getDetergentDrawer().useDetergent(DetergentDrawer.DetergentType.PRE_WASH);
    }

    @Override
    protected void closeWaterFeedValve() {
        microOs.getMicroprocessor().closePreWashingWaterFeedValve();
    }

    @Override
    protected void openWaterFeedValve() {
        microOs.getMicroprocessor().openPreWashingWaterFeedValve();
    }
}
