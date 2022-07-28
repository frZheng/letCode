-- https://leetcode.cn/problems/the-most-recent-orders-for-each-product

drop table if EXISTS Schools;
Create table If Not Exists Schools (school_id int, capacity int);
drop table if EXISTS Exam ;
Create table If Not Exists Exam (score int, student_count int);

insert into Schools values (11,151);
insert into Schools values (5,48);
insert into Schools values (9,9);
insert into Schools values (10,99);
select * from Schools;

insert into Exam values (975,10);
insert into Exam values (966,60);
insert into Exam values (844,76);
insert into Exam values (749,76);
insert into Exam values (744,100);
select * from Exam;



select
    s.school_id,ifnull(min(e.score),-1) score
from
    -- 连接的方式非常神奇
    Schools s left join Exam e on s.capacity >= e.student_count
group by s.school_id -- group by 是为了min的时候能按照学校来min,不然就是全局min