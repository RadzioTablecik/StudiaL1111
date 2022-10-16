package org.example;

import static org.junit.Assert.*;

public class TreeToStringTest {

    @org.junit.Test
    public void testToString() {
        Tree<Integer> treeInt = new Tree<>();
        treeInt.insert(5);
        treeInt.insert(3);
        String result = treeInt.toString();
        assertEquals("(5:(3:():()):())",result);
    }
}