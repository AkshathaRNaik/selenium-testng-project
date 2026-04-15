package com.project.JavaPrograms;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateInArray {
    static void main() {
        int[] a= {1,2,3,2,4};
        firstDuplicateInArray(a);
    }
    static void firstDuplicateInArray(int[] arr){
        Set<Integer> set = new HashSet();
        boolean flag = false;
        for(int a : arr) {
            if(!set.add(a)){
                System.out.println("first duplicate number in array : " + a);
                flag = true;
                break;
            }
        }
        if(flag==false){
            System.out.println("No duplicate numbers found in an array");
        }
    }
}
