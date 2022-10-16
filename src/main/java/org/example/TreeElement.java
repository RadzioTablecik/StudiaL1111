package org.example;

/**Klasa tworzaca strukture drzewa */
public class TreeElement<T extends Comparable<T>> {
    T key;
    TreeElement<T> left;
    TreeElement<T> right;

    /**
     * Konstruktor elementu drzewa
     */
    public TreeElement(T key) {
        this.key = key;
        left = null;
        right = null;
    }

    /**Funkcja wyswietlajaca drzewo */
    public String toString(){
        return key.toString();
    }
}



