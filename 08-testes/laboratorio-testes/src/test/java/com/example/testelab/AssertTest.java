package com.example.testelab;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.testelab.models.Usuario;

import static org.junit.jupiter.api.Assertions.*; 
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//Import Static permite escrever os metodos sem dar aonde ele vem.

public class AssertTest {

    @Test 
    public void deveDemostrarAssercoesConJunit(){

        assertTrue(true);
        assertFalse(false);
        assertNull(null);
        //assertNotNull(new object());
        assertEquals(1,1);

        //Delta de precisão
        assertEquals(0.2345, 0.23, 0.01);  //Terceiro parametro é o delta de precissão nesse caso 2 casas decimais

        Usuario u1 = new Usuario("Fulano 0");
        Usuario u2 = new Usuario("Fulano 0");

        assertEquals(u1, u2);

        assertSame(u1, u1);


    }

}
