show tables;

/*
 	프로젝트 작업순서...
 	1. 업무분석
 	2. 요구사항설계(요구사항명세서)
 	3. 데이터베이스(테이블/필드) 설계
 	4. VO 만들기
 	5. DAO 만들기
 			: JDBC 라이브러리를 lib폴더에 복사해 넣는다.
 			: Connection/PreparedStatement/ResultSet 객체생성
 			
 	6. FrontController 만든다.(확장자 패턴사용)
 		 Interface 만든다.('execute' 메소드로 작업에 통일시킬수 있도록 메소드명을 지정해준다.) (메소드 이름 내 마음대로임)
 			
 	7. View작업을 진행하면서 DAO와 Service객체를 활용한다.
 	
 	8. 테스팅(요구사항과 매칭되는지 체크) - 메뉴얼..
 	9. 배포
 */

create table login (
	idx 	int not null auto_increment primary key, 	/* 고유번호 */
	mid 	varchar(20) not null, /* 아이디 */
	pwd		varchar(20) not null, /* 비밀번호 */
	name 	varchar(20) not null, /* 회원 성명 */
	point int default 100, 			/* 포인트(최초 가입시 100포인트 지급) */
	lastDate datetime default now(), /* 최종 접속일자 */
	vCount int default 0				/* 개별 방문자의 방문카운트 누적 */
);

desc login;
drop table login;

insert into login values (default,'admin','1234','관리자',default,default,default);
insert into login values (default,'hkd1234','1234','홍길동',default,default,default);
insert into login values (default,'kms1234','1234','김말숙',default,default,default);

select * from login;

delete from login where mid='kms1234';
delete from login;

delete from login where mid=' ddd1234';

시험문제

5)별명 붙이기
select sum(point) as '합계', avg(point) as '평균', max(point) as '최대', min(point) as '최소' from login;

6)방문카운터 20회 이상인 사람 10점씩 추가 지급
update login set point = point + 10 where vCount>=20;

7)방문날짜 내림차순, 방문날짜 같을 경우 내림차순, 포인트점수 내림차순
select * from login order by lastDate desc, vCount desc, point;

8)접속한 날짜가 같은 자료들만 그룹지어서 출력
select * from login group by lastDate;

9)200 포인터 넘는 자료들의 개수, 평균 출력, 평균 소수이하 1자리까지 출력(반올림)
select * from login where point >=100;
select avg(point) as '평균';
select count(point) as 개수, round(avg(point),1) as 평균 from login where point >=100;

10)2022년 2월 21일부터 현재날짜까지 지나간 일수를 출력하시오?
select datediff(now(), '2022-2-21');





