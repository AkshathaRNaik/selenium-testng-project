package com.project.JavaPrograms;

public class PatternPrograms {
    public static void main(String[] args) {
//        rightTriangleAsc(5);
//        rightTriangleDesc(5);
//        pyramidPattern(5);
//        invertedPyramidPattern(5);
//        diamondPattern(5);
//        numberPattern(5);
        floydsTriangle(5);
    }

    public static void rightTriangleAsc(int n) {
        for (int i = 1; i <= n; i++) {             //no of rows/lines
            for (int j = 1; j <= i; j++) {          //printing stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void rightTriangleDesc(int n) {
        for (int i = n; i >= 1; i--) {             //no of rows/lines
            for (int j = 1; j <= i; j++) {          //printing stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pyramidPattern(int n) {
        for (int i = 1; i <= n; i++) {             //no of rows/lines
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");             //printing space
            }
            for (int k = 1; k <= i; k++) {          //printing stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void invertedPyramidPattern(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");             //printing space
            }
            for (int k = 1; k <= i; k++) {          //printing stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void diamondPattern(int n) {
        pyramidPattern(n);
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");             //printing space
            }
            for (int k = 1; k <= i; k++) {          //printing stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void numberPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void floydsTriangle(int n) {
        int num =1;
        for (int i = 1; i <= n; i++) {
            for(int j=1 ; j<=i ; j++){
                System.out.print(num +"  ");
                num++;
            }
            System.out.println();
        }
    }

}
