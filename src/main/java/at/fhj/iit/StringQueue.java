package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StringQueue implements IQueue {

  private List<String> elements = new ArrayList<String>();
  private int maxSize;

  public StringQueue(int maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public boolean offer(String obj) {
    if (elements.size() < maxSize) {
      elements.add(obj);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String poll() {
    if (elements.size() > 0) {
      String element = peek();
      elements.remove(0);
      return element;
    } else {
      return null;
    }
  }

  @Override
  public String remove() {
    String element = poll();
    if (element != null) {
      return element;
    } else {
      throw new NoSuchElementException("there's no element any more");
    }
  }

  @Override
  public String peek() {
    if (elements.size() > 0) {
      return elements.get(0);
    } else {
      return null;
    }
  }

  @Override
  public String element() {
    String element = peek();
    if (element != null) {
      return element;
    } else {
      throw new NoSuchElementException("there's no element any more");
    }
  }

}