create table tbl_legal_advice(
lno int PRIMARY key,
title varchar(50) not null,
content varchar(5000) not null,
answer varchar(5000),
writer varchar(50) not null,
respondent varchar(50),
answerYN int not null,
regdate varchar(50) not null,
updatedate varchar(50)
);

CREATE SEQUENCE seq_legal_advice START 1;

create table tbl_service(
sno int PRIMARY key,
title varchar(50) not null,
content varchar(5000) not null,
answer varchar(5000),
writer varchar(50) not null,
respondent varchar(50),
answerYN int not null,
regdate varchar(50) not null,
updatedate varchar(50)
);

CREATE SEQUENCE seq_service START 1;


create table tbl_notice(
nno int PRIMARY key,
title varchar(50) not null,
content varchar(5000) not null,
writer varchar(50) not null,
regdate varchar(50) not null,
updatedate varchar(50)
);

CREATE SEQUENCE seq_notice START 1;




create table tbl_payment(
pno int PRIMARY key,
pfno int not null,
mno int not null,
price int not null,
regdate varchar(50) not null
);

CREATE SEQUENCE seq_tbl_payment START 1;
