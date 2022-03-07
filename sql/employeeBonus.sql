-- web: https://leetcode-cn.com/problems/employee-bonus
drop table if EXISTS employee;
create table employee
(
    empId int,
    name varchar(10),
    supervisor int,
    salary DECIMAL
);
drop table if EXISTS bonus;
create table bonus
(
    empId int,
    bonus DECIMAL
);

insert into employee values(1, 'John', 3, 1000);
insert into employee values(2, 'Dan', 3, 2000);
insert into employee values(3, 'Brad', null, 4000);
insert into employee values(4, 'Thomas', 3, 4000);
insert into bonus values(2, 500);
insert into bonus values(4, 2000);

-- 选出所有 bonus < 1000 的员工的 name 及其 bonus。
-- coalesce(c.bonus,0) 去掉奖金为null
select c.name,c.bonus from
(select a.name,b.bonus from Employee a left join Bonus b on a.empId = b.empId) c
where coalesce(c.bonus,0) < 1000