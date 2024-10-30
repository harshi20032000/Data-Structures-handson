package com.indiavisualisedsa.ds_visualiser.models;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> elements = new ArrayList<>();

    public void push(T value) {
        elements.add(value);
    }

    public T pop() {
        if (!elements.isEmpty()) {
            return elements.remove(elements.size() - 1);
        }
        return null;
    }

    public List<T> getElements() {
        return elements;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
