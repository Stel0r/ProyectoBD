
-- Creacion tarifas
insert into Tarifa Values (1,'P',5500);
insert into Tarifa Values (2,'M',10850);
insert into Tarifa Values (3,'G',16750);

--Creacion Ciudad

insert into Ciudad Values (110110, 'Bogota', 10.5);
insert into Ciudad Values (150001, 'Tunja', 5.2);

--creacion ciudad_tarifa

insert into Ciudad_Tarifa Values(110110,1);
insert into Ciudad_Tarifa Values(110110,2);
insert into Ciudad_Tarifa Values(110110,3);
insert into Ciudad_Tarifa Values(150001,1);
insert into Ciudad_Tarifa Values(150001,2);
insert into Ciudad_Tarifa Values(150001,3);

--creacion cliente

insert into Cliente 
Values(1000706963,'CC','Diego Felipe','Gamez Ramirez',to_date('10/11/2002','dd/mm/yyyy'),3223484527,'Calle 71a #78-41','diego.felipe.gamez@gmail.com','constrasegura','M');
