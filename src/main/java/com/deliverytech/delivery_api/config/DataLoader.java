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
                        System.out.println("Carregando dados iniciais...");

                        Cliente cliente1 = new Cliente();
                        cliente1.setNome("João Silva");
                        cliente1.setEmail("joao.silva@email.com");
                        cliente1.setTelefone("(11) 98765-4321");
                        cliente1.setEndereco("Rua das Flores, 123 - São Paulo, SP");
                        cliente1.setAtivo(true);

                        Cliente cliente2 = new Cliente();
                        cliente2.setNome("Maria Santos");
                        cliente2.setEmail("maria.santos@email.com");
                        cliente2.setTelefone("(11) 97654-3210");
                        cliente2.setEndereco("Av. Paulista, 1000 - São Paulo, SP");
                        cliente2.setAtivo(true);

                        Cliente cliente3 = new Cliente();
                        cliente3.setNome("Carlos Oliveira");
                        cliente3.setEmail("carlos.oliveira@email.com");
                        cliente3.setTelefone("(11) 96543-2109");
                        cliente3.setEndereco("Rua das Palmeiras, 456 - São Paulo, SP");
                        cliente3.setAtivo(true);

                        Cliente cliente4 = new Cliente();
                        cliente4.setNome("Ana Costa");
                        cliente4.setEmail("ana.costa@email.com");
                        cliente4.setTelefone("(11) 95432-1098");
                        cliente4.setEndereco("Rua das Flores, 789 - São Paulo, SP");
                        cliente4.setAtivo(true);

                        Cliente cliente5 = new Cliente();
                        cliente5.setNome("Pedro Almeida");
                        cliente5.setEmail("pedro.almeida@email.com");
                        cliente5.setTelefone("(11) 94321-0987");
                        cliente5.setEndereco("Av. Brasil, 321 - São Paulo, SP");
                        cliente5.setAtivo(true);

                        List<Cliente> clientes = new ArrayList<>();
                        clientes.add(cliente1);
                        clientes.add(cliente2);
                        clientes.add(cliente3);
                        clientes.add(cliente4);
                        clientes.add(cliente5);
                        clienteRepository.saveAll(clientes);

                        Restaurante r1 = new Restaurante();
                        r1.setNome("Pizzaria Bella Italia");
                        r1.setCategoria("Italiana");
                        r1.setEndereco("Rua dos Italianos, 456 - São Paulo, SP");
                        r1.setTelefone("(11) 3456-7890");
                        r1.setAvaliacao(new BigDecimal("4.8"));
                        r1.setTaxaEntrega(new BigDecimal("5.00"));
                        r1.setAtivo(true);

                        Restaurante r2 = new Restaurante();
                        r2.setNome("Sushi Master");
                        r2.setCategoria("Japonesa");
                        r2.setEndereco("Av. Liberdade, 789 - São Paulo, SP");
                        r2.setTelefone("(11) 3456-7891");
                        r2.setAvaliacao(new BigDecimal("4.9"));
                        r2.setTaxaEntrega(new BigDecimal("7.50"));
                        r2.setAtivo(true);

                        Restaurante r3 = new Restaurante();
                        r3.setNome("Burger House");
                        r3.setCategoria("Fast Food");
                        r3.setEndereco("Rua do Hambúrguer, 321 - São Paulo, SP");
                        r3.setTelefone("(11) 3456-7892");
                        r3.setAvaliacao(new BigDecimal("4.5"));
                        r3.setTaxaEntrega(new BigDecimal("4.00"));
                        r3.setAtivo(true);

                        Restaurante r4 = new Restaurante();
                        r4.setNome("Veggie Delight");
                        r4.setCategoria("Vegetariana");
                        r4.setEndereco("Av. Verde, 654 - São Paulo, SP");
                        r4.setTelefone("(11) 3456-7893");
                        r4.setAvaliacao(new BigDecimal("4.7"));
                        r4.setTaxaEntrega(new BigDecimal("6.00"));
                        r4.setAtivo(true);

                        Restaurante r5 = new Restaurante();
                        r5.setNome("Churrascaria Boi na Brasa");
                        r5.setCategoria("Churrasco");
                        r5.setEndereco("Rua do Churrasco, 987 - São Paulo, SP");
                        r5.setTelefone("(11) 3456-7894");
                        r5.setAvaliacao(new BigDecimal("4.6"));
                        r5.setTaxaEntrega(new BigDecimal("8.00"));
                        r5.setAtivo(true);

                        List<Restaurante> restaurantes = new ArrayList<>();
                        restaurantes.add(r1);
                        restaurantes.add(r2);
                        restaurantes.add(r3);
                        restaurantes.add(r4);
                        restaurantes.add(r5);
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
                        p4.setNome("Salada Veggie");
                        p4.setDescricao("Salada fresca com mix de folhas, tomate, pepino e molho vinagrete");
                        p4.setCategoria("Salada");
                        p4.setPreco(new BigDecimal("22.00"));
                        p4.setRestaurante(r4);
                        p4.setDisponivel(true);

                        Produto p5 = new Produto();
                        p5.setNome("Picanha na Brasa");
                        p5.setDescricao("Picanha suculenta grelhada na brasa, acompanhada de farofa e vinagrete");
                        p5.setCategoria("Churrasco");
                        p5.setPreco(new BigDecimal("89.90"));
                        p5.setRestaurante(r5);
                        p5.setDisponivel(true);

                        List<Produto> produtos = new ArrayList<>();
                        produtos.add(p1);
                        produtos.add(p2);
                        produtos.add(p3);
                        produtos.add(p4);
                        produtos.add(p5);
                        produtoRepository.saveAll(produtos);

                        Pedido pedido1 = new Pedido();
                        pedido1.setCliente(cliente1);
                        pedido1.setRestaurante(r1);
                        pedido1.setStatus(StatusPedidos.PENDENTE);
                        pedido1.setEnderecoEntrega(cliente1.getEndereco());
                        pedido1.setValorTotal(new BigDecimal("35.90"));

                        Pedido pedido2 = new Pedido();
                        pedido2.setCliente(cliente2);
                        pedido2.setRestaurante(r2);
                        pedido2.setStatus(StatusPedidos.PENDENTE);
                        pedido2.setEnderecoEntrega(cliente2.getEndereco());
                        pedido2.setValorTotal(new BigDecimal("65.90"));

                        Pedido pedido3 = new Pedido();
                        pedido3.setCliente(cliente1);
                        pedido3.setRestaurante(r3);
                        pedido3.setStatus(StatusPedidos.PENDENTE);
                        pedido3.setEnderecoEntrega(cliente1.getEndereco());
                        pedido3.setValorTotal(new BigDecimal("25.50"));

                        Pedido pedido4 = new Pedido();
                        pedido4.setCliente(cliente2);
                        pedido4.setRestaurante(r4);
                        pedido4.setStatus(StatusPedidos.PENDENTE);
                        pedido4.setEnderecoEntrega(cliente2.getEndereco());
                        pedido4.setValorTotal(new BigDecimal("22.00"));

                        Pedido pedido5 = new Pedido();
                        pedido5.setCliente(cliente1);
                        pedido5.setRestaurante(r5);
                        pedido5.setStatus(StatusPedidos.PENDENTE);
                        pedido5.setEnderecoEntrega(cliente1.getEndereco());
                        pedido5.setValorTotal(new BigDecimal("89.90"));

                        pedidoRepository.save(pedido1);
                        pedidoRepository.save(pedido2);
                        pedidoRepository.save(pedido3);
                        pedidoRepository.save(pedido4);
                        pedidoRepository.save(pedido5);

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

                        itemPedidoRepository.save(item1);
                        itemPedidoRepository.save(item2);

                        System.out.println("Dados carregados com sucesso!");

                        // =====================================================
                        //                       CONSULTAS
                        // =====================================================

                        System.out.println("\n===== TESTANDO CONSULTAS =====\n");

                        System.out.println("➡ Clientes ativos:");
                        clienteRepository.findByAtivoTrue()
                                        .forEach(c -> System.out.println(" - " + c.getNome()));


                        System.out.println("\n➡ Buscar por email:");
                        clienteRepository.findByEmail("ana.costa@email.com")
                                        .ifPresent(c -> System.out.println("Encontrado: " + c.getNome()));


                        System.out.println("\n➡ Restaurantes Japoneses:");
                        restauranteRepository.findByCategoria("Japonesa")
                                        .forEach(r -> System.out.println(" - " + r.getNome()));


                        System.out.println("\n➡ Restaurantes com taxa <= 6:");
                        restauranteRepository
                                        .findByTaxaEntregaLessThanEqual(new BigDecimal("6"))
                                        .forEach(r -> System.out.println(" - " + r.getNome()));


                        System.out.println("\n➡ Produtos disponíveis:");
                        produtoRepository.findByDisponivelTrue()
                                        .forEach(p -> System.out.println(" - " + p.getNome()));


                        System.out.println("\n➡ Produtos da Pizzaria:");
                        produtoRepository
                                        .findByRestauranteId(r1.getId())
                                        .forEach(p -> System.out.println(" - " + p.getNome()));


                        System.out.println("\n➡ Produtos até R$30:");
                        produtoRepository
                                        .findByPrecoLessThanEqual(new BigDecimal("30"))
                                        .forEach(p -> System.out.println(" - " + p.getNome()));


                        System.out.println("\n➡ Pedidos PENDENTES:");
                        pedidoRepository.findByStatus(StatusPedidos.PENDENTE)
                                        .forEach(p -> System.out.println(" - Pedido #" + p.getId()));


                        System.out.println("\n➡ Pedidos do João:");
                        pedidoRepository
                                        .findByClienteId(cliente1.getId())
                                        .forEach(p -> System.out.println(" - Pedido #" + p.getId()));
                                        

                        System.out.println("\n➡ Últimos pedidos:");
                        pedidoRepository
                                        .findTop10ByOrderByDataPedidoDesc()
                                        .forEach(p -> System.out.println(" - " + p.getId()));

                        System.out.println("\n===== FIM DOS TESTES =====\n");

                };
        }

};