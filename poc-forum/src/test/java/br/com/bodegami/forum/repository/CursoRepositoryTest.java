package br.com.bodegami.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.bodegami.forum.modelo.Curso;

/*
	Por padrão o Spring considera que quando você vai fazer tests na camada 
	repository voce vai usar banco de dados em memoria.
	Para fazer testes com outros bancos de dados como MySql, Oracle e etc,
	você deve usar a anotacao:
	@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
*/
@DataJpaTest
@ActiveProfiles("test")
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programação");
		em.persist(html5);
		
		
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
