package com.abdul.firstapp;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd() {
        int expected = 40;
        int actual = Calculator.add(20,20);
        assertEquals(expected,actual);
    }

    public void testMultiply() {
        int expected = 40;
        int actual = Calculator.multiply(2,20);
        assertEquals(expected,actual);
    }
}