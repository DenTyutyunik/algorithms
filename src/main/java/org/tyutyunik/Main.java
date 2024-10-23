package org.tyutyunik;

import org.tyutyunik.service.impl.IntegerList;
import org.tyutyunik.service.impl.Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        // Work with lists
        System.out.println("List:");
        IntegerList arrayList = new IntegerList(10);
        for (int i = 0; i < 11; i++) {
            arrayList.add(i);
        }
        System.out.println("arrayList = " + arrayList);

        // Sort
        System.out.println("Sort:");

        System.out.print("Bubble sort...");
        Integer[] bubbleSortArray = new Integer[99_999];
        for (int i = 0; i < bubbleSortArray.length; i++) {
            bubbleSortArray[i] = RANDOM.nextInt();
        }
        long bubbleSortTimeStart = System.currentTimeMillis();
        Sort.bubbleSort(bubbleSortArray);
        long bubbleSortTimeEnd = System.currentTimeMillis();
        System.out.printf(" Time: %s ms\n", (bubbleSortTimeEnd - bubbleSortTimeStart));

        System.out.print("Insertion sort...");
        Integer[] insertionSortArray = new Integer[99_999];
        for (int i = 0; i < insertionSortArray.length; i++) {
            insertionSortArray[i] = RANDOM.nextInt();
        }
        long insertionSortTimeStart = System.currentTimeMillis();
        Sort.insertionSort(insertionSortArray);
        long insertionSortTimeEnd = System.currentTimeMillis();
        System.out.printf(" Time: %s ms\n", (insertionSortTimeEnd - insertionSortTimeStart));

        System.out.print("Selection sort...");
        Integer[] selectionSortArray = new Integer[99_999];
        for (int i = 0; i < selectionSortArray.length; i++) {
            selectionSortArray[i] = RANDOM.nextInt();
        }
        long selectionSortTimeStart = System.currentTimeMillis();
        Sort.selectionSort(selectionSortArray);
        long selectionSortTimeEnd = System.currentTimeMillis();
        System.out.printf(" Time: %s ms\n", (selectionSortTimeEnd - selectionSortTimeStart));

        System.out.print("Merge sort...");
        Integer[] mergeSortArray = new Integer[99_999];
        for (int i = 0; i < mergeSortArray.length; i++) {
            mergeSortArray[i] = RANDOM.nextInt();
        }
        long mergeSortTimeStart = System.currentTimeMillis();
        Sort.mergeSort(mergeSortArray);
        long mergeSortTimeEnd = System.currentTimeMillis();
        System.out.printf(" Time: %s ms\n", (mergeSortTimeEnd - mergeSortTimeStart));
    }
}
