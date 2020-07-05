package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class GenericQueueIntTest {
    /**
     * The maximum size used for the queue
     */
    private static int maxSize = 5;

    /**
     * Keep track of the current test-run. Intended for future use.
     */
    private static int testnmr = 1;

    private GenericQueue<Integer> queue;

    @BeforeEach
    public void setup() {
        // SETUP PHASE
        System.out.println("Start test " + testnmr);
        queue = new GenericQueue<>(maxSize);
    }

    @AfterEach
    public void end() {
        // END TEST PHASE
        System.out.println("End test " + testnmr);
        testnmr++;
    }

    /**
     * Checks if adding (offering) and removing (polling) elements from the queue
     * succeeds by checking if ... - elements get added - null gets returned when
     * the queue is empty - elements can be returned multiple times
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
     * Checks if using the remove() method succeeds by checking if ... - an
     * exception gets thrown when called on an empty queue - elements can only be
     * returned once - elements are returned in the correct order
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
     * Checks if the peek() method works as intended by checking if ... - null gets
     * returned when called on an empty queue - elements can be returned multiple
     * times
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
     * Checks if the element() method works as intended by checking if ... - an
     * exception gets thrown when called on an empty queue - elements can be
     * returned multiple times
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

    /**
     * Checks if the queue respects the maximum size it is assigned by checking if
     * adding more elements than maxSize fails
     */
    @Test
    @DisplayName("Test maxSize functionality")
    public void testMaxSize() {
        for (int i = 0; i < maxSize; i++) {
            assertTrue(queue.offer(1));
        }
        assertFalse(queue.offer(1));
        assertFalse(queue.offer(1));
        queue.remove();
        assertTrue(queue.offer(1));
    }
}