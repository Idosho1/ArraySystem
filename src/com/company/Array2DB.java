package com.company;

public class Array2DB extends Array2D {

    // Normal Constructor
    public Array2DB(int numberRows, int numberCols, boolean isSparse) {
        super(numberRows+2, numberCols+2, isSparse);
    }

    // Hash Constructor
    public Array2DB(int numberRows, int numberCols) {super(numberRows+2,numberCols+2);}

    public int index(int r, int c) {
        return (c+1 + numberCols * (r+1));
    }

    public void isInBounds(int r, int c) {
        super.isInBounds(r+1,c+1);
    }

    public int numberRows() {
        return super.numberRows()-2;
    }

    public int numberCols() {
        return super.numberCols()-2;
    }
}

