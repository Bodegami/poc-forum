package br.com.bodegami.forum.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.bodegami.forum.modelo.Topico;
import br.com.bodegami.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {

	@NotBlank
	@Length(min = 5)
	private String titulo;

	@NotBlank
	@Length(min = 10)
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getById(id);
		topico.setTitulo(titulo);
		topico.setMensagem(this.mensagem);
		return topico;
	}

}
