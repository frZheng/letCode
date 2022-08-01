drop table if EXISTS Employee;
CREATE TABLE If Not Exists Employee (Id INT, Company varchar(50), Salary int);

insert into Employee values (1,'A',2341);
insert into Employee values (2,'A',341);
insert into Employee values (3,'A',15);
insert into Employee values (4,'A',15314);
insert into Employee values (5,'A',451);
insert into Employee values (6,'A',513);
insert into Employee values (7,'B',15);
insert into Employee values (8,'B',13);
insert into Employee values (9,'B',1154);
insert into Employee values (10,'B',1345);
insert into Employee values (11,'B',1221);
insert into Employee values (12,'B',234);
insert into Employee values (13,'C',2345);
insert into Employee values (14,'C',2645);
insert into Employee values (15,'C',2645);
insert into Employee values (16,'C',2652);
insert into Employee values (17,'C',65);
select * from Employee;

select Id,Company,Salary
from (
         select Id,Company,Salary,
                ROW_NUMBER() over(partition by Company order by Salary) rk,
                count(*) over(partition by Company) cnt
         from Employee
     )t1
where rk IN (FLOOR((cnt + 1)/2), FLOOR((cnt + 2)/2))

-- order by是由顺序要求的,自己的解法
select Id,Company,Salary
from(
        select Id,Company,Salary,count(*) over(partition by company) rk_count,
               row_number() over(partition by company order by salary) rk
        from employee
    )tmp1
where rk between ceil(rk_count/2) and floor(rk_count/2)+1
