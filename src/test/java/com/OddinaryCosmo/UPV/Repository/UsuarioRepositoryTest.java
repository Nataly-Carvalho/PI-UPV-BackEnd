package com.OddinaryCosmo.UPV.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.OddinaryCosmo.UPV.Model.UsuarioModel;

@SpringBootTest(webEnvironment =  WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll(null);
		
		usuarioRepository.save(new UsuarioModel(0L,"Root","root", "root@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
		
		usuarioRepository.save(new UsuarioModel(0L,"Root","root", "root@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
		
		usuarioRepository.save(new UsuarioModel(0L,"Root","root", "root@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
		
		usuarioRepository.save(new UsuarioModel(0L,"Root","root", "root@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
		
		usuarioRepository.save(new UsuarioModel(0L,"Root","root", "root@root.com", "rootroot", " ", "", "12345678900","123456789", "asd","12","12","12345678","aaa","ssss", "aaaa"));
	}
	
	@Test
	@DisplayName("Retornar 1 usuario")
	public void deveRetornarUmUsuario() {
		Optional<UsuarioModel> usuario = usuarioRepository.findByUsuario("maria@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("maria@email.com.br"));
	}
	
	@Test
	@DisplayName("Retornar 3 usuario")
	public void deveRetornarTresUsuarios() {
		List<UsuarioModel> listadeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("silva");
		assertEquals(3, listadeUsuarios.size());
		assertTrue(listadeUsuarios.get(0).getNome().equals("Adriana silva"));
		assertTrue(listadeUsuarios.get(1).getNome().equals("juliana silva"));
		assertTrue(listadeUsuarios.get(2).getNome().equals("Paulo silva"));
		
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}

	
	

}
