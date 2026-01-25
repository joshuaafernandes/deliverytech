package com.deliverytech.delivery_api.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliverytech.delivery_api.model.ItemPedido;
import com.deliverytech.delivery_api.model.Pedido;
import com.deliverytech.delivery_api.model.Produto;
import com.deliverytech.delivery_api.repository.ItemPedidoRepository;
import com.deliverytech.delivery_api.repository.PedidoRepository;
import com.deliverytech.delivery_api.repository.ProdutoRepository;

@Service
@Transactional
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository, 
                             PedidoRepository pedidoRepository,
                             ProdutoRepository produtoRepository){
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<ItemPedido> listarTodos(){
        return itemPedidoRepository.findAll();
    }

    public List<ItemPedido> listarPorPedido(Long pedidoId){
        return itemPedidoRepository.findByPedidoId(pedidoId);
    }

    public List<ItemPedido> listarPorProduto(Long produtoId){
        return itemPedidoRepository.findByProdutoId(produtoId);
    }
    
    public ItemPedido buscarPorId(Long id){
        return itemPedidoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Item do pedido não encontrado"));
    }

    public ItemPedido cadastrarItem(Long pedidoId, Long produtoId, Integer quantidade){
        Pedido pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));

        Produto produto = produtoRepository.findById(produtoId)
            .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));

        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        ItemPedido item = new ItemPedido();
        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(quantidade);
        item.setPrecoUnitario(produto.getPreco());

        BigDecimal subtotal = produto.getPreco()
            .multiply(BigDecimal.valueOf(quantidade));
        item.setSubtotal(subtotal);

        ItemPedido itemSalvo = itemPedidoRepository.save(item);

        BigDecimal valorAtual = pedido.getValorTotal() != null ? pedido.getValorTotal() : BigDecimal.ZERO;
        pedido.setValorTotal(valorAtual.add(subtotal));
        pedidoRepository.save(pedido);

        return itemSalvo;
    }

    public void deletarItem(Long id){
        ItemPedido item = itemPedidoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Item do pedido não encontrado"));

        Pedido pedido = item.getPedido();
        
        BigDecimal valorAtual = pedido.getValorTotal() != null ? pedido.getValorTotal() : BigDecimal.ZERO;
        BigDecimal novoValor = valorAtual.subtract(item.getSubtotal());
        pedido.setValorTotal(novoValor.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : novoValor);
        
        itemPedidoRepository.delete(item);
        pedidoRepository.save(pedido);
    }

    public ItemPedido salvarItemPedido(ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }       
}