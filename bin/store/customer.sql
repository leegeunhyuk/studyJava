drop table customer_tb;

create table customer_tb(
id varchar2(20) primary key,
passwd varchar2(30) not null,
name varchar2(50),
age number(3),
address varchar2(128));

create table product_tb(
productId varchar2(20) primary key,
productName varchar(128),
category varchar2(50),
information varchar2(256));

create table order_tb(
id varchar2(20) not null,
productId varchar2(20) not null,
orderDate date,
quantity number,
constraint "order_pk"  primary key(id,productId));

insert into customer_tb values('kkjin@nextree.co.kr', '1234', 'Jin', 20, '����');
insert into customer_tb values('jypark@nextree.co.kr', '1111', 'Park', 25, '��õ');
insert into customer_tb values('eykim@nextree.co.kr', '7979', 'Kim', 22, '����');
insert into customer_tb values('tksong@nextree.co.kr', '0001', 'Song', 19, '����');
insert into customer_tb values('yhh@nextree.co.kr', '3535', 'Ha', 20, '�λ�');

insert into product_tb values('A0001', 'LG TV', '����', '�ٺ�����');
insert into product_tb values('A0002', '�Ｚ ��Ź��', '����', '���� �״��~~~');
insert into product_tb values('A0003', '����', '�Ƿ�', '���� �ٺ��̴� 19�� ����');
insert into product_tb values('A0004', '���ǽ�', '�Ƿ�', 'Ƣ�� ���ǽ�(������ ȸ�ǿ�)');
insert into product_tb values('A0005', '����', '����', '����� �� ����~~');
insert into product_tb values('A0006', '�ʹ�', '����', '�ͻ�� ������!!');

insert into order_tb values('eykim@nextree.co.kr', 'A0003', '2011-03-05', 2);
insert into order_tb values('kkjin@nextree.co.kr', 'A0001', '2012-05-05', 1);
insert into order_tb values('kkjin@nextree.co.kr', 'A0005', '2013-07-07', 20);
insert into order_tb values('tksong@nextree.co.kr', 'A0006', '2010-02-15', 10);
insert into order_tb values('tksong@nextree.co.kr', 'A0002', '2016-05-05', 1);
insert into order_tb values('jypark@nextree.co.kr', 'A0003', '2016-12-25', 5);

commit;

