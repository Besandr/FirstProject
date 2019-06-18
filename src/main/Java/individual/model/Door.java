package individual.model;

public class Door {

    private boolean isOpened;
    private boolean isLocked;

    boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public void setClosed(){
        isOpened = false;
    }

    public boolean isLocked() {
        return isLocked;
    }

    void setLocked(boolean locked){
        isLocked = locked;
    }

    public void setUnlocked(){
        isLocked = false;
    }


}
