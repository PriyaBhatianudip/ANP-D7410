If Condition

\-------------

If is used to check a condition, if the condition is true or false, 

accordingly it executes the code written inside the block.

it is also known as control statement.

It can be used in different forms:-

1\. Simple if :  here we only have true block. if the condition is true,

then the code will be executed , otherwise nothing will happen.

if(condition)

{

&#x09;code if condition is true

}

&#x09;or

use it when we have single statement to run

if(condition)

&#x09;code



2\. if else:  it will check the condition if the condition is true, then

it runs the code which is in true block, otherwise it will run the code 

in false block.

if(condition)

{

&#x09;code if condition is true

}

else

{

&#x09;code if condition is false

}

&#x09;or

use it when we have single statement to run

if(condition)

&#x09;code

else

&#x09;code



3\. if else if : It checks the first condition, if the condition is false, 

then it will check the second condition, if it is false, then it will check the third condition, and so on. if none of the conditions are true, then it can execute the else block.

else block is optional.

&#x09;if(condition)

&#x09;{



&#x09;}

&#x09;else if(condition)

&#x09;{

&#x09;

&#x09;}

&#x09;else if(condition)

&#x09;{

&#x09;

&#x09;}

&#x09;else if(condition)

&#x09;{

&#x09;

&#x09;}

&#x09;else

&#x09;{



&#x09;}

4\. Nested if :  when we use one if condition inside another , it is known as nested if.

&#x09;if(condition1)

&#x09;{

&#x09;	if(condition2)

&#x09;	{

&#x09;		if(condition)

&#x09;		{

&#x09;		}

&#x09;	}

&#x09;}



\-----------------------------------------------------------------------------------

String Functions

1\. equals() :  it checks whether two strings have same content or not. it is case sensitive. 

&#x09;	it will check if both strings are same or not

&#x09;	string1="Hello",  string2="hello"

&#x09;Syntax:  boolean value=ob1.equals(ob2)



&#x09;	if(string1.equals(string2)) false 





2\. equalsIgnoreCase():  it is similar to equals() method, but is not case sensitive.

&#x09;Syntax:  boolean value=ob1.equalsIgnoreCase(ob2)



&#x09;	if(string1.equalsIgnoreCase(string2)) false

\-----------------------------------------------------------------------------------

Q1. Write a program to check whether a character is vowel or not. if the character is in upper case, then convert it into lower case first, and then check.

Upper to lower conversion:  



\-------------------------

Type Casting /conversion: it is used to change the type of a value to another type. it happens only in primitive types.  char to int, int to char,  double to float, float to double, float/double to int. 

datatype var = (datatype)value/variable;

char ch ='A';

int chvalue = (int)ch;  // 65



int value = 97;

char ch=(char)value; // a





\-->  if the character which is being entered is not an alphabet.

&#x09;Then program should print the error message.

\----------------------------------------------------------------------------

Questions

Q1. ATM Withdrawal Validation

Create a Java program to simulate a simple ATM withdrawal system using nested if statements.

The program should first check whether the user has entered the correct PIN. If the PIN is correct, then check whether the withdrawal amount is valid and whether sufficient balance is available.

Suggested conditions:

* Correct PIN → proceed with withdrawal
* Incorrect PIN → display "Invalid PIN"
* Withdrawal amount should be greater than 0
* Withdrawal amount should not exceed the available balance
* If valid, deduct the amount and display the remaining balance



Q2. Parking Fee Calculator

Create a Java program to calculate the parking fee based on the number of hours a vehicle is parked.



The program should accept the number of parking hours and calculate the fee according to different time slabs.



Suggested fee structure:

* Parking Hours	Fee
* Up to 2 hours		₹30
* 3–5 hours		₹50
* 6–10 hours		₹80
* More than 10 hours	₹120



Also check that the number of hours entered is valid.



Q3. Mobile Recharge Discount Calculator

Create a Java program that calculates the discount on a mobile recharge based on the recharge amount.



The program should accept the recharge amount and apply a different discount depending on the amount.



Suggested conditions:

* Recharge Amount	Discount
* Below ₹200	No discount
* ₹200–₹499	5%
* ₹500–₹999	10%
* ₹1000 or above	15%



Calculate and display:

* Original recharge amount
* Discount amount
* Final amount to be paid



Example:

If recharge amount is ₹600:



Discount = 10%

Discount Amount = ₹60

Final Amount = ₹540



4\. Student Result Based on Three Subjects

Create a Java program to calculate a student's result based on marks obtained in three subjects.



The program should accept marks for three subjects. A student must obtain at least 40 marks in each subject to pass.

If the student passes all three subjects:

* Calculate the total marks.
* Calculate the percentage.
* Display the result.



Suggested grading:



Percentage	Grade

90 and above	A

75–89		B

60–74		C

40–59		D

Below 40	Fail

