package com.company;

public class Array2DBHash extends Array2DHash {

    public Array2DBHash(int numberRows, int numberCols) {
        super(numberRows+2, numberCols+2);
    }

    public int index(int r, int c) {
        return (c+1 + numberCols * (r+1));
    }

    public boolean isInBounds(int r, int c) {
        if (r>=-1 && r<numberRows()+1 && c>=-1 && c<numberCols()+1) {
            return true;
        }
        System.out.println("Array2D Index out of range r: " + r + " col: " + c);
        System.out.println("    maxRows: " + numberRows() + " maxCols: " + numberCols());
        System.out.println("Java Result: 1");
        System.exit(1);
        return false;
    }
}
