

drop table if Exists guaranteeSlip;
create table if not Exists guaranteeSlip
(guaranteeNum varchar(20),
 guaranteeType varchar(20),
 guaranteeSC varchar(20),
 agency varchar(20),
 cost int,
 gender varchar(20)
    );


insert into guaranteeSlip values ('0000101', '重疾险', '上海','000001',10000,'女');
insert into guaranteeSlip values ('0000103', '重疾险', '北京','000002',50000,'女');
insert into guaranteeSlip values ('0000102', '年金险', '北京','000012',2000,'男');
insert into guaranteeSlip values ('0000104', '年金险', '上海','000013',1000,'男');
insert into guaranteeSlip values ('0000105', '年金险', '深圳','000014',1000,'男');
insert into guaranteeSlip values ('0000106', '年金险', '北京','000015',500,'男');

select * from guaranteeSlip;
--
-- select t1.guaranteeSC, t1.`年金保费`,t2.`重疾保费`,t3.`男性投保人人数`,t4.`女性投保人人数` from
-- (select sum(cost) as `年金保费`, guaranteeSC
-- from guaranteeSlip
-- where guaranteeType='年金险'
-- group by guaranteeSC) t1
-- full join
-- (select sum(cost) as `重疾险`, guaranteeSC
-- from guaranteeSlip
-- where guaranteeType='重疾险'
-- group by guaranteeSC) t2
-- on t1.guaranteeSC=t2.guaranteeSC
-- full join
-- (select count(cost) as `男性投保人人数`, guaranteeSC
-- from guaranteeSlip
-- where gender='男'
-- group by guaranteeSC) t3
-- on t1.guaranteeSC=t3.guaranteeSC
-- full join
-- (select count(cost) as `女性投保人人数`, guaranteeSC
-- from guaranteeSlip
-- where gender='女'
-- group by guaranteeSC) t4
-- on t1.guaranteeSC=t4.guaranteeSC



-- select t1.guaranteeSC, t1.`年金保费`,t2.`重疾险`,t3.`男性投保人人数`,t4.`女性投保人人数` from
-- select sum(cost) as `年金保费`, guaranteeSC
-- from (
--     select * from guaranteeSlip group by guaranteeSC) t1
-- where guaranteeType='年金险';

-- t2 as (select sum(cost) as `重疾险`, guaranteeSC
-- from guaranteeSlip
-- where guaranteeType='重疾险'
-- group by guaranteeSC);
-- on t1.guaranteeSC=t2.guaranteeSC
-- full join
-- (select count(cost) as `男性投保人人数`, guaranteeSC
-- from guaranteeSlip
-- where gender='男'
-- group by guaranteeSC) t3
-- on t1.guaranteeSC=t3.guaranteeSC
-- full join
-- (select count(cost) as `女性投保人人数`, guaranteeSC
-- from guaranteeSlip
-- where gender='女'
-- group by guaranteeSC) t4
-- on t1.guaranteeSC=t4.guaranteeSC

select
    guaranteeSC as `分公司`,
    sum(case when guaranteeType='年金险' then cost else 0 end) as `年金保费`,
    sum(case when guaranteeType='重疾险' then cost else 0 end) as `重疾保费`,
    sum(case when gender='男' then 1 else 0 end) as `男性投保人人数`,
    sum(case when gender='女' then 1 else 0 end) as `女性投保人人数`

from guaranteeSlip group by guaranteeSC;

-- with t1 as (select sum(cost) as `年金保费`, guaranteeSC
-- from guaranteeSlip
-- where guaranteeType='年金险'
-- group by guaranteeSC)
--
--
-- with t2 as (select sum(cost) as `重疾保费`, guaranteeSC from guaranteeSlip where guaranteeType='重疾险' group by guaranteeSC)
--
-- SELECT * FROM t1 a LEFT JOIN t2 b ON a.guaranteeSC=b.guaranteeSC
-- UNION DISTINCT
-- SELECT * FROM t2 a RIGHT JOIN t1 b ON a.guaranteeSC=b.guaranteeSC
--
-- with tmp as (select * from guaranteeSlip)

-- select sum(cost) as `年金保费`, guaranteeSC
-- from guaranteeSlip
-- where guaranteeType='年金险'
-- group by guaranteeSC) t1



-- select
-- total.guaranteeSC,
-- case when 0<total.tmp<=1 then total.tmp1 else 0 end as `年金保费`,
-- case when 1<total.tmp<=2 then total.tmp1 else 0 end as `重疾保费`,
-- case when 2<total.tmp<=3 then total.tmp1 else 0 end as `男性投保人人数`,
-- case when 3<total.tmp<=4 then total.tmp1 else 0 end as `女性投保人人数`
-- -- *
-- from (
-- select sum(cost) as tmp1, guaranteeSC, 1 as tmp
-- from guaranteeSlip
-- where guaranteeType = '年金险'
-- group by guaranteeSC
-- union
-- select sum(cost) as tmp1, guaranteeSC,2 as tmp
-- from guaranteeSlip
-- where guaranteeType='重疾险'
-- group by guaranteeSC
-- union
-- select count(cost) as tmp1, guaranteeSC,3 as tmp
-- from guaranteeSlip
-- where gender='男'
-- group by guaranteeSC
-- union
-- select count(cost) as tmp1, guaranteeSC,4 as tmp
-- from guaranteeSlip
-- where gender='女'
-- group by guaranteeSC
-- ) as total
-- group by guaranteeSC




-- SELECT * FROM (
-- select sum(cost) as `年金保费`, guaranteeSC
-- from guaranteeSlip
-- where guaranteeType='年金险'
-- group by guaranteeSC
-- )a LEFT JOIN (
-- select sum(cost) as `重疾险`, guaranteeSC
-- from guaranteeSlip
-- where guaranteeType='重疾险'
-- group by guaranteeSC
-- )b ON a.guaranteeSC=b.guaranteeSC
-- UNION DISTINCT
-- SELECT * FROM (
-- select sum(cost) as `年金保费`, guaranteeSC
-- from guaranteeSlip
-- where guaranteeType='年金险'
-- group by guaranteeSC
-- )a RIGHT JOIN (
-- select sum(cost) as `重疾险`, guaranteeSC
-- from guaranteeSlip
-- where guaranteeType='重疾险'
-- group by guaranteeSC
-- )b ON a.guaranteeSC=b.guaranteeSC

