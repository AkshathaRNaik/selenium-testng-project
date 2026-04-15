package com.project.JavaPrograms;

public class FindMissingNumberInArray {
    static void main() {
        int[] a = {1,2,3,4,5,7,9};
        int n = 9;
        findMissingNumberInArray(a, n);
    }

    static void findMissingNumberInArray(int[] ch, int maxNum) {
        int sum =maxNum*(maxNum+1)/2;
        int act = 0;
        for(int num : ch){
            act=act+num;
        }
        System.out.println("actual = " + act + " sum = " + sum);
        System.out.println("Missing number is : " + (sum-act));
    }
    static void findMissing(int[] arr, int n) {
        boolean[] present = new boolean[n + 1];
        // Mark present numbers
        for (int num : arr) {
            present[num] = true;
        }
        // Find missing numbers
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                System.out.println("Missing: " + i);
            }
        }
    }
}
