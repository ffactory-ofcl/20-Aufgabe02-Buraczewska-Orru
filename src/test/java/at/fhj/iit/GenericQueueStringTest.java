package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class GenericQueueStringTest {
    /**
     * Keep track of the current test-run. Intended for future use.
     */
    private static int testnmr = 1;
    private GenericQueue<String> queue;

    @BeforeEach
    public void setup() {
        // SETUP PHASE
        System.out.println("Start test " + testnmr);
        queue = new GenericQueue<String>(10);
    }

    @AfterEach
    public void end() {
        // END TEST PHASE
        System.out.println("End test " + testnmr);
        testnmr++;
    }

    /**
     * Checks if adding (offering) and removing (polling) elements from the queue
     * succeeds
     */
    @Test
    @DisplayName("Test adding and polling elements")
    public void testAddAndRemove() {
        assertEquals(queue.poll(), null);
        queue.offer("newstring1");
        assertEquals(queue.poll(), "newstring1");
        queue.offer("newstring2");
        queue.offer("newstring3");
        assertEquals(queue.poll(), "newstring2");
        assertEquals(queue.poll(), "newstring3");
    }

    /**
     * Checks if using the remove() method succeeds
     */
    @Test
    @DisplayName("Test adding and removing elements")
    public void testRemove() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
        });
        queue.offer("newstring1");
        assertEquals(queue.remove(), "newstring1");
        queue.offer("newstring2");
        queue.offer("newstring3");
        assertEquals(queue.remove(), "newstring2");
        assertEquals(queue.remove(), "newstring3");
        assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
        });
    }

    /**
     * Checks if the peek() method works as intended
     */
    @Test
    @DisplayName("Test peeking queue")
    public void testPeek() {
        assertEquals(queue.peek(), null);
        queue.offer("newstring1");
        assertEquals(queue.peek(), "newstring1");
        assertEquals(queue.peek(), "newstring1");
    }

    /**
     * Checks if the element() method works as intended
     */
    @Test
    @DisplayName("Test element peek")
    public void testElement() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.element();
        });
        queue.offer("newstring1");
        assertEquals(queue.element(), "newstring1");
        assertEquals(queue.element(), "newstring1");
        queue.remove();
        assertThrows(NoSuchElementException.class, () -> {
            queue.element();
        });
    }
}