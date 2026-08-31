static functions/variables

array of objects





\- aptitude prep- average(2 MCQ set)

\- AJP\_MCQ -  java basics, control statements

\- Lab1- atm,

\- Lab2- array programs

\------------------------------------------

Static Keyword

\---------------

It is a non-access modifier, which belongs to a specific

class, rather than object. Which means:-

&#x09;- a static member can be called in or by a static member.

&#x09;- a static member always occupies memory in class, rather than object

&#x09;- if you want to access a static member from non-static member, then we can access it using the class name.

There are three ways in which we can declare a static member

&#x09;- static variable : it is declared inside class.

&#x09;- static method: a method declared with static keyword is a static method, which can't hold any memory inside an object.

&#x09;- static block: it is a special block which can be loaded and executed when the class is being loaded.



Q1. what is the difference between static block and a constructor?

\- static block will be executed once upon loading of the class but constructor can be called every time an object is being created.

\- constructor is used for object initialization, but static block is used for initializing class level variables, objects, printing statements etc.

\- if an object is set to null(classname ob=null), then we can't use that object for any task, but constructor gets to do its task when class is loading in memory.

Q2. copy constructor?

Ans-  A copy constructor is a special type of constructor which is used to create a new object by copying the variables of an existing object.

Q3. What is the difference between static and instance variables?

Q4. Can we overload a static method in Java?

\--------------------------------------------

**Array of Objects**

**----------------**

**an array which can store multiple objects.**



**Syntax:**

**classname arrayname\[]=new classname\[size];**

**classsname arrayname\[];**

**later**

**arrayname=new classname\[size];**



**Example**

**class Employee{id, name, age, city}**

**array**

**0		1		2		3		4**

**101		102		103**

**abc		dkd		hh**

**23		23		45**

**delhi		Gurgaon		Noida**



Employee employeelist\[]=new Employee\[5];



find the city of id= 103

employees\[3].city



First create an object of employee

insert values into this object

then add it to array current index  emplist\[i]=empob;

