package individual.view;

import javax.swing.*;
import java.awt.*;

class Indicator {

    private JPanel indicatorPanel;
    private JLabel modeLabel;
    private JLabel timerLabel;
    private JLabel currentOperationLabel;

    Indicator(){

        init();
    }

    private void init(){

        Font font = new Font("serif", Font.BOLD, 28);

        modeLabel = new JLabel("");
        modeLabel.setFont(font);
        timerLabel = new JLabel("");
        timerLabel.setFont(font);
        currentOperationLabel = new JLabel("");
        currentOperationLabel.setFont(font);

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
