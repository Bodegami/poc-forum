package br.com.bodegami.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bodegami.forum.controller.dto.TopicoDto;
import br.com.bodegami.forum.modelo.Curso;
import br.com.bodegami.forum.modelo.Topico;

@RestController
public class TopicoController {

	@ResponseBody
	@RequestMapping("/topicos")
	public List<TopicoDto> lista() {
		Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));	
	}
	
}
