package com.project.JavaPrograms;

public class CharactersDigits {

    static void main() {
        charDigit("A23CD567GFI");
    }

    static void charDigit(String str) {
        char[] ch = str.toCharArray();
        String characters = "";
        String digits = "";
        for (char c : ch) {
            if (Character.isDigit(c)) {
                digits = digits + c;

            } else {
                characters = characters + c;
            }
        }
        System.out.println("characters : " + characters);
        System.out.println("digits : " + digits);
    }
}
