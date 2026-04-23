package com.project.tests;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsRevise {
    static void main() {
        arrayListPractice();
    }

    static void arrayListPractice() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(30.50);
        arrayList.add(true);
        arrayList.add("Akshatha");
        arrayList.add('C');
        System.out.println(arrayList);
        arrayList.add(2, 12345); // insertion/deletion of elements is not recommended for Arraylist
        for (Object al : arrayList) {
            System.out.print(al + " , ");
        }
        System.out.println();
        System.out.println("Arraylist size : " + arrayList.size());
        System.out.println("arrayList.get(4) : " + arrayList.get(4));
        arrayList.set(2, "Akshatha");
        arrayList.remove(5);
        System.out.println(arrayList);
        System.out.println("arrayList.isEmpty() : " + arrayList.isEmpty());
        System.out.println("arrayList.contains(30.5) : " + arrayList.contains(30.5));

        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        arrayList1.add(400);
        arrayList1.add(300);
        arrayList1.add(100);
        arrayList1.add(700);
        arrayList1.add(200);
        System.out.println(arrayList1);
        Collections.sort(arrayList1);
        System.out.println("Asc order : " + arrayList1);
//        Collections.sort(arrayList1, Collections.reverseOrder());
        Collections.reverse(arrayList1);
        System.out.println("Desc order : " + arrayList1);
        arrayList.addAll(arrayList1);
        System.out.println("arrayList : " +arrayList);
        System.out.println("arrayList.containsAll(arrayList1) : "+arrayList.containsAll(arrayList1));
//        arrayList.removeAll(arrayList1);
        System.out.println("arrayList : " + arrayList);
    }


}
