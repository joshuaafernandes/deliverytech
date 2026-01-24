package com.deliverytech.delivery_api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.model.ItemPedido;
import com.deliverytech.delivery_api.service.ItemPedidoService;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping
    public List<ItemPedido> listarTodos() {
        return itemPedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ItemPedido buscarPorId(@PathVariable Long id) {
        return itemPedidoService.buscarPorId(id);
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<ItemPedido> listarPorPedido(@PathVariable Long pedidoId) {
        return itemPedidoService.listarPorPedido(pedidoId);
    }

    @GetMapping("/produto/{produtoId}")
    public List<ItemPedido> listarPorProduto(@PathVariable Long produtoId) {
        return itemPedidoService.listarPorProduto(produtoId);
    }

    @PostMapping
    public ResponseEntity<ItemPedido> cadastrarItem(
            @RequestParam Long pedidoId, 
            @RequestParam Long produtoId, 
            @RequestParam Integer quantidade) {
        ItemPedido item = itemPedidoService.cadastrarItem(pedidoId, produtoId, quantidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable Long id) {
        itemPedidoService.deletarItem(id);
        return ResponseEntity.noContent().build();
    }
}