package com.project.JavaPrograms;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        anagramCheck("listen", "silent");
    }

    static void anagramCheck(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("Not an anagram");
        } else {
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();

            Arrays.sort(ch1);
            Arrays.sort(ch2);

            if (Arrays.equals(ch1, ch2)) {
                System.out.println("Given string is an anagram");
            } else {
                System.out.println("Given string is NOT an anagram");
            }
        }
    }
}
