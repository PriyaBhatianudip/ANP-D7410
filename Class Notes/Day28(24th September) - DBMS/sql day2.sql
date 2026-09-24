create table department(dept_id int primary key, deptname 
varchar(50) not null, managername varchar(50), 
nemployees int);
create table employee(empid int primary key auto_increment,
 empname varchar(50), age int, salary float, deptid int, 
 foreign key (deptid)  references department(dept_id));
 
 insert into department values(201, "Accounts", "Ritik Singh", 25);
 insert into department values(202, "Sales", "Danish Rizwan", 15);
 
 insert into employee(empname, age,salary, deptid) 
 values("Aryan", 22, 56000, 201);
insert into employee(empname, age,salary, deptid) 
 values("Priyanshu", 22, 44000, 202);
 
insert into employee(empname, age,salary, deptid) 
 values("Robin", 20, 24000, 202);

-- to see all the records of a table
select * from employee;
select * from department;
INSERT INTO users
(name, email, phone, password, city, created_at)
VALUES
('Aarav Sharma', 'aarav.sharma@gmail.com', 9876543210, 'Aarav@123', 'Delhi', CURRENT_TIMESTAMP),
('Priya Verma', 'priya.verma@gmail.com', 9876543211, 'Priya@123', 'Mumbai', CURRENT_TIMESTAMP),
('Rahul Kumar', 'rahul.kumar@gmail.com', 9876543212, 'Rahul@123', 'Bengaluru', CURRENT_TIMESTAMP),
('Sneha Gupta', 'sneha.gupta@gmail.com', 9876543213, 'Sneha@123', 'Pune', CURRENT_TIMESTAMP),
('Rohan Mehta', 'rohan.mehta@gmail.com', 9876543214, 'Rohan@123', 'Gurugram', CURRENT_TIMESTAMP),
('Ananya Singh', 'ananya.singh@gmail.com', 9876543215, 'Ananya@123', 'Noida', CURRENT_TIMESTAMP),
('Vikash Yadav', 'vikash.yadav@gmail.com', 9876543216, 'Vikash@123', 'Jaipur', CURRENT_TIMESTAMP),
('Neha Kapoor', 'neha.kapoor@gmail.com', 9876543217, 'Neha@123', 'Chandigarh', CURRENT_TIMESTAMP),
('Amit Joshi', 'amit.joshi@gmail.com', 9876543218, 'Amit@123', 'Hyderabad', CURRENT_TIMESTAMP),
('Kavita Rao', 'kavita.rao@gmail.com', 9876543219, 'Kavita@123', 'Chennai', CURRENT_TIMESTAMP); 
 -- -------------------------------------------------
 -- Fiter queries
 -- distinct :  returns only unique records 
 -- select distinct colname from tablename
select distinct city from users;
select city from users;
select * from users where city="Jaipur";

select * from users where city="Jaipur" 
and created_at='2026-09-24 17:14:27';

select * from users where city="Delhi" or city ="Mumbai";
select * from users where not(city="Delhi" or city ="Mumbai");

select * from users order by name;
select * from users order by name, password desc, phone;

update users set email="neha_kapoor@gmail.com" 
where userid=6;

select userid, name, email from users order by name desc;
select * from employee;

alter table employee add password varchar(50);
alter table employee add constraint pwd1 unique (password);

-- used in postgre sql
-- alter table employee alter column salary set not null;

-- Microsoft SQL Server
-- alter table employee alter column salary float not null;

alter table employee modify salary float not null; 
update employee set password  = concat(empname, '@', empid);
select * from employee;