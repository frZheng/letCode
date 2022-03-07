-- web: https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/

drop table if EXISTS Employee;
Create table If Not Exists Employee (id int, name varchar(255), salary int, managerId int);
Truncate table Employee;
insert into Employee (id, name, salary, managerId) values ('1', 'Joe', '70000', '3');
insert into Employee (id, name, salary, managerId) values ('2', 'Henry', '80000', '4');
insert into Employee (id, name, salary, managerId) values ('3', 'Sam', '60000', '-1');
insert into Employee (id, name, salary, managerId) values ('4', 'Max', '90000', '-1');

-- 找出员工比管理工资高的人
-- 自己跟自己笛卡尔连接后, 筛选条件为员工与其管理, 员工工资更高
select a.Name Employee from Employee a,Employee b where a.ManagerId = b.Id and a.Salary > b.Salary;