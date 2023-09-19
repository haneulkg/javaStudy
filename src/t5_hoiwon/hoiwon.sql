show tables;

create table hoiwon (
	idx int not null auto_increment primary key,
	name varchar(20) not null,
	age int default 20, 
	address varchar(50),
	gender char(2) default '여자'
);

desc hoiwon;
select * from hoiwon;

insert into hoiwon values (default, '가가가', 41, '인천','남자');
insert into hoiwon values (default, '나나나', 21, '부산','남자');
insert into hoiwon values (default, '다다다', 37, '제주','남자');
insert into hoiwon values (default, '라라라', 21, '서울','남자');
insert into hoiwon values (default, '마마마', 74, '청주','여자');
insert into hoiwon values (default, '바바바', 40, '경주','여자');
insert into hoiwon values (default, '사사사', 27, '낭성','여자');
insert into hoiwon values (default, '아아아', 40, '경주','남자');
insert into hoiwon values (default, '자자자', 40, '경주','남자');
insert into hoiwon values (default, '차차차', 40, '경주','남자');
insert into hoiwon values (default, '카카카', 40, '경주','여자');
insert into hoiwon values (default, '타타타', 40, '경주','남자');
insert into hoiwon values (default, '파파파', 40, '경주','남자');
insert into hoiwon values (default, '하하하', 40, '경주','남자');

delete from hoiwon where name='가가가';