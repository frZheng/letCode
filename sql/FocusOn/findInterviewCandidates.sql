-- https://leetcode.cn/problems/find-interview-candidates

drop table if EXISTS Contests;
Create table If Not Exists Contests (contest_id int, gold_medal int, silver_medal int, bronze_medal int);
drop table if EXISTS Users;
Create table If Not Exists Users (user_id int, mail varchar(100), name varchar(100));
insert into Contests values (190,1,5,2);
insert into Contests values (191,2,3,5);
insert into Contests values (192,5,2,3);
insert into Contests values (193,1,3,5);
insert into Contests values (194,4,5,2);
insert into Contests values (195,4,2,1);
insert into Contests values (196,1,5,2);
select * from Contests;

insert into Users values (1,'sarah@leetcode.com','Sarah');
insert into Users values (2,'bob@leetcode.com','Bob');
insert into Users values (3,'alice@leetcode.com','Alice');
insert into Users values (4,'hercy@leetcode.com','Hercy');
insert into Users values (5,'quarz@leetcode.com','Quarz');
select * from Users;

-- 在连续三场及更多比赛中赢得任意奖牌。
-- 在三场及更多不同的比赛中赢得金牌（这些比赛可以不是连续的）

with t1 as (
    select contest_id,gold_medal id from Contests -- 所有 在比赛中 获奖的id
    union all
    select contest_id,silver_medal from Contests
    union all
    select contest_id,bronze_medal from Contests
),
t2 as (
-- 在三场及更多不同的比赛中赢得金牌
select distinct gold_medal id from Contests
group by gold_medal
having count(contest_id)>=3
) ,
t3 as (
-- 在连续三场及更多比赛中赢得任意奖牌
select distinct id from
(
select id,contest_id - row_number() over(partition by id order by contest_id) cr from t1
-- select id, row_number() over(partition by id order by contest_id) cr from t1
-- select id,contest_id cr from t1
) s1
group by id,cr having count(1)>=3 -- 记录大于3条等价于COUNT(*),COUNT(id)，


union
-- 在三场及更多不同的比赛中赢得金牌 id
select distinct id from t2
)

select
    u.name,u.mail
from
    t3 left join Users u on t3.id = u.user_id

