package com.project.JavaPrograms;

import java.util.Arrays;

public class SecondLargestNumberInArray {
    public static void main(String[] args) {
        SecondLargestNumberInArray(new int[]{10, 20, 5, 8, 25});
    }
    static void SecondLargestNumberInArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("second largest number in array : " + arr[1]);
    }
}