package com.amogha.stack;

import java.util.NoSuchElementException;

public interface Stack<T> {

	void push(T item);

	T pop() throws NoSuchElementException;

	T peek() throws NoSuchElementException;

	int size();

	boolean isEmpty();
}
