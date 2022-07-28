-- web https://leetcode-cn.com/problems/second-highest-salary
drop table if EXISTS Employee;
Create table If Not Exists Employee (id int, salary int);
Truncate table Employee;
insert into Employee (id, salary) values ('1', '100');
insert into Employee (id, salary) values ('2', '200');
insert into Employee (id, salary) values ('3', '300');

-- 找出工资第二高的人
select (select distinct Salary from Employee order by Salary desc limit 1,1) SecondHighestSalary