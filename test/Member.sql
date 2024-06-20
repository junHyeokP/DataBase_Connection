create table member (
    no number primary key
    ,id varchar(64) not null unique
    ,password varchar(64) not null 
    ,nickname varchar(32) not null unique
    ,regdate date not null
);

drop table member;


--시퀀스 생성
create sequence member_seq 
          start with 1 
          increment by 1
          maxvalue 99999
          nocycle nocache noorder;
          
DROP sequence member_seq; -- delete          
          
SELECT * FROM user_sequences;

-- 시퀀스에서 마지막으로 생성한 번호 확인 (시퀀스 생성 후 바로 사용하면 오류 발생 <- 번호가 만들어진 적이 없음)
SELECT member_seq.currval FROM DUAL; -- 현재 (current value) 값

select member_seq.nextval from dual; -- 다음 (next value) 값

insert into member (no, id, password, nickname, regdate)
values (member_seq.nextval, 'id001', 'pwd001', 'nick001', sysdate);

insert into member (no, id, password, nickname, regdate)
values (member_seq.nextval, 'id002', 'pwd002', 'nick002', sysdate);

-- SELECT.
select * from member;
select * from member where no = 3;

--시퀀스 행 내용 변경
update member
set password = 'pw02', nickname = 'nick02'
where no = 3;

delete member where no=3;
delete member where no=2;