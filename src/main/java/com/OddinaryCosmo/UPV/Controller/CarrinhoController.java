package com.OddinaryCosmo.UPV.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OddinaryCosmo.UPV.Model.ProdutosModel;
import com.OddinaryCosmo.UPV.Repository.CarrinhoRepository;
import com.OddinaryCosmo.UPV.Repository.ProdutosRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutosModel>> GetAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("meucarrinho/{id}")
	public ResponseEntity<ProdutosModel> GetById(@PathVariable Long id){
		return produtosRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("meucarrinho/nome/{nome}")
	public ResponseEntity<List<ProdutosModel>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	 @PostMapping
	 public ResponseEntity<ProdutosModel> post (@RequestBody ProdutosModel produtos){
		 return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos));
	 }
	 
	 @PutMapping
	 public ResponseEntity<ProdutosModel> put (@RequestBody ProdutosModel produtos){
		 return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produtos));
	 }
	 
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable Long id) {
		 carrinhoRepository.deleteById(id);
	 }
	

	
	

}
