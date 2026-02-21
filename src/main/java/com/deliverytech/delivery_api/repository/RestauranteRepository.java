package com.deliverytech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
        Page<Restaurante> findByCategoria(String categoria, Pageable pageable);

        Page<Restaurante> findByAtivoTrue(Pageable pageable);

        List<Restaurante> findByAtivoTrueOrderByAvaliacaoDesc();

        List<Restaurante> findByNomeContainingIgnoreCase(String nome);

        Page<Restaurante> findByCategoriaAndAtivoTrue(String categoria, Pageable pageable);

        List<Restaurante> findByTaxaEntregaLessThanEqual(BigDecimal taxa);

        List<Restaurante> findTop5ByOrderByNomeAsc();

        boolean existsByNome(String nome);

}
