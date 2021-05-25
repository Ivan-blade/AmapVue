create table record(
 id varchar(10),
 longitude varchar(20),
 latitude varchar(20),
 height varchar(20),
 cur_date date,
 cur_time time,
 index(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
