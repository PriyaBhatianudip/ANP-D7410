-- for comments use double hyphen signal
-- shortcut to run a query :  ctrl + enter
 create database TravelItenary;
 use TravelItenary;
 
 create table users(userid int primary key auto_increment,
 name varchar(50) not null, email varchar(50) unique not null,
 phone long, password varchar(100) not null, city varchar(50), 
 created_at timestamp default current_timestamp);
 
 insert into users(name, email, phone,password, city) 
 values
 ("Arshad Faraz", "arshad_faraz@gmail.com",983424242,"arshadfaraz@123", "Delhi"),
 ("Anas", "anas@gmail.com",9832824989,"anas@123", "Noida");
 -- insert at least 10 records 
 select * from users;
 
 create table destination(dest_id int primary key auto_increment, dest_name varchar(30) not null, country varchar(30) not null, state varchar(30), description varchar(100), best_time_tovisit timestamp default current_timestamp);
 
CREATE TABLE places (
    place_id INT PRIMARY KEY AUTO_INCREMENT,
    destination_id INT,
    place_name VARCHAR(100) NOT NULL,
    place_type VARCHAR(50),
    entry_fee DECIMAL(10,2) DEFAULT 0,
    rating DECIMAL(3,2)
);