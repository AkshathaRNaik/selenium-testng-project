package com.project.JavaPrograms;

public class VowelsConsonants {
    static void main() {
        vowelsConsonants("aeiouxyz");
        vowelsConsonantsAlt("aeiouxyz");
    }

    static void vowelsConsonants(String str) {
        int vowels = 0;
        int consonants = 0;
        String vowelsstr = "aeiou";
        for (char ch : str.toCharArray()) {
            if (vowelsstr.indexOf(ch) != -1) {
                vowels++;
            } else {
                consonants++;
            }
        }
        System.out.println(" vowels count : " + vowels);
        System.out.println(" consonants count : " + consonants);
    }

    static void vowelsConsonantsAlt(String str) {
        int vowels = 0;
        int consonants = 0;
        for (char ch : str.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        System.out.println(" vowels count : " + vowels);
        System.out.println(" consonants count : " + consonants);
    }
}
