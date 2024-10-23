package org.tyutyunik.service.impl;

import org.junit.jupiter.api.Test;
import org.tyutyunik.service.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {

    @Test
    public void testConstructor() {
        StringList storage = new StringList(10);
        assertEquals(0, storage.size());
    }

    @Test
    public void add() {
        StringList storage = new StringList(5);
        String item = "10";
        String addedItem = storage.add(item);
        assertEquals(1, storage.size());
        assertEquals(item, storage.get(0));
        assertEquals(addedItem, item);
    }

    @Test
    public void addWithLenghtResize() {
        StringList storage = new StringList(10);
        for (int i = 0; i < 10; i++) {
            storage.add(String.valueOf(i));
        }
        assertEquals(10, storage.size());
        storage.add("10");
        for (int i = 0; i < 11; i++) {
            assertEquals((String.valueOf(i)), storage.get(i));
        }
        assertEquals(11, storage.size());
    }

    @Test
    public void addWithInvalidIndex() {
        StringList storage = new StringList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.add(11,"1"));
    }

    @Test
    public void addWithNegativeIndex() {
        StringList storage = new StringList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.add(-1,"1"));
    }

    @Test
    public void set() {
        StringList storage = new StringList(10);
        storage.add("1");
        storage.add("2");
        storage.set(1, "10");
        assertEquals("10", storage.get(1));
    }

    @Test
    public void setWithIllegalSize() {
        StringList storage = new StringList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.set(1, "1"));
    }

    @Test
    public void setWithInvalidIndex() {
        StringList storage = new StringList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.set(11,"1"));
    }

    @Test
    public void setWithNegativeIndex() {
        StringList storage = new StringList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> storage.set(-1,"1"));
    }

    @Test
    public void remove() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        storage.add("3");
        String removedItem = storage.remove(1);
        assertEquals(2, storage.size());
        assertArrayEquals(new String[]{"1", "3"}, storage.toArray());
        assertEquals(removedItem, "2");
    }

    @Test
    public void removeWithItemNonExistent() {
        StringList storage = new StringList(10);
        storage.add("1");
        storage.add("2");
        assertThrows(IndexOutOfBoundsException.class, () -> storage.remove(11));
    }

    @Test
    public void removeWithIndexNegative() {
        StringList storage = new StringList(5);
        storage.add("1");
        assertThrows(NotFoundException.class, () -> storage.remove(-1));
    }

    @Test
    public void contains() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        assertTrue(storage.contains("2"));
    }

    @Test
    public void containsWithNonExistItem() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        assertFalse(storage.contains("3"));
    }

    @Test
    public void indexOf() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        storage.add("3");
        assertEquals(1, storage.indexOf("2"));
    }

    @Test
    public void indexOfWithNonExistItem() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        assertEquals(-1, storage.indexOf("3"));
    }

    @Test
    public void lastIndexOf() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        storage.add("2");
        assertEquals(2, storage.lastIndexOf("2"));
    }

    @Test
    public void lastIndexOfWithNonExistItem() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        assertEquals(-1, storage.lastIndexOf("3"));
    }

    @Test
    public void get() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        assertEquals("1", storage.get(0));
    }

    @Test
    public void getWithInvalidIndex() {
        StringList storage = new StringList(5);
        storage.add("1");
        assertThrows(IndexOutOfBoundsException.class, () -> storage.get(10));
    }

    @Test
    public void getWithNegativeIndex() {
        StringList storage = new StringList(5);
        storage.add("1");
        assertThrows(IndexOutOfBoundsException.class, () -> storage.get(-1));
    }

    @Test
    public void equals() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        StringList storageSecond = new StringList(5);
        storageSecond.add("1");
        storageSecond.add("2");
        assertTrue(storage.equals(storageSecond));
    }

    @Test
    public void equalsNullArgument() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        assertFalse(storage.equals(null));
    }

    @Test
    public void isEmptyWithEmptyList() {
        StringList storage = new StringList(5);
        assertTrue(storage.isEmpty());
    }

    @Test
    public void isEmptyWithNotEmptyList() {
        StringList storage = new StringList(5);
        storage.add("1");
        assertFalse(storage.isEmpty());
    }

    @Test
    public void clear() {
        StringList storage = new StringList(5);
        storage.add("1");
        storage.add("2");
        storage.clear();
        assertTrue(storage.isEmpty());
        assertEquals(0, storage.size());
    }
}