package com.company;

public class Colony {
    protected int colonySize;
    protected Array2DB cells;
    protected int genNum;


    public Colony(int size) {
        this.colonySize = size;
        this.genNum = 0;
        this.cells = new Array2DB(size,size);
    }

    public int getColonySize() {
        return colonySize;
    }

    public int getGenerationNumber() {
        return genNum;
    }

    public int getNumberLivingCells() {
        int sum = 0;
        for(int r = 0; r < colonySize; r++) {
            for(int c = 0; c < colonySize; c++) {
                if(isCellAlive(r,c)) {sum++;}
            }
        }
        return sum;
    }

    public void resetColony() {
        for(int r = 0; r < colonySize; r++) {
            for(int c = 0; c < colonySize; c++) {
                setCellDead(r,c);
            }
        }
    }

    public void setCellAlive(int row, int col) {
        cells.set(row,col,1);
    }

    public void setCellDead(int row, int col) {
        cells.set(row,col,0);
    }

    public boolean isCellAlive(int row, int col) {
        return cells.get(row,col) == 1;
    }

    public void evolve() {
        Array2DB newCells = new Array2DB(colonySize,colonySize);

        for(int r = 0; r < colonySize; r++) {
            for (int c = 0; c < colonySize; c++) {
                int alive = 0;
                for(int rowOffset = -1; rowOffset <= 1; rowOffset++) {
                    for(int colOffset = -1; colOffset <= 1; colOffset++) {
                        if(isCellAlive(r+rowOffset,c+colOffset)) {
                            alive++;
                        }
                    }
                }
                if(isCellAlive(r,c)) {
                    newCells.set(r,c,1);
                    alive--;
                }
                if(alive < 2) {newCells.set(r,c,0);}
                if(alive > 3) {newCells.set(r,c,0);}
                if(alive == 3) {newCells.set(r,c,1);}
            }
        }
        genNum++;
        cells = newCells;
    }

    public String toString() {
        String result = "\n";
        result += ("Generation #" + getGenerationNumber()) + "\n";
        int n = 0;
        for(int r = 0; r < colonySize; r++) {
            for(int c = 0; c < colonySize; c++) {
                if(n == getColonySize()) {
                    if(isCellAlive(r,c)) {
                        result += "\n* ";
                    } else {
                        result += "\n· ";
                    }
                    n = 0;
                }
                else {
                    if(isCellAlive(r,c)) {
                        result += "* ";
                    } else {
                        result += "· ";
                    }
                }
                n++;
            }
        }
        return result + "\n";
    }
}


