package com.deliverytech.delivery_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deliverytech.delivery_api.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    
    @Query(value = """
        SELECT i FROM ItemPedido i 
        JOIN FETCH i.produto 
        WHERE i.pedido.id = :pedidoId
        """, 
        countQuery = "SELECT count(i) FROM ItemPedido i WHERE i.pedido.id = :pedidoId")
    Page<ItemPedido> findByPedidoId(@Param("pedidoId") Long pedidoId, Pageable pageable);
    
    Page<ItemPedido> findByProdutoId(Long produtoId, Pageable pageable);
}