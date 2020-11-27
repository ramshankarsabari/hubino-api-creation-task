insert into role(id,rolename) values(1,'Admin');
insert into role(id,rolename) values(2,'Employee');

insert into department(id,deptname) values(1001,'ECE');
insert into department(id,deptname) values(1002,'CSE');
insert into department(id,deptname) values(1003,'IT');

insert into users(id, name, email, password, role_id, department_id) values(10,'abc','abc@gmail.com','abc',2,1002);
insert into users(id, name, email, password, role_id, department_id) values(20,'admin','admin@gmail.com','admin',1,1001);

insert into address(id,city,country,state,users_id) values(101,'Chennai','India','Tamilnadu',10);
insert into address(id,city,country,state,users_id) values(102,'Madurai','India','Tamilnadu',20);