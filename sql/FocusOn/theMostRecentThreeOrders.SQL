--https://leetcode.cn/problems/the-most-recent-three-orders/
drop table if EXISTS Customers;
drop table if EXISTS Orders;
Create table If Not Exists Customers (customer_id int, name varchar(255));
Create table If Not Exists Orders (order_id int, order_date date, customer_id int, cost int);


insert into Customers values (1,'Winston');
insert into Customers values (2,'Jonathan');
insert into Customers values (3,'Annabelle');
insert into Customers values (4,'Marwan');
insert into Customers values (5,'Khaled');

insert into Orders values  (1,'2020-07-31',1,30);
insert into Orders values  (2,'2020-07-30',2,40);
insert into Orders values  (3,'2020-07-31',3,70);
insert into Orders values  (4,'2020-07-29',4,100);
insert into Orders values  (5,'2020-06-10',1,1010);
insert into Orders values  (6,'2020-08-01',2,102);
insert into Orders values  (7,'2020-08-01',3,111);
insert into Orders values  (8,'2020-08-03',1,99);
insert into Orders values  (9,'2020-08-07',2,32);
insert into Orders values  (10,'2020-07-15',1,2);

select * from Customers;
select * from Orders;

--  the most recent 3 orders of each user

select name customer_name ,customer_id,order_id,order_date
from (
         select name ,o.customer_id,order_id,order_date ,rank() over(partition by o.customer_id order by order_date desc) rk
         from Orders o left join Customers c
                                 on o.customer_id=c.customer_id
     )t1
where rk <=3
order by customer_name ,customer_id,order_date desc
