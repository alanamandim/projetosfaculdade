INSERT INTO usuario (`cpf`,`email`,`nome`,`senha`,`telefone`) VALUES ('106.035.852-83','a@gmail.com','Joana','123456','48 98885-7878');
INSERT INTO usuario (`cpf`,`email`,`nome`,`senha`,`telefone`) VALUES ('106.089.589-78','g@gmail.com','Gugu','654322','48 99645-7896');
INSERT INTO usuario (`cpf`,`email`,`nome`,`senha`,`telefone`) VALUES ('106.089.600-78','j@gmail.com','Juca','777777','48 2589-4578');
INSERT INTO usuario (`cpf`,`email`,`nome`,`senha`,`telefone`) VALUES ('106.123.456-78','r@gmail.com','Ruan','0140203','48 3245-8745');
INSERT INTO usuario (`cpf`,`email`,`nome`,`senha`,`telefone`) VALUES ('106.987.654-32','jeje@gmail.com','Jê','ahdfdfcj','21 98778-4545');
INSERT INTO usuario (`cpf`,`email`,`nome`,`senha`,`telefone`) VALUES ('106.654.987-32','henry@gmail.com','Henry','alajef','48 92121-2121');

INSERT INTO titular (`dia_pagamento`,`cpf`,`cartao_pref_id_cartao`) VALUES (10,'106.035.852-83',NULL);
INSERT INTO titular (`dia_pagamento`,`cpf`,`cartao_pref_id_cartao`) VALUES (5,'106.089.589-78',NULL);
INSERT INTO titular (`dia_pagamento`,`cpf`,`cartao_pref_id_cartao`) VALUES (10,'106.089.600-78',NULL);
INSERT INTO titular (`dia_pagamento`,`cpf`,`cartao_pref_id_cartao`) VALUES (10,'106.987.654-32',NULL);
INSERT INTO titular (`dia_pagamento`,`cpf`,`cartao_pref_id_cartao`) VALUES (10,'106.654.987-32',NULL);

INSERT INTO dependente (`limite_mensal`,`saldo`,`titular_cpf`,`cpf`) VALUES (150,100,'106.035.852-83','106.123.456-78');


INSERT INTO cartoes (`cod_seg`,`id_cartao`,`titular_cpf`,`nome`,`numero`,`validade`) VALUES (20,NULL,'106.035.852-83','joana b r','1256 8596 7894 8562','10/25');
INSERT INTO cartoes (`cod_seg`,`id_cartao`,`titular_cpf`,`nome`,`numero`,`validade`) VALUES (689,NULL,'106.089.589-78','gugu','1254 9685 7852 1478','12/26');
INSERT INTO cartoes (`cod_seg`,`id_cartao`,`titular_cpf`,`nome`,`numero`,`validade`) VALUES (708,NULL,'106.089.600-78','Juca r j','0012 2012 3652 8520','01/27');
INSERT INTO cartoes (`cod_seg`,`id_cartao`,`titular_cpf`,`nome`,`numero`,`validade`) VALUES (365,NULL,'106.089.589-78','gug','2587 7896 3214 7852','05/27');
INSERT INTO cartoes (`cod_seg`,`id_cartao`,`titular_cpf`,`nome`,`numero`,`validade`) VALUES (389,NULL,'106.987.654-32','jeff','2588 7896 3214 7852','06/27');
INSERT INTO cartoes (`cod_seg`,`id_cartao`,`titular_cpf`,`nome`,`numero`,`validade`) VALUES (365,NULL,'106.654.987-32','Henry R','2587 7896 3897 7852','05/27');


INSERT INTO produto (`id_produto`,`nome`) VALUES (NULL,'Café Expresso Médio');
INSERT INTO produto (`id_produto`,`nome`) VALUES (NULL,'Café Expresso Pequeno');
INSERT INTO produto (`id_produto`,`nome`) VALUES (NULL,'Café Expresso Grande');
INSERT INTO produto (`id_produto`,`nome`) VALUES (NULL,'Mocha Pequeno');
INSERT INTO produto (`id_produto`,`nome`) VALUES (NULL,'Mocha Médio');
INSERT INTO produto (`id_produto`,`nome`) VALUES (NULL,'Mocha Grande');
INSERT INTO produto (`id_produto`,`nome`) VALUES (NULL,'Café com Leite Pequeno');
INSERT INTO produto (`id_produto`,`nome`) VALUES (NULL,'Café com Leite Médio');

INSERT INTO historico_preco (`id_produto`,`valor`,`data_act`) VALUES (1,1.5,'2023-06-16 00:06:31.000000');
INSERT INTO historico_preco (`id_produto`,`valor`,`data_act`) VALUES (2,2,'2023-06-16 00:06:31.000000');
INSERT INTO historico_preco (`id_produto`,`valor`,`data_act`) VALUES (3,2.5,'2023-06-16 00:06:31.000000');
INSERT INTO historico_preco (`id_produto`,`valor`,`data_act`) VALUES (4,2,'2023-06-16 00:06:31.000000');
INSERT INTO historico_preco (`id_produto`,`valor`,`data_act`) VALUES (5,2.5,'2023-06-16 00:06:31.000000');
INSERT INTO historico_preco (`id_produto`,`valor`,`data_act`) VALUES (6,3,'2023-06-16 00:06:31.000000');
INSERT INTO historico_preco (`id_produto`,`valor`,`data_act`) VALUES (7,2,'2023-06-16 00:06:31.000000');
INSERT INTO historico_preco (`id_produto`,`valor`,`data_act`) VALUES (8,2.5,'2023-06-16 00:06:31.000000');


UPDATE  titular SET cartao_pref_id_cartao = 1 WHERE cpf='106.035.852-83';
UPDATE  titular SET cartao_pref_id_cartao = 2 WHERE cpf = '106.089.589-78';
UPDATE  titular SET cartao_pref_id_cartao = 3 WHERE cpf = '106.089.600-78';
UPDATE  titular SET cartao_pref_id_cartao = 5 WHERE cpf = '106.987.654-32';
UPDATE  titular SET cartao_pref_id_cartao = 6 WHERE cpf = '106.654.987-32';

INSERT INTO endereco (`cep`,`id_endereco`,`bairro`,`cidade`,`estado`,`nome`,`rua_nr`) VALUES (88049021,NULL,'São José','Florianópolis','SC','IFSC-SJ','Av. Xablau, n 55');
INSERT INTO endereco (`cep`,`id_endereco`,`bairro`,`cidade`,`estado`,`nome`,`rua_nr`) VALUES (88049089,NULL,'Palhoça','Florianópolis','SC','UDESC','Av. Perdeu, n 89');
INSERT INTO endereco (`cep`,`id_endereco`,`bairro`,`cidade`,`estado`,`nome`,`rua_nr`) VALUES (88049100,NULL,'Centro','Florianópolis','SC','IFSC-FL','Av. Mauro Ramos, n 345');

INSERT INTO local (`id_endereco`,`local`,`nome`) VALUES (1,1,'Sala dos Professores');
INSERT INTO local (`id_endereco`,`local`,`nome`) VALUES (1,2,'Sala de Reunião');
INSERT INTO local (`id_endereco`,`local`,`nome`) VALUES (2,1,'Sala dos Professores');
INSERT INTO local (`id_endereco`,`local`,`nome`) VALUES (2,2,'Sala de Reunião');
INSERT INTO local (`id_endereco`,`local`,`nome`) VALUES (3,3,'Refeitório');
INSERT INTO local (`id_endereco`,`local`,`nome`) VALUES (3,1,'Sala dos Professores');


INSERT INTO modelo (`id_modelo`,`modelo`) VALUES (NULL,'Simples');
INSERT INTO modelo (`id_modelo`,`modelo`) VALUES (NULL,'Mediano');
INSERT INTO modelo (`id_modelo`,`modelo`) VALUES (NULL,'Avançado');

INSERT INTO maquina (`id_maquina`,`id_modelo`,`nome`) VALUES (NULL,1,'SUS');
INSERT INTO maquina (`id_maquina`,`id_modelo`,`nome`) VALUES (NULL,1,'Povao');
INSERT INTO maquina (`id_maquina`,`id_modelo`,`nome`) VALUES (NULL,2,'Serie B');
INSERT INTO maquina (`id_maquina`,`id_modelo`,`nome`) VALUES (NULL,2,'Cariocao');
INSERT INTO maquina (`id_maquina`,`id_modelo`,`nome`) VALUES (NULL,3,'Classe A');
INSERT INTO maquina (`id_maquina`,`id_modelo`,`nome`) VALUES (NULL,3,'Jurerê');


INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (1,1);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (1,2);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (2,1);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (2,2);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (2,3);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (2,4);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (2,5);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (3,1);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (3,2);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (3,3);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (3,4);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (3,5);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (3,6);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (3,7);
INSERT INTO modelo_produtos (`modelos_id_modelo`,`produtos_id_produto`) VALUES (3,8);


INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (1,1,'2023-06-20 00:11:52.000000','106.035.852-83');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (2,2,'2023-06-20 00:11:52.000000','106.089.589-78');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (3,4,'2023-06-17 00:11:52.000000','106.035.852-83');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (4,5,'2023-06-20 00:11:52.000000','106.089.600-78');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (5,6,'2023-06-19 00:11:52.000000','106.089.589-78');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (6,8,'2023-06-19 00:11:52.000000','106.035.852-83');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (1,2,'2023-06-16 00:11:52.000000','106.987.654-32');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (2,2,'2023-06-16 00:11:52.000000','106.654.987-32');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (3,4,'2023-06-16 00:11:52.000000','106.123.456-78');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (4,3,'2023-06-16 00:11:52.000000','106.035.852-83');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (5,7,'2023-06-16 00:11:52.000000','106.089.589-78');
INSERT INTO consumo (`id_maquina`,`id_produto`,`data_act`,`id_usuario`) VALUES (6,7,'2023-06-16 00:11:52.000000','106.089.600-78');



INSERT INTO alocacao (`id_local_id_endereco`,`id_local_local`,`id_maquina_id_maquina`,`data_entrada`,`data_sai`) VALUES (1,1,1,'2023-06-16 00:06:31.000000','2023-06-21 06:00:32.000000');
INSERT INTO alocacao (`id_local_id_endereco`,`id_local_local`,`id_maquina_id_maquina`,`data_entrada`,`data_sai`) VALUES (1,2,6,'2023-06-16 00:06:31.000000',NULL);
INSERT INTO alocacao (`id_local_id_endereco`,`id_local_local`,`id_maquina_id_maquina`,`data_entrada`,`data_sai`) VALUES (2,1,3,'2023-06-16 00:06:31.000000',NULL);
INSERT INTO alocacao (`id_local_id_endereco`,`id_local_local`,`id_maquina_id_maquina`,`data_entrada`,`data_sai`) VALUES (2,2,5,'2023-06-16 00:06:31.000000',NULL);
INSERT INTO alocacao (`id_local_id_endereco`,`id_local_local`,`id_maquina_id_maquina`,`data_entrada`,`data_sai`) VALUES (3,3,4,'2023-06-16 00:06:31.000000',NULL);
INSERT INTO alocacao (`id_local_id_endereco`,`id_local_local`,`id_maquina_id_maquina`,`data_entrada`,`data_sai`) VALUES (3,1,2,'2023-06-16 00:06:31.000000',NULL);
INSERT INTO alocacao (`id_local_id_endereco`,`id_local_local`,`id_maquina_id_maquina`,`data_entrada`,`data_sai`) VALUES (2,1,1,'2023-06-21 00:06:31.000000',NULL);


