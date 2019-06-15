package individual.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoorTest {

    private Door door;

    @Before
    public void setUp(){
        door = new Door();
    }

    @Test
    public void setDoorOpenShouldReturnTrueUnlockedDoor(){
        assertTrue(door.setOpened());
    }

    @Test
    public void setDoorOpenShouldReturnFalseWithLockedDoor(){
        door.setLocked();
        assertFalse(door.setOpened());
    }

    @Test
    public void setDoorLockedShouldReturnTrueClosedDoor(){
        assertTrue(door.setLocked());
    }

    @Test
    public void setDoorLockedShouldReturnFalseWithOpenedDoor(){
        door.setOpened();
        assertFalse(door.setLocked());
    }

}