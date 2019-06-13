package state;

import org.junit.Test;

import static org.junit.Assert.*;

public class ApplyTest {

    @Test
    public void testChangeState() {

        Apply apply = new Apply();
        apply.changeState(States.WITHDRAWN);

        assertEquals(WithdrawnState.class, apply.getState().getClass());
    }
}