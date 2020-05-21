create table tbl_legal_advice(
lno int PRIMARY key,
title varchar(50) not null,
content varchar(5000) not null,
answer varchar(5000),
writer varchar(50) not null,
respondent varchar(50),
regdate varchar(50) not null,
updatedate varchar(50)
);

CREATE SEQUENCE seq_legal_advice START 1;
