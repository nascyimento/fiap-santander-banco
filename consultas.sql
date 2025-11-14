# CRIANDO A TABELA
CREATE TABLE contas (
    id INT PRIMARY KEY,
    numero INT NOT NULL,
    agencia VARCHAR(20) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    tipo_de_conta VARCHAR(20) NOT NULL,
    endereco VARCHAR(200),
    saldo DECIMAL(15,2) NOT NULL DEFAULT 0
);

# INSERINDO REGISTROS
INSERT INTO contas (id, numero, agencia, cpf, nome, tipo_de_conta, endereco, saldo)
VALUES
(1,1001, '001', '12345678901', 'Alice Santos', 'CONTA_CORRENTE', 'Rua A, 123 - São Paulo/SP', 1500.50),
(2,1002, '001', '23456789012', 'Bruno Lima', 'CONTA_POUPANCA', 'Av. Brasil, 456 - Rio de Janeiro/RJ', 3000.00),
(3,1003, '002', '34567890123', 'Carla Souza', 'CONTA_CORRENTE', 'Rua das Flores, 789 - Belo Horizonte/MG', 750.75),
(4,1004, '002', '45678901234', 'Daniel Oliveira', 'CONTA_CORRENTE', 'Rua Central, 101 - Curitiba/PR', 2500.00),
(5,1005, '003', '56789012345', 'Eduarda Costa', 'CONTA_POUPANCA', 'Rua Norte, 202 - Porto Alegre/RS', 500.00),
(6,1006, '003', '67890123456', 'Felipe Alves', 'CONTA_CORRENTE', 'Av. Paulista, 303 - São Paulo/SP', 10000.00),
(7,1007, '004', '78901234567', 'Gabriela Martins', 'CONTA_CORRENTE', 'Rua das Acácias, 404 - Salvador/BA', 850.00),
(8,1008, '004', '89012345678', 'Henrique Ferreira', 'CONTA_CORRENTE', 'Rua Sul, 505 - Recife/PE', 1200.00),
(9,1009, '005', '90123456789', 'Isabela Rocha', 'CONTA_POUPANCA', 'Rua Oeste, 606 - Florianópolis/SC', 4300.00),
(10,1010, '005', '01234567890', 'João Pereira', 'CONTA_CORRENTE', 'Rua Leste, 707 - Brasília/DF', 2150.30);

SELECT * FROM contas c WHERE c.tipo_de_conta = 'CONTA_CORRENTE';

UPDATE contas c SET tipo_de_conta = 'CONTA_CORRENTE' WHERE c.tipo_de_conta = 'CONTA_SALARIO';

SELECT c.tipo_de_conta, SUM(c.saldo) FROM contas c GROUP BY c.tipo_de_conta;

SELECT c.cpf, SUM(c.saldo) FROM contas c GROUP BY c.cpf;

SELECT c.agencia, SUM(c.saldo) FROM contas c GROUP BY c.agencia

SELECT c.agencia, SUM(c.saldo) FROM contas c GROUP BY c.agencia ORDER BY c.agencia ASC

SELECT c.agencia, c.numero, SUM(c.saldo) FROM contas c GROUP BY c.agencia, c.numero  ORDER BY c.agencia, c.numero desc

select * from contas c where c.id = 1;

# MÉDIA
SELECT AVG(c.saldo) AS MEDIA FROM contas c;

# C OUNT
SELECT COUNT(c.id) AS QUANTIDADE FROM contas c;

select c.nome from contas c where c.id = 1;


