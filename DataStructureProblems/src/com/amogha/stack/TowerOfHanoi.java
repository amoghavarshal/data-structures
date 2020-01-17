package com.amogha.stack;

import java.util.Stack;

public class TowerOfHanoi {
	
	static int totalMoves = 0;
	
	public static void main(String[] args) {
		Stack<Integer> source = initStack();
		Stack<Integer> temp = new Stack<>();
		Stack<Integer> dest = new Stack<>();
		System.out.println("dest before move::> "+ dest);
		move(source.size(), source, temp, dest);
		System.out.println("dest after move::> "+ dest);
		System.out.println("total moves::> "+ totalMoves);
	}
	
	private static void move(int n, Stack<Integer> source,
			Stack<Integer> temp, Stack<Integer> dest) {
		if (n == 1) {
			totalMoves++;
			dest.push(source.pop());
		} else {
			move(n-1, source, dest, temp);
			dest.push(source.pop());
			totalMoves++;
			move(n-1, temp, source, dest);
		}
	}

	private static Stack<Integer> initStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		return stack;
	}

}
