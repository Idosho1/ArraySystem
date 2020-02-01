package com.company;

public class FlexiArray implements ArrayInterface {
    protected int[] array;

    public FlexiArray(int size) {
        this.array = new int[size];
    }
    public void set(int index, int value) {
        array[index] = value;
    }
    public int get(int index) {
        return array[index];
    }
    public int length() {
        return array.length;
    }
}
