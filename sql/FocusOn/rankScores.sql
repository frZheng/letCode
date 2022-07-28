-- https://leetcode.cn/problems/rank-scores
drop table if EXISTS Scores;
Create table If Not Exists Scores (id int, score decimal(9,2));


insert into Scores values (1,3.50);
insert into Scores values (2,3.65);
insert into Scores values (3,4.00);
insert into Scores values (4,3.85);
insert into Scores values (5,4.00);
insert into Scores values (6,3.65);
select * from Scores;

select Score, dense_rank() over(order by Score desc) `rank` from Scores



