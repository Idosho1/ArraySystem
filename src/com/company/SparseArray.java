package com.company;

public class SparseArray implements ArrayInterface {
    protected GrowingArray keys;
    protected GrowingArray values;
    protected int size;
    protected int pointer = 0;

    public SparseArray(int size) {
        this.keys = new GrowingArray(10);
        this.values = new GrowingArray(10);
        this.size = size;
    }

    public int findKeyIndex(int index) {
        for (int i = 0; i<keys.length(); i++) {
            if (keys.get(i) == index) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, int value) {
        int ind = findKeyIndex(index);
        if (ind == -1) {
            if (pointer < length()) {
                keys.set(pointer, index);
                values.set(pointer, value);
                pointer += 1;
            } else {System.exit(1);}
        } else {
            values.set(ind, value);
        }
    }

    public int get(int index) {
            int ind = findKeyIndex(index);
            if (ind == -1) {
                return 0;
            }
            return values.get(ind);
    }

    public int length() {
        return size;
    }

    public int numberElements() {
        return pointer;
    }

}
