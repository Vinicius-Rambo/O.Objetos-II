package com.example.persistencia_lab;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.persistencia_lab.infrastructure.ConexaoFactory;
import com.example.persistencia_lab.models.Curso;
import com.example.persistencia_lab.models.Professor;
import com.example.persistencia_lab.repositories.ProfessorRepository;

@SpringBootTest
class PersistenciaLabApplicationTests {

	@Test
	void databaseTest() {
		ConexaoFactory.getConexao();
	} 

	@Test 
	public void deveObterUmProfessorPeloSeuId(){
		ProfessorRepository repository = new ProfessorRepository();
		
		Professor professor = repository.findProfessorById(1);

		System.out.println(professor);
	}

	@Test
	public void deveInserirUmProfessor(){
		ProfessorRepository repository = new ProfessorRepository();

		Curso curso = new Curso();
		curso.setCurso_id(1);

		Professor professor = new Professor();

		professor.setNome("John Doe");
		professor.setEmail("john@email.com");
		professor.setDataNascimento(LocalDate.of(1980, 11, 30));
		professor.setSalarioBase(500.00);

		professor.setCurso(curso);

		professor = repository.inserir(professor);

		System.out.println(professor);


	}

}
