package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SubtratorTest {
    @Test
    public void testaSomaSimples(){
        Subtrator s = new Subtrator();
        assertEquals(25,s.calcula(30,5));
    }
}
