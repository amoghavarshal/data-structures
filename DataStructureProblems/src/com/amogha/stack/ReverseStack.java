package com.amogha.stack;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> stack = initStack();
		System.out.println("Before reversing ::> "+stack);
		reverse(stack);
		System.out.println("After reversing ::> "+stack);
	}

	private static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int x = stack.pop();
		reverse(stack);
		insertItemsInReverse(x, stack);
	}

	private static void insertItemsInReverse(int x, Stack<Integer> stack) {
		if (stack.isEmpty()) {
			stack.push(x);
			return;
		}
		int i = stack.pop();
		insertItemsInReverse(x, stack);
		stack.push(i);
	}

	private static Stack<Integer> initStack() {
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		return stack;
	}
}
