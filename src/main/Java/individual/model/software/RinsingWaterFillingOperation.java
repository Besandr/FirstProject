package individual.model.software;

import individual.model.DetergentDrawer;

public class RinsingWaterFillingOperation extends DrumWaterFillingOperation {

    RinsingWaterFillingOperation(MicroOS microOs ) {
        super(microOs);
    }

    @Override
    protected void setDetergentAsUsed() {
        machine.getDetergentDrawer().useDetergent(DetergentDrawer.DetergentType.SOFTENER);
    }

    @Override
    protected void closeWaterFeedValve() {
        microOs.getMicroprocessor().closeRinsingWaterFeedValve();
    }

    @Override
    protected void openWaterFeedValve() {
        microOs.getMicroprocessor().openRinsingWaterFeedValve();
    }
}
