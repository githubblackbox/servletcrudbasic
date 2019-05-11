create database basic;
use basic;
desc basiccrud;
select * from basiccrud;

create table basiccrud(id int primary key auto_increment,name varchar(50),password varchar(50),fullname varchar(50));
insert into basiccrud(name,password,fullname)value('rajasekar','rajasekar1991','rajasekar selvam');
insert into basiccrud(name,password,fullname)value('sathish','sathish1991','sathish kumar');
insert into basiccrud(name,password,fullname)value('ranjith','ranjith1991','ranjith tumba');





