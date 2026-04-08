package com.example.testelab.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.testelab.models.Locacao;
import com.example.testelab.models.Usuario;
import com.example.testelab.models.Filme;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;


public class LocacaoServiceTest {
    
    @Test
    public void naodeveAlugarFilme_QuandoEstoqMenorQueZero(){

        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario(); 
        Filme filme = new Filme("Filme1 ", 5, 2.50);
        
        List<Filme> filmes = new ArrayList<>();
        filmes.add(filme);

        Locacao locacao = null;
        //Ação
        try{
            locacao = service.alugarFilme(usuario, filmes);
            
            fail("Não pode alugar filme, sem estoque");

        //Verificação
        }catch(Exception e){
            assertNotNull(locacao);

        }
    }

    @Test
    public void deveLancarUmaExcecao_QuandoEstoqueForZerado()throws Exception { //Ele foi feito para dar errado.
        
        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario(); 
        Filme filme = new Filme("Filme1 ", 1, 2.50);
        List<Filme> filmes = new ArrayList<>();
        filmes.add(filme);


        assertThrows(Exception.class, ()->{service.alugarFilme(usuario, filmes);});

    }
}
