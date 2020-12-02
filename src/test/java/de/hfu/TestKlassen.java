package de.hfu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestKlassen {

    private Queue queue, queue2, queue3;

    @Before
    public void init() {
        queue = new Queue(3);
        queue2 = new Queue(3);
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        queue2.enqueue(4);

        queue3 = new Queue(3);
        queue3.enqueue(1);
        queue3.enqueue(2);
        queue3.enqueue(3);
    }

    @Test
    public void istErstesHalbjahrTest() {
        assertTrue(Util.istErstesHalbjahr(6));
        assertFalse(Util.istErstesHalbjahr(11));
    }


    //Prüft, ob Dequeue nicht auf eine Leere Queue angewendet werden kann
    @Test
    public void isQueueEmtyTestRight() {
        try {
            queue.dequeue();
            fail();
        }catch (IllegalStateException illegalStateException) {
            System.out.println("Test geschaft");
        }

    }

    //Prüft, ob der lezte Eintrag in einer Queue überschrieben wird, wenn sie voll ist
    @Test
    public void isLastEntryOverwritten() {
        for(int i = 0; i < queue2.getLenght(); ++i){

            if(i == queue2.getLenght()-1) {
                assertEquals(4, queue2.dequeue());
            }
            else {
                queue2.dequeue();
            }
        }
    }

    //Prüft, ob bei Dequeue der erste eintrag gemmonen wird
    @Test
    public void isDequeRight() {
        assertEquals(1, queue3.dequeue());
    }

}
