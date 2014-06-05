package com.vinson;

public class TwentyFour {

	public static void main(String[] args) {
		new TwentyFour().run();
	}

	public void run() {
		float[] arr = new float[] { 4, 7, 8, 8 };
		String[] expres = new String[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			expres[i] = "" + arr[i];
		}
		calculate(arr, expres);
	}

	public void calculate(float arr[], String... expres) {
		// print(arr, expres);
		if (arr.length == 1) {
			if (arr[0] == 24) {
				System.out.println("====>" + expres[0] + "=" + arr[0]);
			}
			return;
		}

		float[] brr = new float[arr.length - 1];
		String[] bPres = new String[arr.length - 1];
		for (int k = 0; k < arr.length; ++k) {
			for (int i = k + 1; i < arr.length; ++i) {
				if (i == k) {
					continue;
				}
				int index = 1;
				for (int j = 0; j < arr.length; ++j) {
					if (i == j || j == k) {
						continue;
					}
					brr[index] = arr[j];
					bPres[index] = expres[j];
					++index;
				}

				brr[0] = arr[k] + arr[i];
				bPres[0] = "(" + expres[k] + "+" + expres[i] + ")";
				calculate(brr, bPres);

				brr[0] = arr[k] - arr[i];
				bPres[0] = "(" + expres[k] + "-" + expres[i] + ")";
				calculate(brr, bPres);

				brr[0] = arr[i] - arr[k];
				bPres[0] = "(" + expres[i] + "-" + expres[k] + ")";
				calculate(brr, bPres);

				brr[0] = arr[k] * arr[i];
				bPres[0] = "(" + expres[k] + "*" + expres[i] + ")";
				calculate(brr, bPres);

				if (arr[i] != 0) {
					brr[0] = arr[k] / arr[i];
					bPres[0] = "(" + expres[k] + "/" + expres[i] + ")";
					calculate(brr, bPres);
				}

				if (arr[k] != 0) {
					brr[0] = arr[i] / arr[k];
					bPres[0] = "(" + expres[i] + "/" + expres[k] + ")";
					calculate(brr, bPres);
				}
			}
		}
	}

	private void print(float arr[], String... expres) {
		StringBuilder sBuilder = new StringBuilder();
		for (float val : arr) {
			sBuilder.append(" " + val);
		}
		System.out.println(sBuilder.toString() + ", " + expres[0] + "="
				+ arr[0]);
	}
}
