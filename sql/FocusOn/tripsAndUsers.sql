

drop table if EXISTS Trips;
Create table If Not Exists Trips (Id int, Client_Id int, Driver_Id int, City_Id int, Status varchar(50),Request_at date);

insert into Trips values (1,1,10,1,'completed','2013-10-01');
insert into Trips values (2,2,11,1,'cancelled_by_driver','2013-10-01');
insert into Trips values (3,3,12,6,'completed','2013-10-01');
insert into Trips values (4,4,13,6,'cancelled_by_client','2013-10-01');
insert into Trips values (5,1,10,1,'completed','2013-10-02');
insert into Trips values (6,2,11,6,'completed','2013-10-02');
insert into Trips values (7,3,12,6,'completed','2013-10-02');
insert into Trips values (8,2,12,12,'completed','2013-10-03');
insert into Trips values (9,3,10,12,'completed','2013-10-03');
insert into Trips values (10,4,13,12,'cancelled_by_driver','2013-10-03');
select * from Trips;

drop table if EXISTS Users;
Create table If Not Exists Users (Users_Id int, Banned varchar(50),Role varchar(50));
insert into Users values (1,'No','client');
insert into Users values (2,'Yes','client');
insert into Users values (3,'No','client');
insert into Users values (4,'No','client');
insert into Users values (10,'No','driver');
insert into Users values (11,'No','driver');
insert into Users values (12,'No','driver');
insert into Users values (13,'No','driver');
select * from Users;


--  2013年10月1日至2013年10月3日 期间非禁止用户的取消率



SELECT T.request_at AS `Day`,
       -- 这里就很妙了！！！统计数量就可以用这种技巧
       ROUND(SUM(IF(T.STATUS = 'completed',0,1))/COUNT(T.STATUS),2) AS `Cancellation Rate`
FROM trips AS T
WHERE
        T.Client_Id NOT IN (
        SELECT users_id
        FROM users
        WHERE banned = 'Yes'
    )
  AND
        T.Driver_Id NOT IN (
        SELECT users_id
        FROM users
        WHERE banned = 'Yes'
    )
  AND T.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY T.request_at