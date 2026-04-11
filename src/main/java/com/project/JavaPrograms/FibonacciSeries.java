package com.project.JavaPrograms;

public class FibonacciSeries {

    static void main() {
        fibonacciSeries(10);  // 0 1 1 2 3 5 8 13 21 34
    }

    public static void fibonacciSeries(int count) {
        int n1 = 0, n2 = 1 ;
        for (int i = 2; i <= count; i++) {
            System.out.print(n1 + " ");  //0 1 1 2 3
            int sum = n1 + n2;  //1 2 3 5 8
            n1 = n2;    //1 1 2 3
            n2 = sum;   //1 2 3 5
        }
        System.out.print(n1);
    }
}
