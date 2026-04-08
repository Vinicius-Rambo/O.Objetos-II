package com.example.testelab.services;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import com.example.testelab.models.Filme;
import com.example.testelab.models.Locacao;
import com.example.testelab.models.Usuario;
import com.example.testelab.utils.DataUtils;

public class LocacaoService {

	public Locacao alugarFilme(Usuario usuario, ArrayList<Filme> filmes)throws Exception{

		for (Filme filme : filmes) {
			if (filme.getEstoque() == 0){
				throw new Exception("Filme sem estoque");
			}
		}
		

		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(LocalDate.now());

		Double valor = 0d;

		for (Filme filme : filmes) {
			valor += filme.getPrecoLocacao();
		}

		locacao.setValor(valor);

		// Entrega no dia seguinte
		LocalDate dataEntrega = DataUtils.adicionarDias(LocalDate.now(), 1);

		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// TODO adicionar método para salvar no banco de dados

		return locacao;
	}

	// public static void main(String[] args) {
		
	// 	LocacaoService service = new LocacaoService();
	// 	Usuario usuario = new Usuario("Fulano"); 

	// 	Filme filme = new Filme("Filme 1", 5, 2.50);


	// 	Locacao locacao = service.alugarFilme(usuario, filme);

		
	// 	//verificação
	// 	System.out.println(locacao.getValor() == 2.50);
	// 	System.out.println(locacao.getFilme().getEstoque() == 5);
	// 	System.out.println(locacao.getDataLocacao());
	// 	System.out.println(locacao.getDataLocacao() == DataUtils.obterDataComDiferencaDias(1));

	// }

}