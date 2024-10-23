package org.tyutyunik.service.impl;

import org.tyutyunik.service.IntegerListInterface;
import org.tyutyunik.service.exceptions.NotFoundException;

import java.util.Arrays;

public class IntegerList implements IntegerListInterface {
    private Integer[] storage;

    private int size;

    public IntegerList(int lenght) {
        this.storage = new Integer[lenght];
    }

    private static void mergeSort(Integer[] array) {
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

    @Override
    public Integer add(Integer item) {
        checkAndResizeLenght();
        storage[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkAndResizeLenght();
        checkIndex(index);
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkAndResizeLenght();
        checkIndex(index);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        size = -1;
        return remove(indexOf(item));
    }

    @Override
    public Integer remove(int index) {
        if (index == -1) {
            throw new NotFoundException();
        }
        Integer item = storage[index];
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[size - 1] = null;
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerListInterface otherList) {
        if (otherList == this) return true;
        if (otherList == null) return false;
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public String toString() {
        return "IntegerList{" + "storage=" + Arrays.toString(storage) + ", size=" + this.size + ", lenght=" + storage.length + '}';
    }

    private int binarySearch(Integer item) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (storage[mid].equals(item)) {
                return mid;
            } else if (storage[mid] < item) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private void sort() {
        mergeSort(storage);
    }

    private void checkLenght() {
        if (size >= storage.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkAndResizeLenght() {
        if (size >= storage.length) {
            grow();
        }
    }

    private void grow() {
        storage = Arrays.copyOf(storage, (int) (storage.length * 1.5));
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
