package com.OddinaryCosmo.UPV.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import com.OddinaryCosmo.UPV.Model.CategotiaModel;

public interface CategoriaRepository extends JpaRepository <CategotiaModel, Long> {
	public List<CategotiaModel>  findAllByCategoriaContainingIgnoreCase(@Param("categoria") String categoria);
}
