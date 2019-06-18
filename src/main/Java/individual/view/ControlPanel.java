package individual.view;

import individual.controller.UserActionsHandler;
import individual.model.software.MicroOS;
import individual.model.software.Timer;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ControlPanel implements PropertyChangeListener {

    private MicroOS microOS;
    private Indicator indicator;
    private Timer timer;

    private ButtonPanel buttonPanel;
    private UserActions userActions;

    private JFrame panelWindow;

    public ControlPanel(MicroOS microOS){

        this.microOS = microOS;
        microOS.addPropertyChangeListener(this);

        userActions = new UserActions(new UserActionsHandler(microOS));

        panelWindow = new JFrame();
        buttonPanel = new ButtonPanel(this);

        indicator = new Indicator();
    }

    public void showInterface() {

        panelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setModeLabelText();

        panelWindow.getContentPane().add(BorderLayout.SOUTH, buttonPanel.getButtonsJPanel());
        panelWindow.getContentPane().add(BorderLayout.CENTER, indicator.getIndicatorPanel());
        panelWindow.getContentPane().add(BorderLayout.WEST, userActions.getActionsPanel());

        panelWindow.setSize(450, 450);

        panelWindow.setVisible(true);

    }

    void setModeLabelText() {

        indicator.getModeLabel().setText(getNextProgram());
    }

    private void setTimerLabelText(String text) {

        indicator.getTimerLabel().setText(text);
    }

    private void setOperationLabelText(String text) {
        indicator.getCurrentOperationLabel().setText(text);
    }

    private String getNextProgram(){
        return microOS.setNextProgram();
    }

    void startWashing(){

        if (microOS.prepareWashing()) {

            indicator.getCurrentOperationLabel().setVisible(true);

            startTiming();

            buttonPanel.getModeButton().setEnabled(false);
            buttonPanel.getStartButton().setEnabled(false);
            buttonPanel.getStopButton().setEnabled(true);

            microOS.startWashing();

        }
    }

    private void startTiming(){

        timer = new Timer(microOS.getProgramTime());

        timer.addPropertyChangeListener(this);

        timer.runTimer();

        indicator.getTimerLabel().setVisible(true);

    }

    private void prepareStopWashing(){

        indicator.getTimerLabel().setVisible(false);
        indicator.getCurrentOperationLabel().setVisible(false);
        timer.stopTimer();

        buttonPanel.getModeButton().setEnabled(true);
        buttonPanel.getStartButton().setEnabled(true);
        buttonPanel.getStopButton().setEnabled(false);

        userActions.updateButtonsStatus();
    }

    void stopWashing(){

        prepareStopWashing();

        microOS.cancelWashing();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();
        switch (propertyName) {
            case "operation":
                setOperationLabelText((String) evt.getNewValue());
                break;
            case "timer":
                int timerTime =(Integer) evt.getNewValue();
                String timerText = String.format("%d : %03d", timerTime / 1000, timerTime % 1000);
                setTimerLabelText(timerText);
                break;
            case "complete":
                prepareStopWashing();
                break;
        }
    }
}
