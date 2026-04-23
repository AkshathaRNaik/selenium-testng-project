package com.project.JavaPrograms;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        SortingArrayInDescOrder(new int[]{10, 20, 5, 8, 25});
        SortingArrayInAscOrder(new int[]{10, 20, 5, 8, 25});
        SortingArrInDescOrderUsingAL(new int[]{10, 20, 5, 8, 25});
        SortingArrInAscOrderUsingAL(new int[]{10, 20, 5, 8, 25});
    }

    //Sorting array in descending order
    static void SortingArrayInDescOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Sorting Array in descending order : " + Arrays.toString(arr));  //printing array
    }
    //Sorting array in ascending order
    static void SortingArrayInAscOrder(int[] arr){
        System.out.print("Sorting Array in ascending order : ");
        for(int i=0 ; i<arr.length; i++){
            for(int j = i+1 ; j<arr.length ; j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]= arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i : arr){
            System.out.print( i+" ");
        }
        System.out.println();
    }

    //Sorting array in descending order using Arraylist
    static void SortingArrInDescOrderUsingAL(int[] arr){
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : arr){
            al.add(i);
        }
        for(int i = 0 ; i<al.size() ; i++){
            for(int j=i+1 ; j<al.size() ; j++){
                if(al.get(i)<al.get(j)){
                    int temp = al.get(i);
                    al.set(i , al.get(j));
                    al.set(j , temp);
                }
            }
        }
        System.out.println("Sorting Array In descending Order Using AL :" +al);
    }

    //Sorting array in ascending order using Arraylist
    static void SortingArrInAscOrderUsingAL(int[] arr){
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : arr){
            al.add(i);
        }
        for(int i = 0 ; i<al.size() ; i++){
            for(int j=i+1 ; j<al.size() ; j++){
                if(al.get(i)>al.get(j)){
                    int temp = al.get(i);
                    al.set(i , al.get(j));
                    al.set(j , temp);
                }
            }
        }
        System.out.println("Sorting Array In Ascending Order Using AL :" +al);
    }
}