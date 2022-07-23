-- https://leetcode.cn/problems/sales-person/

drop table if Exists Salesperson;
create table if not Exists Salesperson
(sales_id int,
 name varchar(20),
 salary int,
 commission_rate int,
 hire_date date);
 truncate Salesperson;


drop table if Exists company;
create table if not Exists company
(com_id int,
 name varchar(10),
 city varchar(10));
truncate company;

drop table if Exists Orders;
create table if not Exists Orders
(order_id int,
 order_date date,
 com_id int,
 sales_id int,
 amount int);
 truncate Orders;

insert into Salesperson values (1, 'John', 100000, 6, '2006-04-01');
insert into Salesperson values (2, 'Amy',  120000, 5, '2010-05-01');
insert into Salesperson values (3, 'Mark', 65000, 12, '2008-12-25');
insert into Salesperson values (4, 'Pam',  25000, 25, '2005-01-01');
insert into Salesperson values (5, 'Alex', 50000, 10, '2007-02-03');

insert into Company values (1, 'RED', 'Boston');
insert into Company values (2, 'ORANGE', 'New York');
insert into Company values (3, 'YELLOW', 'Boston');
insert into Company values (4, 'GREEN', 'Austin');

insert into Orders values (1, '2014-01-01', 3, 4, 100000);
insert into Orders values (2, '2014-02-01', 4, 5, 5000);
insert into Orders values (3, '2014-03-01', 1, 1, 50000);
insert into Orders values (4, '2014-04-01', 1, 4, 25000);

select * from Salesperson;
select * from Company;
select * from Orders;


-- drop table if Exists company;
-- create table if not Exists company
-- (com_id int,
--  name varchar(8),
-- city varchar(8));
-- truncate company;
-- insert into Company values (1, 'RED', '123456789abcd');
-- select * from Company;



