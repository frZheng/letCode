
drop table if EXISTS cutomer_info;
Create table If Not Exists cutomer_info (id int,cutomer_id int, gender varchar(255), age int, branch varchar(255), activate_degree float);
Truncate table cutomer_info;
insert into cutomer_info (id, cutomer_id, gender, age, branch, activate_degree) values (1,21538, 'male', 39, '北京分行',33.6);
insert into cutomer_info (id, cutomer_id, gender, age, branch, activate_degree) values (2,32414, 'male', 29, '上海分行',54.0);
insert into cutomer_info (id, cutomer_id, gender, age, branch, activate_degree) values (3,65643, 'female', 51, '北京分行',83.2);
insert into cutomer_info (id, cutomer_id, gender, age, branch, activate_degree) values (4,23715, 'female', 42, '深圳分行',37.6);
insert into cutomer_info (id, cutomer_id, gender, age, branch, activate_degree) values (5,54332, 'male', 35, '成都分行',39.8);
insert into cutomer_info (id, cutomer_id, gender, age, branch, activate_degree) values (6,21531, 'male', 56, '成都分行',77.3);
insert into cutomer_info (id, cutomer_id, gender, age, branch, activate_degree) values (7,43621, 'female', 30, '上海分行',69.6);
insert into cutomer_info (id, cutomer_id, gender, age, branch, activate_degree) values (8,1234, 'male', 39, '北京分行',33.6);
select * from cutomer_info;

drop table if EXISTS activate_pratice_detail;
Create table If Not Exists activate_pratice_detail (id int,cutomer_id int, activate_tpye varchar(255), queston_id int, `result` varchar(255), pratice_date DATE);
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (1,21538, '夏日缤纷', 111, 'wrong','2021-05-03');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (8,21538, '夏日缤纷', 111, 'wrong','2021-05-04');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (10,21538, '夏日缤纷', 111, 'right','2021-06-02');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (11,21538, '夏日缤纷', 111, 'wrong','2021-06-03');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (2,32414, '新人活动', 112, 'wrong','2021-05-09');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (3,32414, '闪电贷推广', 113, 'wrong','2021-06-15');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (4,65643, '夏日缤纷', 111, 'wrong','2021-08-13');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (5,23715, '闪电贷推广', 115, 'wrong','2021-08-13');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (6,23715, '新人活动', 116, 'wrong','2021-08-14');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (7,23715, '闪电贷推广', 117, 'wrong','2021-08-15');
insert into activate_pratice_detail (id, cutomer_id, activate_tpye, queston_id, `result`,pratice_date) values (9,1234, '夏日缤纷', 111, 'wrong','2021-05-03');

-- SELECT -1<DATEDIFF('2022-06-30','2022-06-01')<30 AS DiffDate from activate_pratice_detail;


select * from activate_pratice_detail;

-- 2021年6月参与 北京分行 夏日缤纷吗 客户参与活动模糊的总题目数和回答正确的题目数，按照总题目数倒叙排序，没有参与6月份的活动的用户，活动结果为0
select
       t1.cutomer_id,
       t1.branch,
--        [1] as question_num,
    ifnull(sum(if(-1<DATEDIFF(t2.pratice_date,'2021-06-01') and DATEDIFF(t2.pratice_date,'2021-06-01')<30,1,0)),0)  as question_num,
--        [2] asright_question_num
    ifnull(sum(if(t2.result<>'wrong' and -1<DATEDIFF(t2.pratice_date,'2021-06-01') and DATEDIFF(t2.pratice_date,'2021-06-01')<30,1,0)) ,0) asright_question_num

-- select *
from
    cutomer_info t1
--     [3] activate_pratice_detail t2 on [4]
    right join activate_pratice_detail t2 on t1.cutomer_id=t2.cutomer_id
where
    t1.branch ='北京分行'
--     and [5]
    and t2.activate_tpye ='夏日缤纷'
--     and [6]
--   and -1<DATEDIFF(t2.pratice_date,'2021-06-01')<30;
group by
--     [7]
    t1.cutomer_id
order by
--     [8]
    question_num desc ;


drop table if EXISTS clud_record;
Create table If Not Exists clud_record (id int,name varchar(255), cludId int, number int);
insert into clud_record (id,name,cludId,number) values (1,'小明',1,20);
insert into clud_record (id,name,cludId,number) values (2,'小王',1,15);
insert into clud_record (id,name,cludId,number) values (3,'小张',1,22);
insert into clud_record (id,name,cludId,number) values (4,'小明',2,30);
insert into clud_record (id,name,cludId,number) values (5,'小张',2,25);
insert into clud_record (id,name,cludId,number) values (6,'小张',2,26);
insert into clud_record (id,name,cludId,number) values (7,'小张',3,10);
insert into clud_record (id,name,cludId,number) values (8,'小明',3,12);
insert into clud_record (id,name,cludId,number) values (9,'小王',3,9);
insert into clud_record (id,name,cludId,number) values (10,'小a',3,12);
select * from clud_record;

drop table if EXISTS clud;
Create table If Not Exists clud (id int,clubName varchar(255));
insert into clud (id,clubName) values (1,'football');
insert into clud (id,clubName) values (2,'ping pong');
insert into clud (id,clubName) values (3,'basketball');
select * from clud;

select clubName, name, maxNumber
-- select *
from
    clud,
     clud_record,
     (select cludId, max(number) maxNumber from clud_record group by cludId) M
where
        clud.id=clud_record.cludId
and
        M.cludId=clud.id
and
    maxNumber=number;

