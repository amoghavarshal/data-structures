package com.amogha.general;

public class StringToInteger {
	public static void main(String[] args) {
		System.out.println("-88297 248252140B12 37 --> "
				+ convertStrToInteger("-88297 248252140B12 37"));
		System.out.println("75 6 --> " + convertStrToInteger("75 6"));
		System.out.println("+349A756 --> " + convertStrToInteger("+349A756"));
	}

	private static int convertStrToInteger(String str) {
		if (str == null || str.length() == 0)
			return 0;

		int value = 0;
		int startIndex = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0;

		for (int i = startIndex; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				value = value * 10 + (str.charAt(i) - '0');
			} else {
				break;
			}
		}

		if (isNegative(str))
			value = -value;
		return value;
	}

	private static boolean isNegative(String str) {
		return str.charAt(0) == '-';
	}
}
