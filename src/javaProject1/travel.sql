show tables;

create table member(
	idx int not null auto_increment primary key, -- 회원고유번호
	name varchar(20) not null, 					  -- 성명
	nickName varchar(40) not null, 				  -- 닉네임
	email varchar(50) not null,					  -- 이메일주소
	age int not null,							  -- 나이
	password int not null,						  -- 패스워드
	phoneNum varchar(20) not null				  -- 전화번호
);

desc member;

create table travelList(
	area varchar(20) not null,		-- 지역 이름
	name varchar(20) not null,		-- 여행지 이름
	address varchar(50) not null, 	-- 여행지 주소
	hashTag1 varchar(20) not null, 	-- 해쉬태그1
	hashTag2 varchar(20) not null, 	-- 해쉬태그2
	hashTag3 varchar(20) not null, 	-- 해쉬태그3
	foodf varchar(20) not null,		-- 음식점1
	foodfK varchar(20) not null, 	-- 음식점1의 종류
	foods varchar(20) not null,		-- 음식점2
	foodsK varchar(20) not null, 	-- 음식점2의 종류
	foodt varchar(20) not null,		-- 음식점3
	foodtK varchar(20) not null 	-- 음식점3의 종류
);

desc travelList;