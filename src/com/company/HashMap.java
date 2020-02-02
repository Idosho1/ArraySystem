package com.company;

public class HashMap {
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
        Integer k_int = new Integer(k);
        return Math.abs(k_int.hashCode() % size);
    }

    public void set(int k, int v) {
        int ind = assignHashIndex(k);
        keys[ind] = k;
        values[ind] = v;
    }

    public int get(int k) {
        return values[assignHashIndex(k)];
    }

}
