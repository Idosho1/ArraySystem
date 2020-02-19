package com.company;

public class Array2D {
    protected int numberRows;
    protected int numberCols;
    protected ArrayInterface array;

    // Normal Constructor
    public Array2D(int numberRows, int numberCols, boolean isSparse) {
        this.numberRows = numberRows;
        this.numberCols = numberCols;
        if (isSparse) {
            this.array = new SparseArray(numberRows*numberCols);
        } else {
            this.array = new FlexiArray(numberRows*numberCols);
        }
    }

    // Hash Constructor
    public Array2D(int numberRows, int numberCols) {
        this.numberRows = numberRows;
        this.numberCols = numberCols;
        this.array = new HashMap(numberRows*numberCols);
    }

    public int index(int r, int c) {
        return (c + numberCols * r);
    }

    public void isInBounds(int r, int c) {
        if (!(r>=0 && r<numberRows && c>=0 && c<numberCols)) {
            System.out.println("Array2D Index out of range r: " + r + " col: " + c);
            System.out.println("    maxRows: " + numberRows() + " maxCols: " + numberCols());
            System.out.println("Java Result: 1");
            System.exit(1);
        }
    }

    public void set(int r, int c, int value) {
        isInBounds(r,c);
        array.set(index(r, c), value);
    }

    public int get(int r, int c) {
        isInBounds(r,c);
        return array.get(index(r, c));
    }

    public int numberRows() {
        return numberRows;
    }

    public int numberCols() {
        return numberCols;
    }
}


