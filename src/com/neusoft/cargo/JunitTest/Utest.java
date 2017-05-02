package com.neusoft.cargo.JunitTest;

import java.util.Random;

public class Utest {

	public static void main(String[] args) {

		Random random = new Random();
		float[] arr = new float[10000000];
		for (int i = 0; i < 10000000; i++) {
			arr[i] = random.nextFloat();
		}
		long startTime = System.nanoTime();

		String[] arra = new String[10000000];
		for (int i = 0; i < 10000000; i++) {
			arra[i] = arr[i] + "";
		}
		long endTime = System.nanoTime();
		System.out.println("''+float程序运行时间：" + (endTime - startTime) + "nm");
		long startTime1 = System.nanoTime();

		String[] arral = new String[10000000];
		for (int i = 0; i < 10000000; i++) {
			arral[i] = String.valueOf(arr[i]);
		}
		long endTimel = System.nanoTime();
		System.out.println("String.valueof(float)’ 程序运行时间：" + (endTimel - startTime1));

	}
}
