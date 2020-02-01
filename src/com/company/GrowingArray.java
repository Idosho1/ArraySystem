package com.company;

public class GrowingArray extends FlexiArray {

    public GrowingArray(int size) {
        super(size);
    }

    public void resize(int newSize) {
        int[] newArray = new int[(int) (1.2*newSize) + 1];
        for (int i = 0; i<length(); i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    public void set(int index, int value) {
        if (index >= length()) {
            resize(index);
        }
        super.set(index,value);
    }

    public int get(int index) {
        if (index >= length()) {return 0;}
        return super.get(index);
    }
}
