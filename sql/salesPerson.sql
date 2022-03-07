-- web: https://leetcode-cn.com/problems/sales-person
CREATE TABLE salesperson (sales_id INT,NAME VARCHAR(25),salary INT,commission_rate INT,hire_date DATE);

INSERT INTO salesperson VALUES(1,'John',100000,6,'2006-04-01');
INSERT INTO salesperson VALUES (2,'Amy',120000,5,'2010-05-01');
INSERT INTO salesperson VALUES (3,'Mark',65000,6,'2008-12-25');
INSERT INTO salesperson VALUES (4,'Pam',25000,25,'2005-01-01');
INSERT INTO salesperson VALUES (5,'Alex',50000,10,'2007-02-03');


CREATE TABLE company(com_id INT, NAME VARCHAR(20),city VARCHAR(20));

INSERT INTO company VALUES (1,'Red','Boston');
INSERT INTO company VALUES (2,'ORANGE','New York');
INSERT INTO company VALUES (3,'YELLO','Boston');
INSERT INTO company VALUES (4,'GREEN','Austin');

CREATE TABLE orders1 (order_id INT,DATE DATE,com_id INT,sales_id INT,amount INT);

INSERT INTO orders1 VALUES (1,'2014-01-01',3,4,100000);
INSERT INTO orders1 VALUES (2,'2014-02-01',4,5,5000);
INSERT INTO orders1 VALUES (3,'2014-03-01',1,1,50000);
INSERT INTO orders1 VALUES (4,'2014-04-01',1,4,25000);
