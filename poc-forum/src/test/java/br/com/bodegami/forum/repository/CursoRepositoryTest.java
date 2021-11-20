package br.com.bodegami.forum.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.bodegami.forum.modelo.Curso;

@DataJpaTest
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		
		Curso curso = repository.findByNome(nomeCurso);
		
		Assertions.assertNotNull(curso);
		Assertions.assertEquals(nomeCurso, curso.getNome());

	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
		String nomeCurso = "JPA";
		
		Curso curso = repository.findByNome(nomeCurso);
		
		Assertions.assertNull(curso);

	}

}
