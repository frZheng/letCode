-- https://leetcode.cn/problems/sales-person/

drop table if Exists tb_clk_rcd;
create table if not Exists tb_clk_rcd
(cust_uid int,
 if_vw int,
 if_car int,
 prd_id varchar(10));
 truncate tb_clk_rcd;


insert into tb_clk_rcd values (20003, 1, 0, 'A');
insert into tb_clk_rcd values (20003, 1, 1, 'A');
insert into tb_clk_rcd values (20006, 1, 1, 'C');
insert into tb_clk_rcd values (20007, 1, 1, 'A');
insert into tb_clk_rcd values (20003, 1, 1, 'A');
insert into tb_clk_rcd values (20003, 1, 0, 'C');
insert into tb_clk_rcd values (20003, 1, 1, 'B');
insert into tb_clk_rcd values (20003, 1, 1, 'D');
insert into tb_clk_rcd values (20003, 1, 0, 'D');
insert into tb_clk_rcd values (20007, 1, 1, 'E');
insert into tb_clk_rcd values (20006, 1, 1, 'E');





select * from tb_clk_rcd;

select distinct prd_id,sum(if_car) over (partition by prd_id) from tb_clk_rcd;
select t.prd_id, round(mol/den,2) from(
                                          select distinct prd_id,sum(if_vw) over (partition by prd_id) as den,sum(if_car) over (partition by prd_id) as mol from tb_clk_rcd
                                          ) t
order by t.prd_id



