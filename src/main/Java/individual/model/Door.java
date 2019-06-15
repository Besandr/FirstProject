package individual.model;

public class Door {

    private boolean isOpened;
    private boolean isLocked;

    public boolean isOpened() {
        return isOpened;
    }

//    public boolean setOpened() {
//        if (isLocked) {
//            return false;
//        } else {
//            isOpened = true;
//            return true;
//        }
//    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public void setClosed(){
        isOpened = false;
    }

    public boolean isLocked() {
        return isLocked;
    }

/*    public boolean setLocked() {
        if (isOpened) {
            return false;
        } else {
            isLocked = true;
            return true;
        }
    }*/

    public void setLocked(boolean locked){
        isLocked = locked;
    }

    public void setUnlocked(){
        isLocked = false;
    }


}
