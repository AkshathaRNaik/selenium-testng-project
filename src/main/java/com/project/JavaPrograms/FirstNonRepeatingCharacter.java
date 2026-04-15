package com.project.JavaPrograms;

public class FirstNonRepeatingCharacter {
    static void main() {
        firstNonRepeatingCharacter("aabbcc");
    }

    //i/p:swiss , o/p :w , i/p : aabbcde , //o/p:c
    static void firstNonRepeatingCharacter(String str) {
        boolean flag = false;
        for (char ch : str.toCharArray()) {
            if (str.indexOf(ch) == str.lastIndexOf(ch)) { //s: 0==3
                System.out.println(ch + " this is the first non repeating character");
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("there are no non repeated characters in string");
        }

    }
}
