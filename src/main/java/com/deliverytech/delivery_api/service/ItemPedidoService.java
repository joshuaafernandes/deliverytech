package com.deliverytech.delivery_api.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliverytech.delivery_api.dto.responses.ItemPedidoResponseDTO;
import com.deliverytech.delivery_api.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository repository;
    private final ModelMapper mapper;

    public ItemPedidoService(ItemPedidoRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    
    }

    @Transactional(readOnly = true)
    public Page<ItemPedidoResponseDTO> listarPorPedido(Long pedidoId, Pageable pageable){
        return repository.findByPedidoId(pedidoId, pageable)
        .map(item -> mapper.map(item, ItemPedidoResponseDTO.class));
    }
}