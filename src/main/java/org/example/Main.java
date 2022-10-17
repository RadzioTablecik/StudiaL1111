package org.example;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] Args) {
        Tree<Integer> treeInt = null;
        Tree<String> treeString = null;
        Tree<Double> treeDouble = null;
        System.out.println("Aby stworzyc drzewo o danym typie wpisz: integer, string lub double");
        System.out.println("Operacje na elemencie x: insert x, delete x, search x");
        System.out.println("Aby wyswietlic aktualny stan drzewa wpisz: draw");
        System.out.println("Aby zamknac program wpisz: end");
        Scanner input = new Scanner(System.in);

        String line;
        do {
            line = input.nextLine();
            String[] userInput = line.split("\\s");
            System.out.println(line);
            String message = "";
            switch (userInput[0]) {
                case "integer":
                    System.out.println("Nowe drzewo typu Integer");
                    message = message + "Nowe drzewo typu Integer";
                    treeInt = new Tree();
                    treeDouble = null;
                    treeString = null;
                    break;
                case "double":
                    System.out.println("Nowe drzewo typu Double");
                    message = message + "Nowe drzewo typu Double";
                    treeDouble = new Tree();
                    treeInt = null;
                    treeString = null;
                    break;
                case "string":
                    System.out.println("Nowe drzewo typu String");
                    message = message + "Nowe drzewo typu String";
                    treeString = new Tree();
                    treeDouble = null;
                    treeInt = null;
                    break;//dsdsdsdsd
                case "insert":
                    if (treeInt != null) {
                        treeInt.insert(Integer.parseInt(userInput[1]));
                        message = message + treeInt.toString();
                    } else if (treeString != null) {
                        treeString.insert(userInput[1]);
                        message = message + treeString.toString();
                    } else if (treeDouble != null) {
                        treeDouble.insert(Double.parseDouble(userInput[1]));
                        message = message + treeDouble.toString();
                    }
                    break;
                case "delete":
                    if (treeInt != null) {
                        treeInt.delete(Integer.parseInt(userInput[1]));
                        message = message + treeInt.toString();
                    } else if (treeString != null) {
                        treeString.delete(userInput[1]);
                        message = message + treeString.toString();
                    } else if (treeDouble != null) {
                        treeDouble.delete(Double.parseDouble(userInput[1]));
                        message = message + treeDouble.toString();
                    }
                    break;
                case "search":
                    if (treeInt != null) {
                        if (treeInt.isElement(Integer.parseInt(userInput[1]))) {
                            message = message + "Element znajduje sie na drzewie";
                        } else {
                            message = message + "Nie znaleziono elementu";
                        }
                    } else if (treeString != null) {
                        if (treeString.isElement(userInput[1])) {
                            message = message + "Element znajduje sie na drzewie";
                        } else {
                            message = message + "Nie znaleziono elementu";
                        }
                    } else if (treeDouble != null) {
                        if (treeDouble.isElement(Double.parseDouble(userInput[1]))) {
                            message = message + "Element znajduje sie na drzewie";
                        } else {
                            message = message + "Nie znaleziono elementu";
                        }
                    }
                    break;
                case "draw":
                    if (treeInt != null) {
                        message = message + treeInt.toString();
                    } else if (treeString != null) {
                        message = message + treeString.toString();
                    } else if (treeDouble != null) {
                        message = message + treeDouble.toString();
                    }
            }

            System.out.println("-> (" + line + ") = " + message);
        } while(!line.equals("end"));

    }
}
