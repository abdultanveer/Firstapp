package com.abdul.firstapp;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd() {
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }

     void testMul(){
        int expected = 20;
        int actual = Calculator.mul(4,5);
        assertEquals(expected,actual);
    }
}