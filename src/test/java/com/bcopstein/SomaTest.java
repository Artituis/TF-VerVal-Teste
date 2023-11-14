package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomaTest{
    @Test
    public void testaSomaSimples(){
        Somador s = new Somador();
        assertEquals(30,s.calcula(10,20));
    }
    
}
