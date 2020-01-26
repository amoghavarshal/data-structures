package com.amogha.stack;

import java.util.NoSuchElementException;

public class StackImpl<T> implements Stack<T>{
	
	private int top = -1;
	private int capacity = 10;
	private T[] array;
	
	public StackImpl() {
		this.array = (T[])new Object[capacity];
	}
	
	public StackImpl(int capacity) {
		this.capacity = capacity;
		this.array = (T[])new Object[capacity];
	}

	@Override
	public void push(T item) {
		if (top == capacity) {
			throw new IllegalStateException("Cannot add, Stack is full");
		}
		array[++top] = item;
	}

	@Override
	public T pop() throws NoSuchElementException {
		if (top == -1)
			throw new NoSuchElementException("Stack is Empty");
		return array[top--];
	}

	@Override
	public T peek() throws NoSuchElementException {
		if (top == -1)
			throw new NoSuchElementException("Stack is Empty");
		return array[top];
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}
	
	public static void main(String[] args) {
		StackImpl<Integer> stack = new StackImpl<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
