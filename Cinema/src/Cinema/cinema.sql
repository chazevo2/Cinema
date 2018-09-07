drop table ticket;
drop table schedule;
drop table review;
drop table members;
drop table screen;
drop table movie;

drop sequence seq_movie_no;
drop sequence seq_screen_no;
drop sequence seq_review_no;
drop sequence seq_sche_no;
drop sequence seq_ticket_no;

create table movie (
mno number primary key,
mname varchar2(20),
story varchar2(50),
runtime number,
genre varchar2(20),
rate number
);

create table screen (
scrno number primary key,
line number,
seat number
);

create table members (
uname varchar2(10) not null,  
mid varchar2(20) primary key,     
pwd varchar2(20) not null,  
birth date,
point int
);

create table review (
rno number primary key,
mno number,
mid varchar(20),    
score number,  
memo varchar(100),
constraint movie_no_fk1 foreign key (mno) references movie(mno) on delete cascade, 
constraint members_id_fk foreign key (mid) references members (mid) on delete set null
);

create table schedule (
sno number primary key, 
mno number not null, 
mday date,
mtime varchar2(10), 
sprice number, 
scrno number,
ex_seat number,
constraint movie_no_fk2 foreign key (mno) references movie(mno) on delete cascade, 
constraint screen_no_fk foreign key (scrno) references screen(scrno) on delete cascade
);

create table ticket (
tno number primary key,
mid varchar2(20),
mno number,
tprice number,
sno number,
seatno varchar2(10),
constraint movie_no_fk3 foreign key (mno) references movie(mno) on delete cascade,
constraint user_no_fk foreign key (mid) references members(mid) on delete cascade,
constraint sche_no_fk foreign key (sno) references schedule(sno) on delete cascade
);

create sequence seq_movie_no nocache;
create sequence seq_screen_no nocache;
create sequence seq_review_no nocache;
create sequence seq_sche_no nocache;
create sequence seq_ticket_no nocache;