package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericQueue<T> implements IGenericQueue<T> {

    private List<T> elements = new ArrayList<T>();
    private int maxSize;

    public GenericQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean offer(T obj) {
        if (elements.size() < maxSize) {
            elements.add(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T poll() {
        if (elements.size() > 0) {
            T element = peek();
            elements.remove(0);
            return element;
        } else {
            return null;
        }
    }

    @Override
    public T remove() {
        T element = poll();
        if (element != null) {
            return element;
        } else {
            throw new NoSuchElementException("there's no element any more");
        }
    }

    @Override
    public T peek() {
        if (elements.size() > 0) {
            return elements.get(0);
        } else {
            return null;
        }
    }

    @Override
    public T element() {
        T element = peek();
        if (element != null) {
            return element;
        } else {
            throw new NoSuchElementException("there's no element any more");
        }
    }

}