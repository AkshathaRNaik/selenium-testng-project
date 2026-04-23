package com.project.JavaPrograms;

import java.util.HashMap;

public class CharacterCount {
    public static void main(String[] args) {
        characterCountHashmap("Akshatha Naik");
    }

    static void characterCountHashmap(String str) {
        str = str.replace(" ", "");
        char[] ch = str.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap();
        for (char c : ch) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            //method 2
//            if (hashMap.containsKey(c)) {
//                hashMap.put(c, hashMap.get(c) + 1);
//            } else {
//                hashMap.put(c, 1);
//            }
        }
        System.out.println(hashMap);
    }

}
