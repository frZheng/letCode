-- web: https://leetcode-cn.com/problems/customer-placing-the-largest-number-of-orders
drop table if EXISTS orders;
CREATE TABLE orders
(
    order_number INT,
    customer_number INT,
    order_date DATE,
    required_date DATE,
    shipped_date DATE,
    STATUS VARCHAR(20),
    COMMENT VARCHAR(30)
);
INSERT INTO orders VALUES(1, 1, '2017-04-09', '2017-04-13', '2017-04-12', 'Closed', NULL);
INSERT INTO orders VALUES(2, 2, '2017-04-15', '2017-04-20', '2017-04-18', 'Closed', NULL);
INSERT INTO orders VALUES(3, 3, '2017-04-16', '2017-04-25', '2017-04-20', 'Closed', NULL);
INSERT INTO orders VALUES(4, 3, '2017-04-18', '2017-04-28', '2017-04-25', 'Closed', NULL);

-- 在表 orders 中找到订单数最多客户对应的 customer_number 。
select customer_number from
    (select customer_number,count(*) cnt from orders group by customer_number) a
order by cnt desc
    limit 1