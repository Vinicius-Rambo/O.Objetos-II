package com.example.testelab.services;

import static org.junit.jupiter.api.Assertions.assertTrue; //Static para não precisar colocar o nome
import org.junit.jupiter.api.Test;


public class MatematicaServiceTest { //Arquivo para enganar o VScode e fazer testes

    @Test //Notação do Spring para testes
    public void deveriaSomarDoisNumeros(){ //Use nomes OBVIOS 

        //Cenario 
        MatematicaService matematicaService = new MatematicaService();

        //Ação
        int resultado = matematicaService.somar(21, 30);

        //Verificação
        //System.out.println(resultado == 50);

        assertTrue(resultado == 50); //Verificação por Assert 

    }

}
