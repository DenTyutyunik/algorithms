package org.tyutyunik.service.impl;

public class Sort {
    public static void bubbleSort(Integer[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swapElements(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void insertionSort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
            }
            swapElements(array, indexMin, i);
        }
    }

    public static void mergeSort(Integer[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[array.length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[mid + i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(Integer[] array, Integer[] left, Integer[] right) {
        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                array[mainP++] = left[leftP++];
            } else {
                array[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            array[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            array[mainP++] = right[rightP++];
        }
    }

    private static void swapElements(Integer[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = array[first];
    }
}
