package com.project.JavaPrograms;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacterCount {
    static void main() {
//        duplicateCharacterCountHashmap("Akshatha Naik");
        duplicateCharacterCountSingleCharacter("aabbccaa", 'b');
    }

    static void duplicateCharacterCountHashmap(String str) {
        str = str.replace(" ", "");
        char[] ch = str.toLowerCase().toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap();
        for (char c : ch) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(hashMap);
//        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
//            if (entry.getValue() > 1) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//        }

        for(Character key : hashMap.keySet()){
            if(hashMap.get(key)>1){
                System.out.println(key + " " + hashMap.get(key));
            }
        }

    }

//    Find duplicate character count for single character, i/p: aabbccaa o/p :a4
    static void duplicateCharacterCountSingleCharacter(String str, char c){
        int count=0;
        for (int i=0; i<str.length(); i++){
            if(str.charAt(i)==c){
                count++;
            }
        }
        System.out.println(c +" "+ count);
    }
}
