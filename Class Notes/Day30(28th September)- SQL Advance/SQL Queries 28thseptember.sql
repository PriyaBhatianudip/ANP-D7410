-- delete query
delete from employee where empid=3;
select * from employee;
-- limit clause
select * from users limit 4, 5;

select sum(salary) as Total_Salary from employee;
select min(salary) as Minimum_Salary from employee;

select count(userid) as Total_Records from users;
select count(userid) as Total_Records from users where city="Jaipur";

select * from users where email like '%gmail%';
select * from users where city in ("Delhi", "Gurgaon", "Mumbai");
select * from users where userid between 2 and 10;
