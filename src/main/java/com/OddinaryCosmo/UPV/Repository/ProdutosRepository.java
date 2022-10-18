package com.OddinaryCosmo.UPV.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.OddinaryCosmo.UPV.Model.ProdutosModel;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
	public List<ProdutosModel> findAllByNomeContainingIgnoreCase(@Param("nome")String nome);

}
