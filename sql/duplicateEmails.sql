-- web: https://leetcode-cn.com/problems/duplicate-emails
drop table if EXISTS Person;
Create table If Not Exists Person (id int, email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'a@b.com');
insert into Person (id, email) values ('2', 'c@d.com');
insert into Person (id, email) values ('3', 'a@b.com');

-- 找出重复的邮箱
select Email from Person group by Email having count(*) > 1