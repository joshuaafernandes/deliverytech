package com.deliverytech.delivery_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.deliverytech.delivery_api.model.ItemPedido;
import com.deliverytech.delivery_api.repository.ItemPedidoRepository;


@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository){
        this.itemPedidoRepository = itemPedidoRepository;
    
    }

    public List<ItemPedido> listarPorPedido(Long pedidoId){
        return itemPedidoRepository.findByPedidoId(pedidoId);
    }
}