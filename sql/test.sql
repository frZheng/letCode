
drop table if EXISTS Employee;
drop table if EXISTS Salary;
create table Employee(
    EmployeeId int,
    Name varchar(50),
    Age int,
    Email varchar(50),
    Level int
);
create table Salary(
    SalaryId int,
    EmployeeId int,
    Money DOUBLE,
    Date Datetime
);

insert into Employee VALUES(3,'c', 30,'333@234',1);
insert into Employee VALUES(1,'a', 10,'111@234',1);
insert into Employee VALUES(2,'b', 20,'222@234',1);
insert into Employee VALUES(4,'d', 30,'444@234',1);
insert into Employee VALUES(5,'e', 62,'444@234',2);

insert into Salary VALUES(1,1, 300,'2020-01-01');
insert into Salary VALUES(2,1, 400,'2020-02-01');
insert into Salary VALUES(3,2, 200,'2020-02-01');
insert into Salary VALUES(4,5, 100,'2020-03-01');
insert into Salary VALUES(5,5, 120,'2020-04-01');

-- 查询所有员工的姓名和邮箱，并按照年龄降序、姓名升序排序：
SELECT
    Name,Email
FROM
    Employee e
ORDER BY Age DESC,
         Name ASC ;


-- 查询员工级别为1的所有员工的姓名及其对应的工资金额总和；

SELECT e.Name name, sum(s.Money) FROM Salary s left join Employee e on s.EmployeeId = e.EmployeeId
    group by e.EmployeeId


-- 查询所有高于平均工资的工资发放信息以及对应的员工信息（发放日期、工资金额、员工d、员工姓名、员工年龄、员工邮箱、员工级别)
SELECT s.Date d,s.Money money, s.EmployeeId employeeId, e.Name name, e.Age age, e.Email email, e.Level level
FROM Salary s left join Employee e on s.EmployeeId = e.EmployeeId
where s.Money > (select AVG (s1.Money) from Salary s1)
