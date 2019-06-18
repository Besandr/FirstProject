package individual.view;

import javax.swing.*;

class Indicator {

    private JPanel indicatorPanel;
    private JLabel modeLabel;
    private JLabel timerLabel;
    private JLabel currentOperationLabel;

    Indicator(){

        init();
    }

    private void init(){

        modeLabel = new JLabel("");
        timerLabel = new JLabel("");
        currentOperationLabel = new JLabel("");

        indicatorPanel = new JPanel();
        indicatorPanel.setLayout(new BoxLayout(indicatorPanel, BoxLayout.Y_AXIS));
        indicatorPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        indicatorPanel.add(modeLabel);
        indicatorPanel.add(timerLabel);
        indicatorPanel.add(currentOperationLabel);

        timerLabel.setVisible(false);
        currentOperationLabel.setVisible(false);
    }

    JPanel getIndicatorPanel() {
        return indicatorPanel;
    }

    JLabel getModeLabel() {
        return modeLabel;
    }

    JLabel getTimerLabel() {
        return timerLabel;
    }

    JLabel getCurrentOperationLabel() {
        return currentOperationLabel;
    }
}
