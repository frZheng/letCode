#web: https://leetcode-cn.com/problems/customers-who-never-order
Create table If Not Exists Customers (id int, name varchar(255));
Create table If Not Exists Orders (id int, customerId int);
Truncate table Customers;
insert into Customers (id, name) values ('1', 'Joe');
insert into Customers (id, name) values ('2', 'Henry');
insert into Customers (id, name) values ('3', 'Sam');
insert into Customers (id, name) values ('4', 'Max');
Truncate table Orders;
insert into Orders (id, customerId) values ('1', '3');
insert into Orders (id, customerId) values ('2', '1');

# 编写一个 SQL 查询，找出所有从不订购任何东西的客户。
select a.Name Customers from Customers a where not exists(select * from Orders b where a.Id = b.CustomerId)