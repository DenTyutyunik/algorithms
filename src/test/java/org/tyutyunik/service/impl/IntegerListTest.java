package org.tyutyunik.service.impl;

import org.junit.jupiter.api.Test;
import org.tyutyunik.service.exceptions.NotFoundException;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListTest {
    private static final Random RANDOM = new Random(); // RANDOM.nextInt()

    @Test
    public void testConstructor() {
        IntegerList storage = new IntegerList(10);
        assertEquals(0, storage.size());
    }

    @Test
    public void add() {
        IntegerList storage = new IntegerList(5);
        Integer item = 10;
        Integer addedItem = storage.add(item);
        assertEquals(1, storage.size());
        assertEquals(item, storage.get(0));
        assertEquals(addedItem, item);
    }

    @Test
    public void addWithLenghtResize() {
        IntegerList storage = new IntegerList(10);
        for (int i = 0; i < 10; i++) {
            storage.add(i);
        }
        assertEquals(10, storage.size());
        storage.add(10);
        for (int i = 0; i < 11; i++) {
            assertEquals(i, storage.get(i));
        }
        assertEquals(11, storage.size());
    }

    @Test
    public void addWithInvalidIndex() {
        IntegerList storage = new IntegerList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.add(11,1));
    }

    @Test
    public void addWithNegativeIndex() {
        IntegerList storage = new IntegerList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.add(-1,1));
    }

    @Test
    public void set() {
        IntegerList storage = new IntegerList(10);
        storage.add(1);
        storage.add(2);
        storage.set(1, 10);
        assertEquals(10, storage.get(1));
    }

    @Test
    public void setWithIllegalSize() {
        IntegerList storage = new IntegerList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.set(1, 1));
    }

    @Test
    public void setWithInvalidIndex() {
        IntegerList storage = new IntegerList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.set(11,1));
    }

    @Test
    public void setWithNegativeIndex() {
        IntegerList storage = new IntegerList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.set(-1,1));
    }

    @Test
    public void remove() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        storage.add(3);
        Integer removedItem = storage.remove(1);
        assertEquals(2, storage.size());
        assertArrayEquals(new Integer[]{1, 3}, storage.toArray());
        assertEquals(removedItem, 2);
    }

    @Test
    public void removeWithItemNonExistent() {
        IntegerList storage = new IntegerList(10);
        storage.add(1);
        storage.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.remove(11));
    }

    @Test
    public void removeWithIndexNegative() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        assertThrows(NotFoundException.class, () -> storage.remove(-1));
    }

    @Test
    public void contains() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        assertTrue(storage.contains(2));
    }

    @Test
    public void containsWithNonExistItem() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        assertFalse(storage.contains(3));
    }

    @Test
    public void indexOf() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        storage.add(3);
        assertEquals(1, storage.indexOf(2));
    }

    @Test
    public void indexOfWithNonExistItem() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        assertEquals(-1, storage.indexOf(3));
    }

    @Test
    public void lastIndexOf() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        storage.add(2);
        assertEquals(2, storage.lastIndexOf(2));
    }

    @Test
    public void lastIndexOfWithNonExistItem() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        assertEquals(-1, storage.lastIndexOf(3));
    }

    @Test
    public void get() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        assertEquals(1, storage.get(0));
    }

    @Test
    public void getWithInvalidIndex() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.get(10));
    }

    @Test
    public void getWithNegativeIndex() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.get(-1));
    }

    @Test
    public void equals() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        IntegerList storageSecond = new IntegerList(5);
        storageSecond.add(1);
        storageSecond.add(2);
        assertTrue(storage.equals(storageSecond));
    }

    @Test
    public void equalsNullArgument() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        assertFalse(storage.equals(null));
    }

    @Test
    public void isEmptyWithEmptyList() {
        IntegerList storage = new IntegerList(5);
        assertTrue(storage.isEmpty());
    }

    @Test
    public void isEmptyWithNotEmptyList() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        assertFalse(storage.isEmpty());
    }

    @Test
    public void clear() {
        IntegerList storage = new IntegerList(5);
        storage.add(1);
        storage.add(2);
        storage.clear();
        assertTrue(storage.isEmpty());
        assertEquals(0, storage.size());
    }
}