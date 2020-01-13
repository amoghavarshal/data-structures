package com.amogha.stack;

import java.util.Stack;

public class SortStack {
	
	public static void main(String[] args) {
		Stack<Integer> stack = initStack();
		System.out.println("Before Sorting::> "+stack);
		sortStack(stack);
		System.out.println("After Sorting::> "+stack);
	}

	private static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		Integer x = stack.pop();
		sortStack(stack);
		insertSortElem(stack, x);
	}

	private static void insertSortElem(Stack<Integer> stack, Integer x) {
		if (stack.isEmpty()) {
			stack.push(x);
			return;
		}
		Integer i = stack.pop();
		insertSortElem(stack, x);
		if (i > x) {
			stack.push(i);
		} else {
			Integer y = stack.pop();
			stack.push(i);
			stack.push(y);
		}
	}

	private static Stack<Integer> initStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(1);
		stack.push(3);
		stack.push(6);
		stack.push(5);
		stack.push(2);
		return stack;
	}
}
