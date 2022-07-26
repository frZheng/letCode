-- https://leetcode.cn/problems/biggest-window-between-visits
drop table if EXISTS UserVisits;
Create table If Not Exists UserVisits (user_id int, visit_date date);

insert into UserVisits values (1,'2020-11-28');
insert into UserVisits values (1,'2020-10-20');
insert into UserVisits values (1,'2020-12-3');
insert into UserVisits values (2,'2020-10-5');
insert into UserVisits values (2,'2020-12-9');
insert into UserVisits values (3,'2020-11-11');
select * from UserVisits;

select user_id,diff(max(visit_date),min(visit_date)) biggest_window from UserVisits group by user_id;
