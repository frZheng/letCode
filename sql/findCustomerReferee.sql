-- web: https://leetcode-cn.com/problems/find-customer-referee
drop table if EXISTS customer;
CREATE TABLE If Not Exists customer (id INT, name varchar(10), referee_id INT, PRIMARY KEY (id));
Truncate table  customer;
INSERT INTO customer VALUES(1, 'Will', null);
INSERT INTO customer VALUES(2, 'Jane', null);
INSERT INTO customer VALUES(3, 'Alex', 2);
INSERT INTO customer VALUES(4, 'Bill', null);
INSERT INTO customer VALUES(5, 'Zack', 1);
INSERT INTO customer VALUES(6, 'Mark', 2);

-- 一个客户列表，列表中客户的推荐人的编号都 不是 2。
select name from customer where coalesce(referee_id,0) <> 2