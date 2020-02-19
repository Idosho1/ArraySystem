package com.company;

public class HashMap implements ArrayInterface {
    protected int[] keys;
    protected int[] values;
    protected int size;
    protected SparseArray collisions;

    public HashMap(int size) {
        this.size = size;
        this.keys = new int[size];
        this.values = new int[size];
    }

    public int assignHashIndex(int k) {
        Integer k_int = k;
        return Math.abs(k_int.hashCode() % size);
    }

    public void set(int index, int value) {
        int ind = assignHashIndex(index);
        keys[ind] = index;
        values[ind] = value;
    }

    public int get(int index) {
        return values[assignHashIndex(index)];
    }

    public int length() {
        return size;
    }
}

