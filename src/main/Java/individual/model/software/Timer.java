package individual.model.software;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Timer {

    private PropertyChangeSupport propertyChangeSupport;

    private int targetTime;
    private int spentTime;
    private Thread timerThread;

    public Timer(int timeAmount) {
        this.targetTime = timeAmount;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeSupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeSupport.removePropertyChangeListener(pcl);
    }

    public void runTimer(){

        timerThread = new Thread(() -> {
            while (targetTime - spentTime > 0) {

                try{

                    Thread.sleep(100);
                    spentTime += 100;

                    propertyChangeSupport.firePropertyChange("timer", targetTime - spentTime + 100, targetTime - spentTime);

                } catch (InterruptedException e) {
                    return;
                }
            }
        });

        timerThread.start();

    }

    public void stopTimer(){
        timerThread.interrupt();
    }
}
