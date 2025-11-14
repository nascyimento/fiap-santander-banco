-- Limpeza e reinício de sequência para reexecução segura
SET REFERENTIAL_INTEGRITY FALSE;

TRUNCATE TABLE contas;
TRUNCATE TABLE usuarios;

ALTER TABLE usuarios ALTER COLUMN id RESTART WITH 1;
ALTER TABLE contas ALTER COLUMN id RESTART WITH 1;

SET REFERENTIAL_INTEGRITY TRUE;

-- ==========================
-- USUÁRIOS (20 registros, CPFs únicos)
-- ==========================
INSERT INTO usuarios (id, nome, cpf, email, senha, tipo) VALUES
(1,  'Alice Silva',       '12345678901', 'alice@email.com',       '123', 'COMUM'),
(2,  'Bruno Costa',       '98765432100', 'bruno@email.com',       '123', 'ADMIN'),
(3,  'Carla Souza',       '11122233345', 'carla@email.com',       '123', 'COMUM'),
(4,  'Diego Pereira',     '22233344456', 'diego@email.com',       '123', 'COMUM'),
(5,  'Eduarda Lima',      '33344455567', 'eduarda@email.com',     '123', 'COMUM'),
(6,  'Fabio Mendes',      '44455566678', 'fabio@email.com',       '123', 'ADMIN'),
(7,  'Gabriela Rocha',    '55566677789', 'gabriela@email.com',    '123', 'COMUM'),
(8,  'Henrique Alves',    '66677788890', 'henrique@email.com',    '123', 'COMUM'),
(9,  'Isabela Nunes',     '77788899901', 'isabela@email.com',     '123', 'COMUM'),
(10, 'João Carvalho',     '88899900012', 'joao@email.com',        '123', 'COMUM'),
(11, 'Karina Duarte',     '99900011123', 'karina@email.com',      '123', 'ADMIN'),
(12, 'Lucas Martins',     '00011122234', 'lucas@email.com',       '123', 'COMUM'),
(13, 'Mariana Torres',    '11122233346', 'mariana@email.com',     '123', 'COMUM'),
(14, 'Natália Ramos',     '22233344457', 'natalia@email.com',     '123', 'COMUM'),
(15, 'Otávio Silva',      '33344455568', 'otavio@email.com',      '123', 'COMUM'),
(16, 'Patrícia Gomes',    '44455566679', 'patricia@email.com',    '123', 'COMUM'),
(17, 'Rafael Almeida',    '55566677780', 'rafael@email.com',      '123', 'COMUM'),
(18, 'Sabrina Freitas',   '66677788891', 'sabrina@email.com',     '123', 'ADMIN'),
(19, 'Thiago Rodrigues',  '77788899902', 'thiago@email.com',      '123', 'COMUM'),
(20, 'Viviane Oliveira',  '88899900013', 'viviane@email.com',     '123', 'COMUM');

-- ==========================
-- CONTAS (20 registros, alinhadas aos usuários)
-- ==========================
INSERT INTO contas (id, numero, agencia, cpf, nome, tipo_de_conta, endereco, saldo, usuario_id) VALUES
(1,  1001, '001', '12345678901', 'Alice Silva',       'CONTA_CORRENTE', 'Rua A, 100',   2500.00, 1),
(2,  1002, '001', '98765432100', 'Bruno Costa',       'CONTA_POUPANCA', 'Rua B, 200',   1200.00, 2),
(3,  1003, '001', '11122233345', 'Carla Souza',       'CONTA_CORRENTE', 'Rua C, 300',    530.50, 3),
(4,  1004, '002', '22233344456', 'Diego Pereira',     'CONTA_POUPANCA', 'Rua D, 400',   3220.00, 4),
(5,  1005, '002', '33344455567', 'Eduarda Lima',      'CONTA_CORRENTE', 'Rua E, 500',   1450.75, 5),
(6,  1006, '002', '44455566678', 'Fabio Mendes',      'CONTA_CORRENTE', 'Rua F, 600',    980.00, 6),
(7,  1007, '003', '55566677789', 'Gabriela Rocha',    'CONTA_POUPANCA', 'Rua G, 700',    430.00, 7),
(8,  1008, '003', '66677788890', 'Henrique Alves',    'CONTA_CORRENTE', 'Rua H, 800',   2980.25, 8),
(9,  1009, '003', '77788899901', 'Isabela Nunes',     'CONTA_CORRENTE', 'Rua I, 900',   1100.00, 9),
(10, 1010, '003', '88899900012', 'João Carvalho',     'CONTA_CORRENTE', 'Rua J, 1000',   750.00, 10),
(11, 1011, '004', '99900011123', 'Karina Duarte',     'CONTA_POUPANCA', 'Rua K, 1100',   890.10, 11),
(12, 1012, '004', '00011122234', 'Lucas Martins',     'CONTA_CORRENTE', 'Rua L, 1200',   630.00, 12),
(13, 1013, '004', '11122233346', 'Mariana Torres',    'CONTA_CORRENTE', 'Rua M, 1300',  1420.00, 13),
(14, 1014, '005', '22233344457', 'Natália Ramos',     'CONTA_POUPANCA', 'Rua N, 1400',  2100.00, 14),
(15, 1015, '005', '33344455568', 'Otávio Silva',      'CONTA_CORRENTE', 'Rua O, 1500',   300.00, 15),
(16, 1016, '005', '44455566679', 'Patrícia Gomes',    'CONTA_CORRENTE', 'Rua P, 1600',  1850.00, 16),
(17, 1017, '006', '55566677780', 'Rafael Almeida',    'CONTA_POUPANCA', 'Rua Q, 1700',  2220.50, 17),
(18, 1018, '006', '66677788891', 'Sabrina Freitas',   'CONTA_CORRENTE', 'Rua R, 1800',   110.00, 18),
(19, 1019, '006', '77788899902', 'Thiago Rodrigues',  'CONTA_CORRENTE', 'Rua S, 1900',  7500.00, 19),
(20, 1020, '006', '88899900013', 'Viviane Oliveira',  'CONTA_POUPANCA', 'Rua T, 2000',   525.00, 20);

-- Ajusta o próximo ID (o ponteiro do auto-increment) para a próxima posição livre
ALTER TABLE usuarios ALTER COLUMN id RESTART WITH 21;
ALTER TABLE contas   ALTER COLUMN id RESTART WITH 21;