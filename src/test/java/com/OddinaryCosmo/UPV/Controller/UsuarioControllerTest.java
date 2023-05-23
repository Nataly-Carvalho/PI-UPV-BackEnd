package com.OddinaryCosmo.UPV.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.OddinaryCosmo.UPV.Model.UsuarioModel;
import com.OddinaryCosmo.UPV.Repository.UsuarioRepository;
import com.OddinaryCosmo.UPV.Service.UsuarioService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		
		usuarioService.cadastrarUsuario(new UsuarioModel(0L, 
				"Root","root", "root@root.com", "rootroot","","", "12345678900" , "12345678910", "asd","12","12","12345678", "aaa","ssss", "aaaa" ));
	}
	
	@Test
	@DisplayName("Cadastrar Um Usuario")
	public void deveCriarUmUsuario() {
		
		HttpEntity<UsuarioModel> corpoRequisicao = new HttpEntity<UsuarioModel>(new UsuarioModel(0L, "Root1","root1", "root1@root.com", "rootroot1", " ", "", "12345678900","123456789", "asd","12","12","12345678" ,"aaa","ssss", "aaaa"));
		ResponseEntity<UsuarioModel> corpoResposta = testRestTemplate
			.exchange("/usuarios/cadastrar", HttpMethod.POST, corpoRequisicao, UsuarioModel.class);
		
		assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
		assertEquals(corpoRequisicao.getBody().getNome(), corpoResposta.getBody().getNome());
		assertEquals(corpoRequisicao.getBody().getUsuario(), corpoResposta.getBody().getUsuario());
		
	}
	
	@Test
	@DisplayName("Não deve permitir duplicação do Usuario")
	public void naoDeveDuplicarUsuario() {
		
		usuarioService.cadastrarUsuario(new UsuarioModel (0L,
				"Root2","root2", "root2@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
		
		HttpEntity<UsuarioModel> corpoRequisicao = new HttpEntity<UsuarioModel>(new UsuarioModel (0L,
				"Root3","root3", "root3@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
		
		ResponseEntity<UsuarioModel> corpoResposta =  testRestTemplate
				.exchange("/usuarios/cadastrar",HttpMethod.POST, corpoRequisicao, UsuarioModel.class);
		
		assertEquals(HttpStatus.BAD_REQUEST, corpoResposta.getStatusCode());
	}
	
	@Test
	@DisplayName("Atualizar um usuario")
	
	public void deveAtualizarUmUsuario() {
		
		Optional<UsuarioModel> usuarioCadastrado = usuarioService.cadastrarUsuario(new UsuarioModel(0L,
				"Root4","root5", "root4@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
		
		UsuarioModel usuarioUpdate = new UsuarioModel(usuarioCadastrado.get().getId(),
				"Root","root", "root@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa");
		
		
		HttpEntity<UsuarioModel> corpoRequisicao = new HttpEntity<UsuarioModel>(usuarioUpdate);
		ResponseEntity<UsuarioModel>corpoResposta = testRestTemplate
				.withBasicAuth("root@root.com", "rootroot")
				.exchange("/usuarios/atualizar", HttpMethod.PUT, corpoRequisicao, UsuarioModel.class);
		
		assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());
		assertEquals(corpoRequisicao.getBody().getNome(), corpoResposta.getBody().getNome());
		assertEquals(corpoRequisicao.getBody().getUsuario(), corpoResposta.getBody().getUsuario());
	}
	
	@Test 
	@DisplayName("Listar todos os usuarios")
	public void deveMostrarTodosUsuarios() {
		usuarioService.cadastrarUsuario(new UsuarioModel(0L, 
				"Root","root", "root@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
		
		usuarioService.cadastrarUsuario(new UsuarioModel(0L, 
				"Root","root", "root@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
		
		ResponseEntity<String> resposta = testRestTemplate
				.withBasicAuth("root@root.com", "rootroot")
				.exchange("/usuarios/all", HttpMethod.GET,null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
}
