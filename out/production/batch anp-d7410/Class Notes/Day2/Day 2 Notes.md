**Data Types**

**----------**

1. **Primitive Datatypes**

   * **the value is getting stored directly in the memory.**
   * **Primary data types**
   * **it has a fixed size for every variable**
2. **Non-Primitive Datatypes**

   * **the value is stored at the object reference.**
   * **the size of the variables can grow or shrink.**





**Example of non primitive datatype**

**->String**



**Wrapper Class**

**these are classes that wrap(encapsulate) primitive data types into objects. They are part of java.lang package.**

**Integer  -> int**

**Byte     -> byte**

**Short 	-> short**

**Float - float**

**Double -> double**

**Character -> char**

**Boolean -> boolean**



**int a=10;**

**Integer a=3345;**



**32.8383843 = double**

**float f=24.244f;**

**c language uses ASCII(American Standard code for Information Interchange) code scheme to store characters. ascii has the size of 1 byte as it has range of 256 characters.**



**Q write a program to calculate the bonus from salary.**

**salary = 35800;**

**percentage = 12.5;**



**bonus=?**

**-----------------------------------**

**Operators in Java**

**-----------------**

**To perform operations over the value of variables, we use operators**

1. **Arithmetic operators**

&#x09;**+: add  -:subtraction \*:Multiplication**

&#x09;**/: division   %: modulus(remainder after division)**



**2. Assignment Operator:  to assign a value into a variables.**

&#x09;**= it assigns the rhs value into the variables  a=23.**

&#x09;**+= :  it will add and then assign the value.   a+=10 = a=a+10**

&#x09;**-= : it will subtract and the assign the value a-=10  = a=a-10**

&#x09;**\*=: a\*=10  = a=a\*10**

&#x09;**/=:  a/=10  = a=a/10**

&#x09;**%=:  a%=10  = a=a%10**

**3. Relational Operators:  (comparison operator) :  it is used to compare two values. logical expressions**

**always return either true or false based on the values.**

&#x09;**>, >=, <, <=, ==, !=**



**4. Logical Operators :  these are used for joining two or more conditions together and returns a combined output.**

&#x09;**\&\&(and):it only returns true, when all the conditions are true, otherwise it returns false.**

&#x09;		**example : we need to compare three numbers(a,b,c)**

&#x09;		**(a>b) \&\& (a>c)**

&#x09;	**condition1    condtion2     condition1 \&\& condition2**

&#x09;	   **true		false			false**

&#x09;	   **false	true			false**

&#x09;	   **false	false			false**

&#x09;	   **true		true			true**





&#x09;**||(or) : it returns true, when any of the conditions is true. it returns false only when all the conditions 		are false. eg. condition1 || condition2**



&#x09;	**condition1    condtion2     condition1 || condition2**

&#x09;	   **true		false			true**

&#x09;	   **false	true			true**

&#x09;	   **false	false			false**

&#x09;	   **true		true			true**



&#x09;**!(not) : it returns opposite of any boolean value. example !(a>b)**

&#x09;	**true = false**

&#x09;	**false  = true**

**Increment/decrement operator(++/--)**

**It is used to increase or decrease the value of a variable by 1.**

**a=10;**

**a++  a = 11**

**a--  a = 10**



**Post increment/decrement  (a++/a--)**

**It increments or decrements the value of a variable after completing other tasks, if available.**

**Example:-**

&#x09;**a=100,   b = a++;      b=100   a=101**

&#x09;**a=100,   b= a--;       b=100   a=99**

**Pre increment/decrement (--a/++a)**

**It first increments or decrements the value of a variable, after that it will assign the value to the task.**

**Example:-**

&#x09;**a=100,   b=++a     a=101, b=101**

&#x09;**a=100,   b=--a     a=99,  b=99**



**Equations :-**

&#x09;**1.   a=10 11, b=20 21,  c  =  a++ + b++     a=11, b=21, c=30  c=  10+20=30**

&#x09;**2.   a=10, b=10,        c  = a++ +  --b     a=11, b=9, c=19 =10+9=19**



**Bitwise Operator**

**----------------**

**It performs operations directly on the binary representation of integer values.**

1. **\& : (Bitwise and) :  it compares each bit of two numbers and returns 1 when both bits are 1.**

&#x09;**example :-**

&#x09;**0\&1  - 0**

&#x09;**1\&0  - 0**

&#x09;**0\&0  - 0**

&#x09;**1\&1  - 1**

**2. | (Bitwise or operator):  it returns 1 if at least one bit is 1**

&#x09;**example :-**

&#x09;**0|1  - 1**

&#x09;**1|0  - 1**

&#x09;**0|0  - 0**

&#x09;**1|1  - 1**

**3. Bitwise XOR (^) :  it returns 1 only when both of the bits are different.**

**example :-**

&#x09;**0^1  - 1**

&#x09;**1^0  - 1**

&#x09;**0^0  - 0**

&#x09;**1^1  - 0**

**4. Bitwise Not(\~):  It flips the bits.  1 will become 0 and 0 will become 1.**

**5. Left Shift(<<):  It shifts the bits to the left side. It returns the double of the number.**

&#x09;**Example :   a=100,   a<<1 =   200**

&#x09;		**a=100 =  1100100**  

&#x09;	**0	1	1	0	0	1	0	0**

&#x09;	**7	6	5	4	3	2	1	0**

**after shifting to the left side by 1 bit:-**

&#x09;	**1	1	0	0	1	0	0	0	=  200**

&#x09;	**7	6	5	4	3	2	1	0**





&#x09;	**a<<3= 800((a\*2)\*2)\*2)**

**6. Right Shift : (>>) It will shift the bits to the right side. whenever we shift bits to the right side, it discards the right-most bit. it returns the half of the original value after we right shift the value by 1.**

**Example :   a=100,   a>>1 =   50**

&#x09;		**a=100 =  1100100**

&#x09;	**0	1	1	0	0	1	0	0**

&#x09;	**7	6	5	4	3	2	1	0**

**after shifting to the right side by 1 bit:-**

&#x09;	0	0	**1	1	0	0	1	0	= 50**	

&#x09;	**7	6	5	4	3	2	1	0**



&#x09;	**a=100   a>>2 = 25,   a>>3=12  a>> 4=6,  a>>5= 3-> 1->0->0**



&#x20;

**7.  Ternary Operator: It is used to check a condition and it returns the first statement if the condition is true, otherwise it returns the second statement.**

**Syntax:**

&#x09;**var = condition ? true statement: false statement;**



**Example:**



&#x09;**System.out.println(a>b?"A is greater": "B is greater");**





**Scanner class :  It is an inbuilt class of java, which provides us inbuilt function to input values from the user.  For using this class, we need to import java.util package in our class.**



**byte  ->   nextByte()**

**short ->    nextShort()**

**int   ->  nextInt()**

**long  ->  nextLong()**

**float  -> nextFloat()**

**double ->  nextDouble()**

**Boolean ->  nextBoolean()**

**char ->    next().charAt(0);    ->   Yes ->  Y** 

**String ->  nextLine()**





**To use any of the above function:-**



**import java.util.Scanner;**



**class Demo**

**{**

&#x09;**public static void main(String args\[])**

&#x09;**{**

&#x09;	**Scanner sc= new Scanner(System.in);**



&#x09;	**int a = sc.nextInt();**

&#x09;**}**

**}**



**---------------------------------------------**

**Using Ternary**

**-------------**

1. **wap to determine whether a character is an alphabet, number or special character.**
2. **wap to check whether a number is negative, positive or zero.**

**3. wap to check which number is greater from given 3 numbers.**

**4. wap to check whether a triangle is scaler, isosceles or equilateral.**





