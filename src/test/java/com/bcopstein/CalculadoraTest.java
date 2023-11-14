package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    @Test
    public void testaUmaSoma(){
        Somador som = mock(Somador.class);
        when(som.calcula(0,10)).thenReturn(10);
        when(som.calcula(10,20)).thenReturn(30);
        when(som.calcula(30,30)).thenReturn(60);
        Subtrator sub = null;
        Calculadora c = new Calculadora(som,sub);
        c.calcula("10+20+30");
        assertEquals(60,c.getResultado());
        verify(som,times(3)).calcula(anyInt(),anyInt());
    }

    @Test
    public void testaUmaDiferenca(){
        Somador som = mock(Somador.class);
        when(som.calcula(0,25)).thenReturn(25);
        Subtrator sub = mock(Subtrator.class);
        when(sub.calcula(25,20)).thenReturn(5);
        Calculadora c = new Calculadora(som,sub);
        c.calcula("25-20");
        assertEquals(5,c.getResultado());
        verify(som,atLeastOnce()).calcula(anyInt(),anyInt());
        verify(sub,atLeast(1)).calcula(anyInt(),anyInt());
    }

    @Test
    public void testaSomaDiferenca(){
        Somador som = mock(Somador.class);
        when(som.calcula(0,20)).thenReturn(20);
        when(som.calcula(20,10)).thenReturn(30);
        Subtrator sub = mock(Subtrator.class);
        when(sub.calcula(30,25)).thenReturn(5);
        Calculadora c = new Calculadora(som,sub);
        c.calcula("20+10-25");
        assertEquals(5,c.getResultado());
        verify(som,atLeastOnce()).calcula(anyInt(),anyInt());
        verify(sub,times(1)).calcula(anyInt(),anyInt());
    }
}
