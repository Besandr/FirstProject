package individual.view;

import javax.swing.*;

public class ButtonPanel {

    private ControlPanel controlPanel;

    private JPanel buttonsPanel;
    private JButton modeButton;
    private JButton startButton;
    private JButton stopButton;

    ButtonPanel(ControlPanel controlPanel){

        this.controlPanel = controlPanel;

        initModeButton();
        initStartButton();
        initStopButton();
        initFrame();
    }

    private void initModeButton(){
        modeButton = new JButton("Mode");
        modeButton.addActionListener((event) -> controlPanel.setModeLabelText());
    }

    private void initStartButton() {
        startButton = new JButton("Start");
        startButton.addActionListener((event) -> controlPanel.startWashing());
    }

    private void initStopButton() {
        stopButton = new JButton("Stop");
        stopButton.addActionListener((event) -> controlPanel.stopWashing());
        stopButton.setEnabled(false);
    }

    private void initFrame() {
        buttonsPanel = new JPanel();
        buttonsPanel.add(modeButton);
        buttonsPanel.add(startButton);
        buttonsPanel.add(stopButton);
    }

    JPanel getButtonsJPanel() {
        return buttonsPanel;
    }

    public JButton getModeButton() {
        return modeButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }
}
