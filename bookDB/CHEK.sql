create table book(
  bookID number primary key,
  name varchar2(64) not null unique,
  author varchar(64) not null unique,
  publisher varchar(32) not null unique,
  price number not null
);

create sequence book_seq start with 1 
                         increment by 1 
                         maxvalue 99999 
                         nocycle nocache noorder;

DROP sequence book_seq; -- delete
 
-- C                         
-- insert into book (bookID, name, author, publisher, price)
-- values (bookID, '이름', '저자', '출판사', 가격숫자);

-- R
select * from book;
-- select * from book where bookID = 'bookID숫자'; 

-- U
-- set bookID = 'bookID', name = '이름' , author = '저자', publisher = '출판사', price = 가격숫자;
-- set bookID = 'bookID', name = '이름' , author = '저자', publisher = '출판사', price = 가격숫자  where bookID = bookID;

-- D
-- delete book;
-- delete book where bookID = 'bookID숫자';
