create table member (
    no number primary key
    ,id varchar(64) not null unique
    ,password varchar(64) not null 
    ,nickname varchar(32) not null unique
    ,regdate date not null
);

drop table member;


--������ ����
create sequence member_seq 
          start with 1 
          increment by 1
          maxvalue 99999
          nocycle nocache noorder;
          
DROP sequence member_seq; -- delete          
          
SELECT * FROM user_sequences;

-- ���������� ���������� ������ ��ȣ Ȯ�� (������ ���� �� �ٷ� ����ϸ� ���� �߻� <- ��ȣ�� ������� ���� ����)
SELECT member_seq.currval FROM DUAL; -- ���� (current value) ��

select member_seq.nextval from dual; -- ���� (next value) ��

insert into member (no, id, password, nickname, regdate)
values (member_seq.nextval, 'id001', 'pwd001', 'nick001', sysdate);

insert into member (no, id, password, nickname, regdate)
values (member_seq.nextval, 'id002', 'pwd002', 'nick002', sysdate);

-- SELECT.
select * from member;
select * from member where no = 3;

--������ �� ���� ����
update member
set password = 'pw02', nickname = 'nick02'
where no = 3;

delete member where no=3;
delete member where no=2;