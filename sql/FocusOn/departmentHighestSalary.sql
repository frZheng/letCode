-- https://leetcode.cn/problems/department-highest-salary/

drop table if EXISTS Employee;
Create table If Not Exists Employee (id int, name varchar(20),salary int, departmentId int);

drop table if EXISTS Department;
Create table If Not Exists Department (id int, name varchar(20));

insert into Employee values (1,'Joe',70000,1);
insert into Employee values (2,'Henry',80000,2);
insert into Employee values (3,'Sam',60000,2);
insert into Employee values (4,'Max',90000,1);
select * from Employee;

insert into Department values (1,'IT');
insert into Department values (2,'Sales');
select * from Department;

-- 部门工资最高的员工

select Department,name,salary from(
select d.name Department, e.name name, e.salary salary from Employee e left join Department d on e.departmentId = d.id
) wh



