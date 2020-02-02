package com.company;
import java.io.IOException;

public class Main {

    private static void testArray2D(boolean isSparse) {
        int count = 0;
        Array2D a2d = new Array2D(3,4,isSparse);
        for (int r = 0; r < 3; r++) {
            for(int c = 0; c < 4; c++) {
                a2d.set(r,c,count);
                count += 1;
            }
        }
        for (int r = 0; r < 3; r++) {
            for(int c = 0; c < 4; c++) {
                System.out.print(a2d.get(r,c) + " ");

            }
            System.out.println();
        }
        System.out.println("Number rows: " + a2d.numberRows());
        System.out.println("Number cols: " + a2d.numberCols());
        System.out.println("Now Crash it!!");
        a2d.set(5,5,12);
    }

    private static void testArray2DHash() {
        int count = 0;
        Array2DHash a2d = new Array2DHash(3,4);
        for (int r = 0; r < 3; r++) {
            for(int c = 0; c < 4; c++) {
                a2d.set(r,c,count);
                count += 1;
            }
        }
        for (int r = 0; r < 3; r++) {
            for(int c = 0; c < 4; c++) {
                System.out.print(a2d.get(r,c) + " ");

            }
            System.out.println();
        }
        System.out.println("Number rows: " + a2d.numberRows());
        System.out.println("Number cols: " + a2d.numberCols());
        System.out.println("Now Crash it!!");
        a2d.set(5,5,12);
    }

    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Hello. Please write your name: ");
        String name = br.readLine();
        System.out.println("Your name is: "+name);*/
        //testArray2DHash();
        SimpleUI UI = new SimpleUI();
        UI.run();
        /*Colony col = new Colony(20);
        col.setCellAlive(5,5);
        col.setCellAlive(5,6);
        col.setCellAlive(5,7);
        col.setCellAlive(6,6);
        System.out.println(col.toString());
        col.evolve();
        System.out.println(col.toString());
        col.evolve();
        System.out.println(col.toString());
        col.evolve();
        System.out.println(col.toString());
        col.evolve();
        System.out.println(col.toString());
        col.evolve();
        System.out.println(col.toString());
        col.evolve();
        System.out.println(col.toString());
        col.evolve();
        System.out.println(col.toString());
	    FlexiArray flexi = new FlexiArray(5);
	    flexi.set(0,59);
        flexi.set(1,21);
        flexi.set(2,34);
        flexi.set(3,87);
        System.out.println(flexi.get(3));
        System.out.println(flexi.get(4));

        GrowingArray growing = new GrowingArray(5);
        growing.set(0,59);
        System.out.println(growing.get(0));
        System.out.println(growing.length());
        growing.set(10,17);
        System.out.println(growing.get(10));
        System.out.println(growing.length());

        SparseArray sparse = new SparseArray(5);
        System.out.println(sparse.length());
        System.out.println(sparse.numberElements());
        sparse.set(3,54);
        sparse.set(1,32);
        sparse.set(5,71);
        sparse.set(2,14);
        sparse.set(4,54);
        sparse.set(6,19);
        sparse.set(7,42);
        System.out.println(sparse.numberElements());
        System.out.println(sparse.length());
        System.out.println(sparse.get(7));
        System.out.println(sparse.get(3));
        sparse.set(3,100);
        System.out.println(sparse.numberElements());
        System.out.println(sparse.length());
        System.out.println(sparse.get(3));*/

    }
}
