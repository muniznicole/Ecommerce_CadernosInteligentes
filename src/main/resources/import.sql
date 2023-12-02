-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- CRUDS ANDRÉ
insert into estado (nomeEstadoCompleto,abreviado) values('Tocantins','TO');
insert into estado (nomeEstadoCompleto,abreviado) values('Goiás','GO');
insert into estado (nomeEstadoCompleto,abreviado) values('Rio de Janeiro','RJ');

insert into cidade (nomeCidade,id_estado) values('Palmas',1);
insert into cidade (nomeCidade,id_estado) values('Paraiso',1);
insert into cidade (nomeCidade,id_estado) values('Colinas',1);

insert into endereco (quadra,alameda,complemento,numero,cep,id_cidade) values('vale do sol','rua bois bravos','casa de esquina muro azul','05','12345',1);
insert into endereco (quadra,alameda,complemento,numero,cep,id_cidade) values('Centro','rua bois bravos','casa de esquina muro azul','05','12345',1);
insert into endereco (quadra,alameda,complemento,numero,cep,id_cidade) values('Borte','rua bois bravos','casa de esquina muro azul','05','12345',1);

insert into usuario (nomeCompleto,cpf,login,telefone,email,senha,perfil) values('André Barreira de Catro','1234556','Quico','63985139583','andreghoul18@gmail.com','yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==','ADMIN');
insert into usuario (nomeCompleto,cpf,login,telefone,email,senha,perfil) values('Neuma Barreira de Catro','1234556','Quico','63985139583','andreghoul18@gmail.com','1234567','CLIENTE');
insert into usuario (nomeCompleto,cpf,login,telefone,email,senha,perfil) values('Ivan Barreira de Catro','1234556','Quico','63985139583','andreghoul18@gmail.com','123456','ADMIN');
insert into usuario (nomeCompleto,cpf,login,telefone,email,senha,perfil) values('Andreia Barreira de Catro','1234556','Quico','63985139583','andreghoul18@gmail.com','123456','CLIENTE');

-- CRUDS NICOLE
insert into item (nomeItem, descricaoItem, precoItem, tamanho_tipo, imagemItem) values('Caderno da Barbie','Caderno Inteligente Grande', 40.00, 'GRANDE', 'Add Imagem');
insert into item (nomeItem, descricaoItem, precoItem, tamanho_tipo, imagemItem) values('Caderno da Barbie','Caderno Inteligente Medio', 30.00, 'MEDIO', 'Add Imagem');
insert into item (nomeItem, descricaoItem, precoItem, tamanho_tipo, imagemItem) values('Caderno da Barbie','Caderno Inteligente Pequeno', 20.00, 'PEQUENO', 'Add Imagem');

insert into estoque (id_item, descricaoEstoque, quantidade) values(1, 'Texto1', 10);
insert into estoque (id_item, descricaoEstoque, quantidade) values(2, 'Texto2', 20);
insert into estoque (id_item, descricaoEstoque, quantidade) values(3, 'Texto3', 30);

insert into pedido (id_item, id_usuario, precoTotalPedido) values(1, 1, 100.00);
insert into pedido (id_item, id_usuario, precototalPedido) values(2, 2, 200.00);
insert into pedido (id_item, id_usuario, precototalPedido) values(3, 3, 300.00);



