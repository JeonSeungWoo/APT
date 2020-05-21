
create table tbl_payFile(
pfno int PRIMARY key,
title varchar(50) not null,
content varchar(50) not null,
pay int not null,
userid varchar(50) not null,
regdate varchar(50) not null,
updatedate varchar(50)
);

CREATE SEQUENCE seq_tbl_payFile START 1;

create table tbl_payFile_file(
pffno int PRIMARY key,
pfno int not null,
path varchar(200) not null,
filename varchar(300) not null,
regdate varchar(50) not null,
updatedate varchar(50)
);

CREATE SEQUENCE seq_tbl_payFile_file START 1;



create table tbl_freeFile(
ffno int PRIMARY key,	
title varchar(50) not null,
content varchar(50) not null,
userid varchar(50) not null,
regdate varchar(50) not null,
updatedate varchar(50)
);

CREATE SEQUENCE seq_tbl_freeFile START 1;


create table tbl_freeFile_file(
fffno int PRIMARY key,
ffno int not null,
path varchar(200) not null,
filename varchar(300) not null,
regdate varchar(50) not null,
updatedate varchar(50)
);

CREATE SEQUENCE seq_tbl_freeFile_file START 1;