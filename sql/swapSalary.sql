-- web: https://leetcode-cn.com/problems/employee-bonus
drop table if EXISTS salary;
create table salary
(
    id int,
    name varchar(10),
    sex varchar(10),
    salary int
);

insert into salary values(1, 'A', 'f', 2500);
insert into salary values(2, 'B', 'm', 1500);
insert into salary values(3, 'C', 'f', 5500);
insert into salary values(4, 'D', 'm', 500);

select * from salary;

-- 换所有的 f 和 m 值（例如，将所有 f 值更改为 m，反之亦然）
UPDATE salary
SET
    sex = CASE sex
              WHEN 'm' THEN 'f'
              ELSE 'm'
        END;
-- UPDATE salary SET sex = replace(sex,'m','123');