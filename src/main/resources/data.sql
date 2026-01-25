-- Clientes
INSERT INTO clientes (nome, email, telefone, endereco, data_cadastro, ativo) VALUES
('João Silva', 'joao.silva@email.com', '(11) 98765-4321', 'Rua das Flores, 123 - São Paulo, SP', CURRENT_TIMESTAMP, true),
('Maria Santos', 'maria.santos@email.com', '(11) 97654-3210', 'Av. Paulista, 1000 - São Paulo, SP', CURRENT_TIMESTAMP, true),
('Pedro Oliveira', 'pedro.oliveira@email.com', '(11) 96543-2109', 'Rua Augusta, 500 - São Paulo, SP', CURRENT_TIMESTAMP, true),
('Ana Costa', 'ana.costa@email.com', '(11) 95432-1098', 'Rua Consolação, 789 - São Paulo, SP', CURRENT_TIMESTAMP, true),
('Carlos Ferreira', 'carlos.ferreira@email.com', '(11) 94321-0987', 'Av. Faria Lima, 2000 - São Paulo, SP', CURRENT_TIMESTAMP, true);

-- Restaurantes
INSERT INTO restaurantes (nome, categoria, endereco, telefone, avaliacao, taxa_entrega, ativo) VALUES
('Pizzaria Bella Italia', 'Italiana', 'Rua dos Italianos, 456 - São Paulo, SP', '(11) 3456-7890', 4.8, 5.00, true),
('Sushi Master', 'Japonesa', 'Av. Liberdade, 789 - São Paulo, SP', '(11) 3456-7891', 4.9, 7.50, true),
('Burger House', 'Fast Food', 'Rua das Hamburgers, 321 - São Paulo, SP', '(11) 3456-7892', 4.5, 4.00, true),
('Churrascaria Gaúcha', 'Brasileira', 'Av. Brigadeiro, 1500 - São Paulo, SP', '(11) 3456-7893', 4.7, 8.00, true),
('Café Gourmet', 'Cafeteria', 'Rua dos Cafés, 654 - São Paulo, SP', '(11) 3456-7894', 4.6, 3.50, true);

-- Produtos da Pizzaria Bella Italia (restaurante_id = 1)
INSERT INTO produtos (nome, descricao, categoria, preco, disponivel, restaurante_id) VALUES
('Pizza Margherita', 'Pizza tradicional com molho de tomate, mussarela e manjericão', 'Pizza', 35.90, true, 1),
('Pizza Quatro Queijos', 'Pizza com mussarela, gorgonzola, parmesão e provolone', 'Pizza', 42.90, true, 1),
('Pizza Calabresa', 'Pizza com calabresa, cebola e azeitonas', 'Pizza', 38.90, true, 1),
('Lasanha à Bolonhesa', 'Lasanha tradicional com molho bolonhesa e queijo', 'Massas', 45.90, true, 1),
('Risotto de Camarão', 'Risotto cremoso com camarões frescos', 'Massas', 52.90, true, 1);

-- Produtos do Sushi Master (restaurante_id = 2)
INSERT INTO produtos (nome, descricao, categoria, preco, disponivel, restaurante_id) VALUES
('Combinado Sushi', '10 peças de sushi variado com sashimi', 'Sushi', 65.90, true, 2),
('Temaki de Salmão', 'Temaki recheado com salmão fresco e cream cheese', 'Temaki', 18.90, true, 2),
('Sashimi de Atum', '8 fatias de atum fresco', 'Sashimi', 42.90, true, 2),
('Hot Roll', '8 unidades de hot roll com salmão grelhado', 'Hot Roll', 38.90, true, 2),
('Combinado Especial', '15 peças de sushi premium com sashimi e temaki', 'Sushi', 89.90, true, 2);

-- Produtos do Burger House (restaurante_id = 3)
INSERT INTO produtos (nome, descricao, categoria, preco, disponivel, restaurante_id) VALUES
('Cheeseburger Clássico', 'Hambúrguer com queijo, alface, tomate e molho especial', 'Hambúrguer', 24.90, true, 3),
('Bacon Burger', 'Hambúrguer com bacon crocante, queijo e cebola caramelizada', 'Hambúrguer', 29.90, true, 3),
('Chicken Burger', 'Hambúrguer de frango grelhado com molho barbecue', 'Hambúrguer', 26.90, true, 3),
('Batata Frita', 'Porção de batata frita crocante', 'Acompanhamento', 12.90, true, 3),
('Onion Rings', 'Anéis de cebola empanados', 'Acompanhamento', 14.90, true, 3);

-- Produtos da Churrascaria Gaúcha (restaurante_id = 4)
INSERT INTO produtos (nome, descricao, categoria, preco, disponivel, restaurante_id) VALUES
('Picanha na Chapa', 'Picanha grelhada na chapa com arroz e farofa', 'Carnes', 68.90, true, 4),
('Costela Assada', 'Costela bovina assada lentamente', 'Carnes', 58.90, true, 4),
('Alcatra Grelhada', 'Alcatra grelhada com batata frita', 'Carnes', 54.90, true, 4),
('Salada Caesar', 'Salada fresca com molho caesar', 'Saladas', 22.90, true, 4),
('Feijão Tropeiro', 'Feijão tropeiro tradicional', 'Acompanhamento', 15.90, true, 4);

-- Produtos do Café Gourmet (restaurante_id = 5)
INSERT INTO produtos (nome, descricao, categoria, preco, disponivel, restaurante_id) VALUES
('Cappuccino', 'Cappuccino tradicional com espuma de leite', 'Bebidas', 8.90, true, 5),
('Croissant de Chocolate', 'Croissant recheado com chocolate belga', 'Doces', 12.90, true, 5),
('Sanduíche Natural', 'Sanduíche com peito de peru, queijo e vegetais', 'Sanduíches', 18.90, true, 5),
('Torta de Limão', 'Fatia de torta de limão caseira', 'Doces', 14.90, true, 5),
('Açaí com Granola', 'Açaí cremoso com granola e mel', 'Sobremesas', 16.90, true, 5);

-- Pedidos
INSERT INTO pedidos (data_pedido, endereco_entrega, numero_pedido, taxa_entrega, valor_total, status, cliente_id, restaurante_id) VALUES
(CURRENT_TIMESTAMP, 'Rua das Flores, 123 - São Paulo, SP', 'PED-001', 5.00, 80.80, 'CONFIRMADO', 1, 1),
(CURRENT_TIMESTAMP, 'Av. Paulista, 1000 - São Paulo, SP', 'PED-002', 7.50, 84.80, 'PENDENTE', 2, 2),
(CURRENT_TIMESTAMP, 'Rua Augusta, 500 - São Paulo, SP', 'PED-003', 4.00, 37.80, 'ENTREGUE', 3, 3),
(CURRENT_TIMESTAMP, 'Rua Consolação, 789 - São Paulo, SP', 'PED-004', 8.00, 76.90, 'CONFIRMADO', 4, 4),
(CURRENT_TIMESTAMP, 'Av. Faria Lima, 2000 - São Paulo, SP', 'PED-005', 3.50, 31.80, 'PENDENTE', 5, 5);


-- Itens do Pedido 1 (Pizzaria Bella Italia)
INSERT INTO itens_pedido (quantidade, preco_unitario, subtotal, produto_id, pedido_id) VALUES
(1, 35.90, 35.90, 1, 1),
(1, 42.90, 42.90, 2, 1);

-- Itens do Pedido 2 (Sushi Master)
INSERT INTO itens_pedido (quantidade, preco_unitario, subtotal, produto_id, pedido_id) VALUES
(1, 65.90, 65.90, 6, 2),
(1, 18.90, 18.90, 7, 2);

-- Itens do Pedido 3 (Burger House)
INSERT INTO itens_pedido (quantidade, preco_unitario, subtotal, produto_id, pedido_id) VALUES
(1, 24.90, 24.90, 11, 3),
(1, 12.90, 12.90, 14, 3);

-- Itens do Pedido 4 (Churrascaria Gaúcha)
INSERT INTO itens_pedido (quantidade, preco_unitario, subtotal, produto_id, pedido_id) VALUES
(1, 68.90, 68.90, 16, 4);

-- Itens do Pedido 5 (Café Gourmet)
INSERT INTO itens_pedido (quantidade, preco_unitario, subtotal, produto_id, pedido_id) VALUES
(2, 8.90, 17.80, 21, 5),
(1, 12.90, 12.90, 22, 5);
