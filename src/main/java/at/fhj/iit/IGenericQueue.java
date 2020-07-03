package at.fhj.iit;

public interface IGenericQueue<T> {
    /**
     * Adds the element obj to the queue.
     *
     * @param obj To be added to the queue
     * @return whether the action was successful
     */
    public abstract boolean offer(T obj);

    /**
     * Returns the head (first) element and also deletes it. That is, we cannot get
     * it again. If no element exists (when queue is empty), the method returns
     * null.
     *
     * @return the head (first) element and also deletes it. If the queue is empty,
     *         returns null.
     */
    public abstract T poll();

    /**
     * It also returns and deletes the head element like poll(), but with a small
     * difference. This method throws NoSuchElementException if the queue is empty.
     *
     * @return the head (first) element
     * @throws NoSuchElementException if the queue is empty
     */
    public abstract T remove();

    /**
     * Returns the head element but it does not delete it. That is, we can get it
     * again. Returns null when the queue is empty.
     *
     * @return the head (first) element but does not delete it. If the queue is
     *         empty, returns null
     */
    public abstract T peek();

    /**
     * It works similar to peek() but with a small difference (returns but does not
     * delete the element). It throws NoSuchElementException when the queue is
     * empty.
     *
     * @return the head (first) element but does not delete it
     * @throws NoSuchElementException if the queue is empty
     */
    public abstract T element();
}
