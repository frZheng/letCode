-- https://leetcode.cn/problems/customer-order-frequency/
drop table if EXISTS Customers;
drop table if EXISTS Product;
drop table if EXISTS Orders;
Create table If Not Exists Customers (customer_id int, name varchar(255),country varchar(255));
Create table If Not Exists Product (product_id int, description varchar(255), price int);
Create table If Not Exists Orders (order_id int, customer_id int,product_id int,order_date date, quantity int);
Truncate table Customers;
Truncate table Product;
Truncate table Orders;

insert into Customers values (1, 'Winston', 'USA');
insert into Customers values (2, 'Jonathan', 'Peru');
insert into Customers values (3, 'Moustafa', 'Egypt');

insert into Product values (10, 'LC Phone', 300);
insert into Product values (20, 'LC T-Shirt', 10);
insert into Product values (30, 'LC Book', 45);
insert into Product values (40, 'LC Keychain', 2);


insert into Orders values (1, 1, 10, '2020-06-10', 1);
insert into Orders values (2, 1, 20, '2020-07-01', 1);
insert into Orders values (3, 1, 30, '2020-07-08', 2);
insert into Orders values (4, 2, 10, '2020-06-15', 2);
insert into Orders values (5, 2, 40, '2020-07-01', 10);
insert into Orders values (6, 2, 20, '2020-06-24', 2);
insert into Orders values (7, 3, 30, '2020-06-25', 2);
insert into Orders values (9, 3, 30, '2020-05-08', 3);

SELECT * FROM Customers;
SELECT * FROM Product;
SELECT * FROM Orders;

--问题： 消费者的 id 和名字, 其中消费者在 2020 年 6 月和 7 月, 每月至少花费了$100.
-- 1. 输出
select id name from  Customers where id in ()
-- 2. 查找集合。其中消费者在 2020 年 6 月和 7 月, 每月至少花费了$100. ->



-- 注意，不能去掉month()
select customer_id,name
from Customers
where customer_id in
(select customer_id
from
   (select customer_id, month(order_date) mon , sum(quantity*price) total
    from Orders o left join Product p on o.product_id = p.product_id
    where month(order_date) = 6 or month(order_date)=7
    group by customer_id,month(order_date)
   ) as t1
where total >=100
group by customer_id
having count(*)>=2
)theMostRecentThreeOrders