package com.amogha.array;

import java.util.Arrays;

public class WaveArray {
	public static void main(String[] args) {
		int[] waveArray1 = createWaveArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int[] waveArray2 = createWaveArray(1, 3, 6, 3, 7, 8, 9, 3, 4, 7, 2, 4);
		System.out.println("waveArray1 --> "+ Arrays.toString(waveArray1));
		System.out.println("waveArray2 --> "+ Arrays.toString(waveArray2));
	}

	private static int[] createWaveArray(int... arr) {
		Arrays.sort(arr);
		int[] waveArr = new int[arr.length];
		waveArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int val = arr[i];
			int nextIndex = findIndexOfNextGreaterElem(arr, val, i + 1);
			if (nextIndex == -1) {
				waveArr[i] = arr[i];
			} else {
				waveArr[i] = arr[nextIndex];
				waveArr[++i] = val;
			}
		}
		return waveArr;
	}

	private static int findIndexOfNextGreaterElem(int[] arr, int val, int start) {
		int index = -1;
		for (int i = start; i < arr.length; i++) {
			if (arr[i] > val) {
				index = i;
				break;
			}
		}
		return index;
	}
}
