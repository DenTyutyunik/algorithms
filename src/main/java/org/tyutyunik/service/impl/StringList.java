package org.tyutyunik.service.impl;

import org.tyutyunik.service.StringListInterface;
import org.tyutyunik.service.exceptions.NotFoundException;

import java.util.Arrays;

public class StringList implements StringListInterface {
    private String[] storage;

    private int size;

    public StringList(int lenght) {
        this.storage = new String[lenght];
    }

    @Override
    public String add(String item) {
        checkAndResizeLenght();
        storage[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkAndResizeLenght();
        checkIndex(index);
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkAndResizeLenght();
        checkIndex(index);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        size = -1;
        return remove(indexOf(item));
    }

    @Override
    public String remove(int index) {
        if (index == -1) {
            throw new NotFoundException();
        }
        String item = storage[index];
        System.arraycopy(storage, index + 1, storage, index, size - index);
        storage[size - 1] = null;
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringListInterface otherList) {
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
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public String toString() {
        return "StringList{" + "storage=" + Arrays.toString(storage) + ", size=" + this.size + ", lenght=" + storage.length + '}';
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
