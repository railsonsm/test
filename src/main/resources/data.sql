
INSERT INTO raca (nome, tipo) VALUES('Rottweiler', 'CAO'),
('Dachshund', 'CAO'),
('Beagle', 'CAO'),
('Chihuahua', 'CAO'),
('Gato persa', 'GATO'),
('Siamês', 'GATO'),
('Ragdoll', 'GATO');

INSERT INTO cliente (nome, telefone, ativo) VALUES('Railson', '71982576778', true),
('Silvanas Correventos', '71982576778', true),
('Jaina Proudmoore', '71982576778', true),
('Varok Saurfang', '71982576778', true),
('Arthas Menethil', '71982576778', true);


INSERT INTO pet (nome, raca_id, cliente_id) VALUES('Lich',4, 2),
('Talanji',1, 2),
('Zuh',4, 2),
('Ghun',3, 1),
('Nzoth',4, 2);

