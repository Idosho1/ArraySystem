package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SimpleUI {
    protected Map<String,Colony> colonies;
    protected boolean noisy;
    protected Colony current;
    protected String currentName;
    protected String[] line;
    protected String command;

    public SimpleUI() {
        Colony col = new Colony(5);
        Map<String,Colony> cols = new HashMap<String, Colony>();
        cols.put("default",col);
        this.current = col;
        this.currentName = "default";
        this.colonies = cols;
        this.noisy = true;
        this.command = "START";
    }

    public String[] splitStringIntoParts(String s) {
        return s.split("\\s+");
    }

    public void help() {
        String result = "\n";
        result+="help               ;print out a list of legal commands\n";
        result+="add <name> <size>  ;adds a colony with a name of <name> and a side length of <size>\n";
        result+="current <name>     ;sets the current colony to <name>\n";
        result+="display            ;prints out the current colony\n";
        result+="alive <row> <col>  ;sets the specified cell of current colony alive\n";
        result+="dead <row> <col>   ;sets the specified cell of current colony dead\n";
        result+="info               ;prints out a list of all colonies with some useful information\n";
        result+="silent             ;sets evolve into silent mode\n";
        result+="noisy              ;sets evolve into noisy mode\n";
        result+="reset              ;resets the colony\n";
        result+="random <p>         ;sets each cell alive with probability <p>\n";
        result+="evolve <times>     ;evolves the current colony <times> times. If in noisy mode also prints\n";
        result+="                    ;out each new generation. If in silent mode, only prints out the final\n";
        result+="                    ;generation of the evolve.\n";
        result+="quit               ;quits the program\n";
        System.out.println(result);
    }

    public void reset() {
        current.resetColony();
    }

    public void add(String name, int size) {
        colonies.put(name,new Colony(size));
    }

    public void current(String name) {
        current = (Colony) colonies.get(name);
        currentName = name;
    }

    public void info() {
        for (Map.Entry<String, Colony> entry : colonies.entrySet()) {
            String name = entry.getKey();
            Colony colony = entry.getValue();
            String result = "\n";

            if(name.equals(currentName)) {
                result += "*";
            } else {result += "-";}
            result += (name + ": Generation #" + colony.genNum + ", Size: " + colony.getColonySize());
            System.out.println(result + "\n");
        }
    }

    public void random(double p) {
        for(int r = 0; r < current.getColonySize(); r++) {
            for(int c = 0; c < current.getColonySize(); c++) {
                double n = Math.random();
                if(n <= p) {
                    current.setCellAlive(r,c);
                }
            }
        }
    }

    public void evolve(int times) {
        int evolveLeft = times;
        if(!noisy) {
            do {
                current.evolve();
                evolveLeft--;
            } while (evolveLeft > 0);
            System.out.println(current.toString());
        } else {
            do {
                current.evolve();
                System.out.println(current.toString());
                evolveLeft--;
            } while (evolveLeft > 0);
        }
    }

    public void run() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\n\n\n\nWelcome to Conway's Game of Life!");
        System.out.println("Type 'help' to get started\n");

        while(command != "quit") {
            System.out.print("Command... ");
            command = console.readLine();
            line = splitStringIntoParts(command);

            if(command != "quit" && command != "") {
                switch (line[0]) {
                    case "help":
                        help();
                        break;
                    case "reset":
                        reset();
                        break;
                    case "random":
                        if(line.length >= 2) {
                            try {
                                double p = Double.parseDouble(line[1]);
                            } catch (NumberFormatException nfe) {
                                System.err.println("\nProbability must be a double!\n");
                                break;
                            }
                            double p = Double.parseDouble(line[1]);
                            random(p);
                            break;
                        } else {System.out.println("\n'random' command requires a probability!\n");}
                        break;
                    case "add":
                        if(line.length >= 3) {
                            try {
                                int size = Integer.parseInt(line[2]);
                            } catch (NumberFormatException nfe) {
                                System.out.println("\nSize must be an integer!\n");
                                break;
                            }
                            int size = Integer.parseInt(line[2]);
                            if(size > 0) {
                                boolean add = true;
                                for (Map.Entry<String, Colony> entry : colonies.entrySet()) {
                                    String name = entry.getKey();

                                    if(name.equals(line[1])) {
                                        System.out.println("\ncolony '" + name + "' already exists!\n");
                                        add = false;
                                    }
                                }
                                if(add) {
                                    add(line[1], Integer.parseInt(line[2]));
                                }
                            } else {System.out.println("\nSize must be greater than 0!\n");}
                        } else {System.out.println("\n'add' command requires both a name and a size!\n");}
                        break;
                    case "current":
                        if(line.length >= 2) {
                            if(colonies.containsKey(line[1])) {
                                current(line[1]);
                            } else {
                                System.out.println("\nColony " + "'" + line[1] + "'" + " does not exist!\n");
                            }
                        } else {System.out.println("\n'current' requires a name!\n");}
                        break;
                    case "display":
                        System.out.println(current.toString());
                        break;
                    case "alive":
                        if(line.length >= 3) {
                            try {
                                int r = Integer.parseInt(line[1]);
                                int c = Integer.parseInt(line[2]);
                            } catch (NumberFormatException nfe) {
                                System.out.println("\nRow and Col must be integers!\n");
                                break;
                            }
                            int r = Integer.parseInt(line[1]);
                            int c = Integer.parseInt(line[2]);
                            if(r>=0 && r<current.getColonySize() && c>=0 && c<current.getColonySize()) {
                                current.setCellAlive(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                            } else {
                                System.out.println("\n(" + r + "," + c + ") is out of bounds!\n");
                            }
                        } else {System.out.println("\n'alive' command requires both a row and a col!\n");}
                        break;
                    case "dead":
                        if(line.length >= 3) {
                            try {
                                int r = Integer.parseInt(line[1]);
                                int c = Integer.parseInt(line[2]);
                            } catch (NumberFormatException nfe) {
                                System.out.println("\nRow and Col must be integers!\n");
                                break;
                            }
                            int r = Integer.parseInt(line[1]);
                            int c = Integer.parseInt(line[2]);
                            if(r>=0 && r<current.getColonySize() && c>=0 && c<current.getColonySize()) {
                                current.setCellDead(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                            } else {
                                System.out.println("\n(" + r + "," + c + ") is out of bounds!\n");
                            }
                        } else {System.out.println("\n'dead' command requires both a row and a col!\n");}
                        break;
                    case "info":
                        info();
                        break;
                    case "silent":
                        noisy = false;
                        break;
                    case "noisy":
                        noisy = true;
                        break;
                    case "evolve":
                        if(line.length >= 2) {
                            try {
                                int number = Integer.parseInt(line[1]);
                            } catch (NumberFormatException nfe) {
                                System.out.println("\nNumber of evolutions must be an integer!\n");
                                break;
                            }
                            evolve(Integer.parseInt(line[1]));
                        } else {System.out.println("\n'evolve' requires number of evolutions!\n");}
                        break;
                    case "quit":
                        System.out.println("\nQuitting...\n");
                        System.exit(1);
                        break;
                    default:
                        System.out.println("\n'" + command + "'" + " is not a legal command!\n");

                }
            }

        }

    }
}
