insert into address (id, district, city, street, number, state) values (1, 'Jardim Paquetá', 'Belo Horizonte', 'Rua Susana Maria', '1212', 'MG');
insert into address (id, district, city, street, number, state)  values (2, 'Jardins Paulista', 'São Paulo', 'Alameda Santos', '3500', 'SP');
insert into address (id, district, city, street, number, state)  values (3, 'Jardins Paulista', 'São Paulo', 'Alameda Jau', '1250', 'SP');

insert into customer (id, identity_document, birthday_date, name, id_address) values (1, '123', '1976-09-12T15:39:52.160Z', 'Aluno Teste A', '1');
insert into customer (id, identity_document, birthday_date, name, id_address)  values (2, '456', '1980-07-26T08:39:45.160Z', 'Aluno Teste B', '2');

insert into installation (id, installation_code, installation_date, id_customer, id_address) values (1, 'INST-001', '1999-07-26T08:39:45.160Z', '1', '2');
insert into installation (id, installation_code, installation_date, id_customer, id_address) values (2, 'INST-002', '2020-06-26T08:39:45.160Z', '2', '2');
insert into installation (id, installation_code, installation_date, id_customer, id_address) values (3, 'INST-003', '2019-09-15T08:39:45.160Z', '2', '3');

insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (1, 'FAT001', '2019-01-01T10:42:45.160Z', '2019-01-10T10:42:45.160Z','100999', '100', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (2, 'FAT-002', '2019-02-01T10:42:45.160Z', '2019-02-10T10:42:45.160Z','101234', '255.20', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (3, 'FAT-003', '2019-03-01T10:42:45.160Z', '2019-03-10T10:42:45.160Z','101334', '189.10', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (4, 'FAT-004', '2019-04-01T10:42:45.160Z', '2019-04-10T10:42:45.160Z','101534', '100.99', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (5, 'FAT-005', '2019-05-01T10:42:45.160Z', '2019-05-10T10:42:45.160Z','101834', '350.85', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (6, 'FAT-006', '2019-06-01T10:42:45.160Z', '2019-06-10T10:42:45.160Z','102034', '112.12', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (7, 'FAT-007', '2019-07-01T10:42:45.160Z', '2019-07-10T10:42:45.160Z','100000', '399', '2');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (8, 'FAT-008', '2019-08-01T10:42:45.160Z', '2019-08-10T10:42:45.160Z','100250', '898.76', '2');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (9, 'FAT-009', '2019-09-01T10:42:45.160Z', '2019-09-10T10:42:45.160Z','100650', '1504.26', '2');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (10, 'FAT-0010', '2019-010-01T10:42:45.160Z', '2019-10-10T10:42:45.160Z','102134', '200', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (11, 'FAT-0011', '2019-11-01T10:42:45.160Z', '2019-11-10T10:42:45.160Z','1102334', '450', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (12, 'FAT-0012', '2019-12-01T10:42:45.160Z', '2019-12-10T10:42:45.160Z','1102534', '909.87', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (13, 'FAT-0013', '2020-01-01T10:42:45.160Z', '2020-01-10T10:42:45.160Z','1102834', '395', '1');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (14, 'FAT-0014', '2020-02-01T10:42:45.160Z', '2020-02-10T10:42:45.160Z','000999', '865', '3');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (15, 'FAT-0015', '2020-03-01T10:42:45.160Z', '2020-03-10T10:42:45.160Z','001199', '893', '3');
insert into invoice (id, invoice_code, read_date, due_date, read_number, invoice_value, id_installation) values (16, 'FAT-0016', '2020-04-01T10:42:45.160Z', '2020-04-10T10:42:45.160Z','1102934', '840', '1');
