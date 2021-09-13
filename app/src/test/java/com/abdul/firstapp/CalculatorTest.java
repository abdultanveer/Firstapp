package com.abdul.firstapp;

import com.abdul.firstapp.model.Calculator;

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

    public void testSubtract() {
        int expected = 40;
        int actual = Calculator.subtract(80,40);
        assertEquals(expected,actual);
    }

    public void testDivide() {
        int expected = 40;
        int actual = Calculator.divide(80,2);
        assertEquals(expected,actual);
    }

    public void testModulo() {
        int expected = 2;
        int actual = Calculator.divide(12,5);
        assertEquals(expected,actual);
    }
}