package com.project.JavaPrograms;

public class Palindrome {
    static void main() {
        palindromeCheck("madam");
        palindromeCheck("akshu");
    }

    static void palindromeCheck(String str) {
        String output = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            output = output + str.charAt(i);
        }
        if (str.equals(output)) {

            System.out.println("Palindrome String");
        } else {
            System.out.println("Not a palindrome string");
        }
    }
}
