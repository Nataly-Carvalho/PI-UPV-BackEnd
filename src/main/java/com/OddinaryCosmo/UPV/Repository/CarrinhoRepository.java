package com.OddinaryCosmo.UPV.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.OddinaryCosmo.UPV.Model.CarrinhoModel;


@Repository
public interface CarrinhoRepository  extends JpaRepository<CarrinhoModel, Long> {
	public Optional<CarrinhoModel> findById(@Param("id")Long id);
	 
}
