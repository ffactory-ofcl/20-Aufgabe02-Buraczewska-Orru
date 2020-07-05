package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class GenericQueueIntTest {
    /**
     * Keep track of the current test-run. Intended for future use.
     */
    private static int testnmr = 1;

    private GenericQueue<Integer> queue;

    @BeforeEach
    public void setup() {
        // SETUP PHASE
        System.out.println("Start test " + testnmr);
        queue = new GenericQueue<>(10);
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
        queue.offer(1);
        assertEquals(queue.poll(), 1);
        queue.offer(2);
        queue.offer(3);
        assertEquals(queue.poll(), 2);
        assertEquals(queue.poll(), 3);
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
        queue.offer(1);
        assertEquals(queue.remove(), 1);
        queue.offer(2);
        queue.offer(3);
        assertEquals(queue.remove(), 2);
        assertEquals(queue.remove(), 3);
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
        queue.offer(1);
        assertEquals(queue.peek(), 1);
        assertEquals(queue.peek(), 1);
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
        queue.offer(1);
        assertEquals(queue.element(), 1);
        assertEquals(queue.element(), 1);
        queue.remove();
        assertThrows(NoSuchElementException.class, () -> {
            queue.element();
        });
    }
}