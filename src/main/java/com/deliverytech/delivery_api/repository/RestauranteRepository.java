package com.deliverytech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
        List<Restaurante> findByCategoria(String categoria);

        List<Restaurante> findByAtivoTrue();

        List<Restaurante> findByAtivoTrueOrderByAvaliacaoDesc();

        List<Restaurante> findByNomeContainingIgnoreCase(String nome);

        List<Restaurante> findByCategoriaAndAtivoTrue(String categoria);

        List<Restaurante> findByTaxaEntregaLessThanEqual(BigDecimal taxa);

        List<Restaurante> findTop5ByOrderByNomeAsc();

        boolean existsByNome(String nome);

}
