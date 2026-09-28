INSERT INTO employee (empname, age, salary, deptid, password)
VALUES
('Amit Sharma', 28, 45000.00, 201, 'Amit@123'),
('Priya Verma', 32, 55000.00, 202, 'Priya@123'),
('Rahul Kumar', 25, 38000.00, 203, 'Rahul@123'),
('Neha Singh', 30, 62000.00, 201, 'Neha@123'),
('Vikas Gupta', 35, 75000.00, 204, 'Vikas@123'),
('Sneha Kapoor', 27, 48000.00, 202, 'Sneha@123'),
('Rohit Mehta', 40, 90000.00, 205, 'Rohit@123'),
('Anjali Verma', 29, 52000.00, 203, 'Anjali@123'),
('Karan Malhotra', 33, 68000.00, 204, 'Karan@123'),
('Pooja Sharma', 26, 42000.00, 205, 'Pooja@123');

INSERT INTO employee (empname, age, salary, password)
VALUES
('BB', 28, 45000.00, 'bb@123');

select e.empid, e.empname,d.dept_id, d.deptname, d.managername
 from employee e inner join department d 
 on e.deptid = d.dept_id;
 
 select e.empid, e.empname,d.dept_id, d.deptname, d.managername
 from employee e join department d 
 on e.deptid = d.dept_id;
 
select e.empid, e.empname,d.dept_id, d.deptname, d.managername
 from employee e left join department d 
 on e.deptid = d.dept_id;
 
select e.empid, e.empname,d.dept_id, d.deptname, d.managername
 from employee e right join department d 
 on e.deptid = d.dept_id;
 
 -- for outer join
 select e.empid, e.empname,d.dept_id, d.deptname, d.managername
 from employee e left join department d 
 on e.deptid = d.dept_id
 union
select e.empid, e.empname,d.dept_id, d.deptname, d.managername
 from employee e right join department d 
 on e.deptid = d.dept_id;
 
 --  self join alternative
 select e1.empid, e1.empname, e2.empname as Manager_Name 
 from employee e1 left join employee e2 on
 e1.managerId = e2.empid;
 -- cross join 
 
 select * from employee cross join department;