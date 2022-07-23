-- web: https://leetcode.cn/problems/department-top-three-salaries/

drop table if EXISTS Employee;
drop table if EXISTS Department;
Create table If Not Exists Employee (id int, name varchar(255),salary int,departmentId int);
Create table If Not Exists Department (id int, name varchar(255));
Truncate table Employee;
insert into Employee (id, name, salary ,departmentId) values (1, 'Joe', 85000, 1);
insert into Employee (id, name, salary ,departmentId) values (2, 'Henry',80000,2);
insert into Employee (id, name, salary ,departmentId) values (3, 'Sam', 60000, 2);
insert into Employee (id, name, salary ,departmentId) values (4, 'Max', 90000, 1);
insert into Employee (id, name, salary ,departmentId) values (5, 'Janet',69000, 1);
insert into Employee (id, name, salary ,departmentId) values (6, 'Randy', 85000, 1);
insert into Employee (id, name, salary ,departmentId) values (7, 'Will', 70000,1);

Truncate table Department;
insert into Department (id, name) values (1, 'IT');
insert into Department (id, name) values (2, 'Sales');

select * from Employee;
select * from Department;
-- 部门工资前三高的所有员工

--dense_rank 排序相同则认为是一个
select Department,Employee,Salary
from (
         select d.Name  Department,e.Name Employee, e.Salary, dense_rank() over(partition by d.id order by Salary desc) rk
         from Employee e join Department d on e.DepartmentId=d.id
     )tmp
where rk <=3

SELECT
    d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM
    Employee e1
        JOIN
    Department d ON e1.DepartmentId = d.Id
WHERE
        3 > (SELECT
                 COUNT(DISTINCT e2.Salary)
             FROM
                 Employee e2
             WHERE
                     e2.Salary > e1.Salary
               AND e1.DepartmentId = e2.DepartmentId
    );



