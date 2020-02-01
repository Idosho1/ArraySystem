package com.company;

public class Array2D {
    protected int numberRows;
    protected int numberCols;
    protected ArrayInterface array;

    public Array2D(int numberRows, int numberCols, boolean isSparse) {
        this.numberRows = numberRows;
        this.numberCols = numberCols;
        if (isSparse) {
            this.array = new SparseArray(numberRows*numberCols);
        } else {
            this.array = new GrowingArray(numberRows*numberCols);
        }
    }

    public int index(int r, int c) {
        return (c+1 + numberCols * (r+1));
    }

    public boolean isInBounds(int r, int c) {
        if (r>=0 && r<numberRows() && c>=0 && c<numberCols()) {
            return true;
        }
        System.out.println("Array2D Index out of range r: " + r + " col: " + c);
        System.out.println("    maxRows: " + numberRows() + " maxCols: " + numberCols());
        System.out.println("Java Result: 1");
        return false;
    }

    public void set(int r, int c, int value) {
        if (isInBounds(r,c)) {
            array.set(index(r, c), value);
        }
    }

    public int get(int r, int c) {
        if (isInBounds(r,c)) {
            return array.get(index(r, c));
        }
        return 0;
    }

    public int numberRows() {
        return numberRows;
    }

    public int numberCols() {
        return numberCols;
    }
}

