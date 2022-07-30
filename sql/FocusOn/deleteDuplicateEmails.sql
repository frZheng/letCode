-- web: https://leetcode-cn.com/problems/delete-duplicate-emails
drop table if EXISTS Person;
Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'john@example.com');
insert into Person (id, email) values ('2', 'bob@example.com');
insert into Person (id, email) values ('3', 'john@example.com');

select * from Person;
-- 删除 所有重复的电子邮件，只保留一个id最小的唯一电子邮件。
-- 个数大于1, 最小id
delete from Person
where Email in (select * from (select Email from Person group by Email having count(*) > 1) b)
  and Id not in (select * from (select min(Id) as id from Person group by Email having count(*) > 1) a)
select * from Person;

delete from Person
where Email exists (select * from (select Email from Person group by Email having count(*) > 1) b)
  and Id not exists (select * from (select min(Id) as id from Person group by Email having count(*) > 1) a)
select * from Person;