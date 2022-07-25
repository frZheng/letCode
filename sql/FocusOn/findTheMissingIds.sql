-- web: https://leetcode.cn/problems/find-the-missing-ids/
drop table if EXISTS Customers;
Create table If Not Exists Customers (customer_id int, customer_name varchar(255));

insert into Customers values (1,'Alice');
insert into Customers values (4,'Bob');
insert into Customers values (5,'Charlie');
select * from Customers;
-- 所有遗失的顾客id
-- sql 递归+with语法
with recursive t as
                   (select 1 as i
                    union all
                    select i+1 from t where i<100
                   )
-- select * from t;
select i as ids
from t
where i<=(select max(customer_id) from customers)
  and i not in (select customer_id from customers)
