-- https://leetcode.cn/problems/number-of-calls-between-two-persons
drop table if EXISTS Calls;
Create table If Not Exists Calls (from_id int, to_id int, duration int);

insert into Calls values (1,2,59);
insert into Calls values (2,1,11);
insert into Calls values (1,3,20);
insert into Calls values (3,4,100);
insert into Calls values (3,4,200);
insert into Calls values (3,4,200);
insert into Calls values (4,3,499);

select * from Calls;

-- 用的 abs(  )  和 +:
select
    min(from_id) person1,max(to_id) person2,count(duration) call_count,sum(duration) total_duration
    -- 分组后会有 类似于 1,2 或者 2,1的数据 用 min() 和 max() 保证 person1 < person2
from
    Calls
group by abs(from_id-to_id),from_id+to_id -- 两数之差的绝对值相同,且两数之和相同,则两个数的组合是唯一的


-- 用的 if:
SELECT
    person1,person2,
    count(*) call_count,
    sum(duration) total_duration
FROM (
         SELECT
             IF(from_id>to_id, to_id, from_id) person1,
             IF(from_id>to_id,from_id,to_id) person2,
             duration
         FROM calls
     ) c
GROUP BY
    person1, person2

-- union all:
SELECT tmp.person1,tmp.person2,COUNT(1) call_count,SUM(duration) total_duration FROM(
                                                                                        SELECT from_id person1,to_id person2,duration FROM calls WHERE from_id<to_id
                                                                                        UNION ALL
                                                                                        SELECT to_id person1,from_id person2,duration FROM calls WHERE from_id>to_id
                                                                                    ) tmp
GROUP BY tmp.person1,tmp.person2



-- 用的least() 和 greatest():
select
    from_id as person1,
    to_id as person2,
    count(1) as call_count,
    sum(duration) as total_duration
from calls
group by least(from_id, to_id),greatest(from_id, to_id)