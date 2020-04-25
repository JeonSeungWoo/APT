
create table tbl_member(
mno int PRIMARY key,	
userid varchar(80), 
pw varchar(100),
name varchar(80) not null,
email varchar(200) not null,
phone int not null,
auth int not null,
sessionkey varchar(50),
sessionLimit varchar(50),
interlock_type varchar not null,
regdate varchar(50) not null,
updatedate varchar(50)
);

CREATE SEQUENCE seq_tbl_member START 1;



