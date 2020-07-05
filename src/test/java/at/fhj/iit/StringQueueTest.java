package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class StringQueueTest {
   /**
    * The maximum size used for the queue
    */
   private static int maxSize = 5;

   /**
    * Keep track of the current test-run. Intended for future use.
    */
   private static int testnmr = 1;

   private StringQueue queue;

   @BeforeEach
   public void setup() {
      // SETUP PHASE
      System.out.println("Start test " + testnmr);
      queue = new StringQueue(maxSize);
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
      queue.offer("newstring1");
      assertEquals(queue.poll(), "newstring1");
      queue.offer("newstring2");
      queue.offer("newstring3");
      assertEquals(queue.poll(), "newstring2");
      assertEquals(queue.poll(), "newstring3");
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
    * Checks if the peek() method works as intended by checking if ... - null gets
    * returned when called on an empty queue - elements can be returned multiple
    * times
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
      queue.offer("newstring1");
      assertEquals(queue.element(), "newstring1");
      assertEquals(queue.element(), "newstring1");
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
         assertTrue(queue.offer("newstring"));
      }
      assertFalse(queue.offer("newstring"));
      assertFalse(queue.offer("newstring"));
      queue.remove();
      assertTrue(queue.offer("newstring"));
   }
}