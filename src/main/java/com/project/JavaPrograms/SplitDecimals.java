package com.project.JavaPrograms;

public class SplitDecimals {
    public static void main(String[] args) {
//        splitDecimal("100100.10100100");
        extractOnlyZeros(10101200);
    }

    public static void splitDecimal(String str){
        String[] arr = str.split("\\.");
        System.out.println("length of array : "+arr.length);
        System.out.println(arr[1]);
        System.out.println(arr[1].substring(0, 4));
    }

    public static void extractOnlyZeros(int i){
       String num=  String.valueOf(i);
       for (Character ch :num.toCharArray()){
           if(ch.equals('2')){
               System.out.print(ch);
           }
       }
    }
}
