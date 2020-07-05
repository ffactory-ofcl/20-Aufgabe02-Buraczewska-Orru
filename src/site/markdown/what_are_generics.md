# What are Generics?
## Introduction
Anyone reading this probably has come across the acronym "DRY". It stands for "do not repeat yourself" and means that duplicate code or general logic should be avoided wherever possible and instead, it should be preferred to place reusable logic in a shared entity (class, method etc.).

## What do generics have to do with this?
A generic function is one that can accept multiple types of the same parameter. Usually denoted by a T (for type), the given argument may be of any type that satisfies a given constraint.

## Example
The GenericQueue class in this project is an example of a generic implementation of a queue. Thus, it can be used to hold any type of object/data.

This is a simplified excerpt of that class.
```java
public class GenericQueue<T> {
    private List<T> elements = new ArrayList<T>();

    public GenericQueue() {}

    public boolean offer(T obj) {
        elements.add(obj);
    }

    // ...
}
```

As can be seen here, the queue is defined with a T in angle brackets (`< >`) that is reused in the `offer` method further down. This ensures that, when creating a queue with a type parameter (for example `String`), that same type will be required wherever it is used later in the code.

In this case, calling the `offer` method of a `GenericQueue<String>` (say: generic queue of string) requires a `String` to be passed as the first parameter (`T obj` becomes `String obj`).

Filippo Orru, 2020