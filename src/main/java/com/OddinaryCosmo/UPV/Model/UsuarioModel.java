package com.OddinaryCosmo.UPV.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull(message = "O atrib(0L, \"Root\",\"root\", \"root@root.com\", \"rootroot\", \" \", \"\", \"12345678900\",\"123456789\", \"asd\",\"12\",\"12\",\"12345678\"));uto Nome é Obrigatorio")
		private String nome;
		
		@NotNull(message = "O atributo sobrenome é Obrigatorio")
		private String sobrenome;
		
		@Schema(example = "email@email.com.br")
		@NotNull(message = "O Atributo Usuário é Obrigatório")
		@Email(message = "O atributo Usuário deve ser um email valido")
		private String usuario;
		
		@NotBlank(message= "O atributo senha é Obrigatório")
		@Size(min=8, message = "A senha deve ter no minimo 8 caracteres")
		private String senha;
		
		@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
		private String foto;
		
		@NotBlank(message = "O atributo cep é Obrigatorio")
		private String tipo;
		
		@Size(min = 11, max= 11, message = "O CPF tem que ter no minimo 9 digitos e no maximo 9" )
		@NotBlank(message = "O atributo cpf é Obrigatorio")
		private String cpf;
		
		@Size(min = 11,max = 11, message = "O número tem que ter no maximo 11 caracteres e e no minimo 11")
		private String telefone;
		
		@NotBlank(message = "O atributo bairro é Obrigatorio")
		private String bairro;
		
		@NotBlank(message = "O atributo rua é Obrigatorio")
		private String rua;
		
		@NotBlank(message = "O atributo numero é Obrigatorio")
		private String numero;
		
		@NotBlank(message = "O atributo cep é Obrigatorio")
		@Size(min =8,max=8, message = "O atributo cep tem que ter no maximo e no minimo 8 caracteres")
		private String cep;
		
		private String complemento;
		
		@NotBlank(message = "O atributo cep é Obrigatorio")
		private String pais;
		
		@NotBlank(message = "O atributo cep é Obrigatorio")
		private String estado;
		
		@NotBlank(message = "O atributo cep é Obrigatorio")
		private String cidade;
		
		@NotBlank(message = "O atributo cep é Obrigatorio")
		public UsuarioModel(Long id, String nome, String usuario,String senha,String foto,String tipo, String cep,String cpf, String rua,String telefone,
				String numero, String complemento,String sobrenome, String cidade, String estado, String pais ) {
			this.id = id;
			this.nome = nome;
			this.usuario = usuario;
			this.senha = senha;
			this.foto = foto;
			this.tipo = tipo;
			this.cep = cep;
			this.numero = numero;
			this.telefone = telefone;
			this.complemento = complemento;
			this.rua = rua;
			this.cpf = cpf;
			this.sobrenome = sobrenome;
			this.cidade = cidade;
			this.estado = estado;
			this.pais = pais;
			
		}
		
		@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("usuario")
		private List<ProdutosModel> produtos;
		
		
		
		public String getSobrenome() {
			return sobrenome;
		}

		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public UsuarioModel() { }
		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public List<ProdutosModel> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<ProdutosModel> produtos) {
			this.produtos = produtos;
		}

		public String getPais() {
			return pais;
		}

		public void setPais(String pais) {
			this.pais = pais;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		

		
		
}
