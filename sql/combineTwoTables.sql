-- web https://leetcode-cn.com/problems/combine-two-tables

drop table if EXISTS Person;
Create table If Not Exists Person (personId int, firstName varchar(255), lastName varchar(255))
drop table if EXISTS Address;
Create table If Not Exists Address (addressId int, personId int, city varchar(255), state varchar(255))
Truncate table Person
insert into Person (personId, lastName, firstName) values ('1', 'Wang', 'Allen')
insert into Person (personId, lastName, firstName) values ('2', 'Alice', 'Bob')
Truncate table Address
insert into Address (addressId, personId, city, state) values ('1', '2', 'New York City', 'New York')
insert into Address (addressId, personId, city, state) values ('2', '3', 'Leetcode', 'California')

select FirstName, LastName, City, State from Person a left join Address b on a.PersonId = b.PersonI