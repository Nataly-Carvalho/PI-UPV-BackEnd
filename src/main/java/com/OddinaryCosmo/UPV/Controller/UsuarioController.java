package com.OddinaryCosmo.UPV.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OddinaryCosmo.UPV.Model.UsuarioLogin;
import com.OddinaryCosmo.UPV.Model.UsuarioModel;

import com.OddinaryCosmo.UPV.Repository.UsuarioRepository;

import com.OddinaryCosmo.UPV.Service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@GetMapping("/all")
	public ResponseEntity <List<UsuarioModel>>getAll(){
		
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> getByid(@PathVariable Long id){
		
		return usuarioRepository.findById(id)
				.map(resposta -> ResponseEntity.ok (resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> login(@RequestBody Optional<UsuarioLogin> usuarioLogin){
		return usuarioService.autenticarUsuario(usuarioLogin)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		}
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModel> postUsuario(@Valid @RequestBody UsuarioModel usuario){
		return usuarioService.cadastrarUsuario(usuario)
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	@PutMapping("/atualizar")
	public ResponseEntity<UsuarioModel> putUsuario(@Valid @RequestBody UsuarioModel usuario){
		return usuarioService.atualizarUsuario(usuario)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
}
	