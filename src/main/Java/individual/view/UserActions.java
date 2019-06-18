package individual.view;

import individual.controller.UserActionsHandler;
import individual.model.DetergentDrawer;

import javax.swing.*;

public class UserActions {

    private JPanel actionsPanel;
    private UserActionsHandler handler;

    private JButton doorButton;
    private JButton loadButton;
    private JButton preWashDetergentButton;
    private JButton washDetergentButton;
    private JButton softenerButton;

    UserActions(UserActionsHandler handler) {

        this.handler = handler;

        initOpenDoorButton();
        initLaundryLoadButton();
        initPreWashDetergentButton();
        initWashDetergentButton();
        initSoftenerButton();
        initActionsPanel();
    }

    private void initOpenDoorButton() {
        doorButton = new JButton("Open door");
        doorButton.addActionListener((event) -> {

            if (handler.isDoorOpened()) {

                handler.closeDoor();
                doorButton.setText("Open door");

            } else {

                if (handler.openDoor()) {
                    doorButton.setText("Close door");
                }

            }

        });
    }

    private void initLaundryLoadButton() {
        loadButton = new JButton("Load laundry");
        loadButton.addActionListener((event) -> {

            if (handler.isLaundryLoaded()) {

                if (handler.unloadLaundry()) {
                    loadButton.setText("Load laundry");
                }

            } else {

                if (handler.loadLaundry()) {
                    loadButton.setText("Unload laundry");
                }
            }
        });
    }

    private void initPreWashDetergentButton() {

        preWashDetergentButton = new JButton("Add pre-wash detergent");
        preWashDetergentButton.addActionListener((event) -> {
            handler.addDetergent(DetergentDrawer.DetergentType.PRE_WASH);
            preWashDetergentButton.setEnabled(false);
        });
    }

    private void initWashDetergentButton() {

        washDetergentButton = new JButton("Add wash detergent");
        washDetergentButton.addActionListener((event) -> {
            handler.addDetergent(DetergentDrawer.DetergentType.MAIN_WASH);
            washDetergentButton.setEnabled(false);
        });
    }

    private void initSoftenerButton() {

        softenerButton = new JButton("Add softener");
        softenerButton.addActionListener((event) -> {
            handler.addDetergent(DetergentDrawer.DetergentType.SOFTENER);
            softenerButton.setEnabled(false);
        });
    }

    private void initActionsPanel() {

        actionsPanel = new JPanel();

        actionsPanel.setLayout(new BoxLayout(actionsPanel, BoxLayout.Y_AXIS));
        actionsPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        actionsPanel.add(washDetergentButton);
        actionsPanel.add(softenerButton);
        actionsPanel.add(preWashDetergentButton);
        actionsPanel.add(loadButton);
        actionsPanel.add(doorButton);
    }

    void updateButtonsStatus(){

        if (!handler.isMachineHasDetergent(DetergentDrawer.DetergentType.PRE_WASH)) {
            preWashDetergentButton.setEnabled(true);
        }

        if (!handler.isMachineHasDetergent(DetergentDrawer.DetergentType.MAIN_WASH)) {
            washDetergentButton.setEnabled(true);
        }

        if (!handler.isMachineHasDetergent(DetergentDrawer.DetergentType.SOFTENER)) {
            softenerButton.setEnabled(true);
        }

        if (!handler.isLaundryLoaded()) {
            loadButton.setEnabled(true);
            loadButton.setText("Load laundry");
        }

    }

    JPanel getActionsPanel() {
        return actionsPanel;
    }
}
