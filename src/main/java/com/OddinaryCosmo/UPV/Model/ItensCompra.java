package com.OddinaryCosmo.UPV.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_compra")
public class ItensCompra implements Serializable {


	private static final long sriealVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private ProdutosModel produto;
	@ManyToOne
	private compraModel compra;
	
	private Integer quantidade = 0;
	
	private Double valorProduto;
	
	private Double valorTotal=0.;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProdutosModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutosModel produto) {
		this.produto = produto;
	}

	public compraModel getCompra() {
		return compra;
	}

	public void setCompra(compraModel compra) {
		this.compra = compra;
	}

	public Integer getQuantidade() {
		
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
