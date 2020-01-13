package com.amogha.recursion;

public class Recursion {
	final static int NUM = 5;

	public static void main(String[] args) {
		System.out.println("Head Recursion for ascending order");
		headRecusion(NUM);
		System.out.println("Tail Recursion for descending order");
		tailRecusion(NUM);
	}

	private static void headRecusion(int n) {
		if (n == 0) {
			return;
		}
		headRecusion(n - 1);
		System.out.println(n);
	}

	private static void tailRecusion(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		tailRecusion(n - 1);
	}

}
