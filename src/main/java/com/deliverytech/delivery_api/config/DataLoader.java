package com.deliverytech.delivery_api.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.deliverytech.delivery_api.enums.StatusPedidos;
import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.model.ItemPedido;
import com.deliverytech.delivery_api.model.Pedido;
import com.deliverytech.delivery_api.model.Produto;
import com.deliverytech.delivery_api.model.Restaurante;
import com.deliverytech.delivery_api.repository.ClienteRepository;
import com.deliverytech.delivery_api.repository.ItemPedidoRepository;
import com.deliverytech.delivery_api.repository.PedidoRepository;
import com.deliverytech.delivery_api.repository.ProdutoRepository;
import com.deliverytech.delivery_api.repository.RestauranteRepository;

@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner initData(
            ClienteRepository clienteRepository,
            RestauranteRepository restauranteRepository,
            ProdutoRepository produtoRepository,
            PedidoRepository pedidoRepository,
            ItemPedidoRepository itemPedidoRepository) {
        return args -> {
            System.out.println("Iniciando carregamento de dados...");

            Cliente cliente1 = new Cliente();
            cliente1.setNome("Maria Santos");
            cliente1.setEmail("mariasantos@gmail.com");
            cliente1.setTelefone("11987654321");
            cliente1.setEndereco("Av. Paulista, 1000 - São Paulo, SP");
            cliente1.setAtivo(true);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Carlos Oliveira");
            cliente2.setEmail("carlosoliveira@gmail.com");
            cliente2.setTelefone("11912345678");
            cliente2.setEndereco("Rua das Palmeiras, 456 - São Paulo, SP");
            cliente2.setAtivo(true);

            Cliente cliente3 = new Cliente();
            cliente3.setNome("Ana Costa");
            cliente3.setEmail("anacosta@gmail.com");
            cliente3.setTelefone("11987654322");
            cliente3.setEndereco("Avenida Brasil, 321 - São Paulo, SP");
            cliente3.setAtivo(true);

            Cliente cliente4 = new Cliente();
            cliente4.setNome("Pedro Almeida");
            cliente4.setEmail("pedroalmeida@gmail.com");
            cliente4.setTelefone("11987654323");
            cliente4.setEndereco("Rua das Árvores, 101 - São Paulo, SP");
            cliente4.setAtivo(true);

            List<Cliente> clientes = new ArrayList<>();
            clientes.add(cliente1);
            clientes.add(cliente2);
            clientes.add(cliente3);
            clientes.add(cliente4);
            clienteRepository.saveAll(clientes);

            Restaurante r1 = new Restaurante();
            r1.setNome("Pizzaria Bella Italia");
            r1.setCategoria("Pizzaria");
            r1.setEndereco("Rua dos Italianos, 456 - São Paulo, SP");
            r1.setTelefone("1134567890");
            r1.setAvaliacao(new BigDecimal("4.8"));
            r1.setTaxaEntrega(new BigDecimal("5.00"));
            r1.setAtivo(true);

            Restaurante r2 = new Restaurante();
            r2.setNome("Sushi Master");
            r2.setCategoria("Japonesa");
            r2.setEndereco("Avenida Liberdade, 789 - São Paulo, SP");
            r2.setTelefone("11987654321");
            r2.setAvaliacao(new BigDecimal("4.9"));
            r2.setTaxaEntrega(new BigDecimal("7.50"));
            r2.setAtivo(true);

            Restaurante r3 = new Restaurante();
            r3.setNome("Burger House");
            r3.setCategoria("Hamburgueria");
            r3.setEndereco("Rua Augusta, 321 - São Paulo/SP");
            r3.setTelefone("11999998888");
            r3.setAvaliacao(new BigDecimal("4.5"));
            r3.setTaxaEntrega(new BigDecimal("4.00"));
            r3.setAtivo(true);

            Restaurante r4 = new Restaurante();
            r4.setNome("Churrascaria na Brasa");
            r4.setCategoria("Churrascaria");
            r4.setEndereco("Avenida Brasil, 987 - São Paulo, SP");
            r4.setTelefone("11987654324");
            r4.setAvaliacao(new BigDecimal("4.7"));
            r4.setTaxaEntrega(new BigDecimal("8.00"));
            r4.setAtivo(true);

            List<Restaurante> restaurantes = new ArrayList<>();
            restaurantes.add(r1);
            restaurantes.add(r2);
            restaurantes.add(r3);
            restaurantes.add(r4);
            restauranteRepository.saveAll(restaurantes);

            Produto p1 = new Produto();
            p1.setNome("Pizza Margherita");
            p1.setDescricao("Pizza tradicional com molho de tomate, mussarela e manjericão");
            p1.setCategoria("Pizza");
            p1.setPreco(new BigDecimal("35.90"));
            p1.setRestaurante(r1);
            p1.setDisponivel(true);

            Produto p2 = new Produto();
            p2.setNome("Combinado Sushi");
            p2.setDescricao("10 peças de sushi variado com sashimi");
            p2.setCategoria("Sushi");
            p2.setPreco(new BigDecimal("65.90"));
            p2.setRestaurante(r2);
            p2.setDisponivel(true);

            Produto p3 = new Produto();
            p3.setNome("Hambúrguer Clássico");
            p3.setDescricao("Hambúrguer com queijo, alface, tomate e molho especial");
            p3.setCategoria("Hambúrguer");
            p3.setPreco(new BigDecimal("25.50"));
            p3.setRestaurante(r3);
            p3.setDisponivel(true);

            Produto p4 = new Produto();
            p4.setNome("Picanha na Brasa");
            p4.setDescricao("Picanha suculenta grelhada na brasa, acompanhada de farofa e vinagrete");
            p4.setCategoria("Churrasco");
            p4.setPreco(new BigDecimal("89.90"));
            p4.setRestaurante(r4);
            p4.setDisponivel(true);

            List<Produto> produtos = new ArrayList<>();
            produtos.add(p1);
            produtos.add(p2);
            produtos.add(p3);
            produtos.add(p4);
            produtoRepository.saveAll(produtos);

            Pedido pedido1 = new Pedido();
            pedido1.setCliente(cliente1);
            pedido1.setRestaurante(r1);
            pedido1.setStatus(StatusPedidos.PENDENTE);
            pedido1.setEnderecoEntrega(cliente1.getEndereco());
            pedido1.setValorTotal(BigDecimal.ZERO);

            Pedido pedido2 = new Pedido();
            pedido2.setCliente(cliente2);
            pedido2.setRestaurante(r2);
            pedido2.setStatus(StatusPedidos.PENDENTE);
            pedido2.setEnderecoEntrega(cliente2.getEndereco());
            pedido2.setValorTotal(BigDecimal.ZERO);

            Pedido pedido3 = new Pedido();
            pedido3.setCliente(cliente3);
            pedido3.setRestaurante(r3);
            pedido3.setStatus(StatusPedidos.PENDENTE);
            pedido3.setEnderecoEntrega(cliente3.getEndereco());
            pedido3.setValorTotal(BigDecimal.ZERO);

            Pedido pedido4 = new Pedido();
            pedido4.setCliente(cliente4);
            pedido4.setRestaurante(r4);
            pedido4.setStatus(StatusPedidos.PENDENTE);
            pedido4.setEnderecoEntrega(cliente4.getEndereco());
            pedido4.setValorTotal(BigDecimal.ZERO);

            pedidoRepository.save(pedido1);
            pedidoRepository.save(pedido2);
            pedidoRepository.save(pedido3);
            pedidoRepository.save(pedido4);

            ItemPedido item1 = new ItemPedido();
            item1.setPedido(pedido1);
            item1.setProduto(p1);
            item1.setQuantidade(1);
            item1.setPrecoUnitario(p1.getPreco());
            item1.setSubtotal(p1.getPreco().multiply(BigDecimal.valueOf(item1.getQuantidade())));

            ItemPedido item2 = new ItemPedido();
            item2.setPedido(pedido2);
            item2.setProduto(p2);
            item2.setQuantidade(1);
            item2.setPrecoUnitario(p2.getPreco());
            item2.setSubtotal(p2.getPreco().multiply(BigDecimal.valueOf(item2.getQuantidade())));

            ItemPedido item3 = new ItemPedido();
            item3.setPedido(pedido3);
            item3.setProduto(p3);
            item3.setQuantidade(2);
            item3.setPrecoUnitario(p3.getPreco());
            item3.setSubtotal(p3.getPreco().multiply(BigDecimal.valueOf(item3.getQuantidade())));

            ItemPedido item4 = new ItemPedido();
            item4.setPedido(pedido4);
            item4.setProduto(p4);
            item4.setQuantidade(1);
            item4.setPrecoUnitario(p4.getPreco());
            item4.setSubtotal(p4.getPreco().multiply(BigDecimal.valueOf(item4.getQuantidade())));

            itemPedidoRepository.save(item1);
            itemPedidoRepository.save(item2);
            itemPedidoRepository.save(item3);
            itemPedidoRepository.save(item4);

            System.out.println("Dados carregados com sucesso!");

        };
    }

}