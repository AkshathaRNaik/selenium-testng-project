package com.project.JavaPrograms;

public class ReverseAString {

    // using for loop
    public static void main(String[] args) {
//        reverse("Sagar");
//        reverseString("Akshatha");
        stringBuilder("Rupesh");
    }

    //using chararray
    static void reverse(String str) {
        char[] arr = str.toCharArray();
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
//            System.out.print(arr[i]);
            rev = rev + arr[i];
        }
        System.out.println(rev);
    }

    //using chatAt
    static void reverseString(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);
    }

    //Using StringBuilder
    static void stringBuilder(String str) {
        StringBuilder build = new StringBuilder(str);
        System.out.println(build.reverse());
    }
}
