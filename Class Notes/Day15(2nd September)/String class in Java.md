**String class**

**--------------**

**String:**  a collection or sequence of characters.

String Class : it is an inbuilt class of java,

which enables us to create string objects. It is also

known as Non-primitive data type.

these objects store a sequence of characters in

array format internally.

\->  String is immutable in nature which means

we can't change a string after it is created.





String name="Ajay singh";  ->  String literals

String name = new String("Ajay Singh"); -> object



String literals : it creates a pointer variable, which

points to the value in string constant pool. if we 

are creating multiple literals with the same value. 

Then all the literals will be referring to similar reference.

String city1 ="Delhi"  ->  x101

String city2 = "Delhi"  -> x101

String city3 = "Gurgaon" -> x105



String objects :  it aligns a new memory reference each time an object is getting created. Even if they contain the same value.



System.identityHashCode():  it returns the hashcode which uniqly identifies an object.



var = System.identityHashCode(obname)



String Constructors

\-------------------

Constructor Syntax

String()   -> default

String(String original) -> string with a value

String(char\[] value)  -> string from char array

String(char\[] value, int offset, int count)

\-> to add a sub string, we will be using above constructor

String(byte\[] bytes)-> string from byte array.

String(byte\[] bytes, int offset, int length)

String(byte\[] bytes, Charset charset)

String(byte\[] bytes, int offset, int length, Charset charset)

\-----------------------------------------------------------

**Q1. Reverse a string** 

**input : Hello  olleH**

**input : Hello World ->  dlroW olleH**

**input : Hello World ->  olleH dlroW**

**Q2. check whether a string is anagram or not.**

**input :  silent   listen**

**sb.reverse();**



if both strings contain same characters, then they are anagram

Q3. check whether a string is palindrome or not.

Q4. Count the number of words in a string.

Q5. write a program to remove duplicate characters from a string.

&#x09;input :  hello java output: helo jav

Q6. find the longest word in a sentence.

Q7. find the most frequent character in a string.

\----------------------------------------------------



String Buffer

\-------------

StringBuffer class allows us to create string variables/objects which are mutable in nature, whose value can change. String buffer is synchronized.

which means that at a time only one thread can work on it. No other thread can use it until first thread finishes its task.



StringBuffer()

StringBuffer(int size)

StringBuffer(String str)



Methods :-

\---------

1. append():  it will add a new string at the end of the existing string.
2. insert():  it will add a new string at the given index.
3. replace(): to replace a string with another string.
4. delete():  to delete a sequence of characters or substring from a string.
5. reverse(): it will reverse a string.
6. capacity():  it returns the current capacity of  a string. the default of capacity of a stringbuffer object is 16. But if start adding more characters or words, then it increases in size. it doubles in size. 

&#x09;(currentcapacity\*2)+2



StringBuilder

\--------------

It is also used to create a mutable string in java. Its contents can be modified. it is non-syncronized in nature.



StringBuilder()

StringBuilder(int size)

StringBuilder(String str)

StringBuilder(CharSequence cs)



Methods:-

append()

insert()

replace()

delete()

deleteCharAt()

reverse()

charAt()

setCharAt()

length()

capacity()

ensureCapacity()

substring()

subSequence()

indexOf()

lastIndexOf()

setLength()

getChars()

toString()



String Tokenzier

\----------------

StringTokenizer is used to break a string into smaller parts called tokens.

When we start traversing the tokens one by one. it will remove those tokens from the object.

Constructor

\-----------

StringTokenizer(String str) eg Welcome to Anudip foundation->

&#x09;Welcome - 1

&#x09;to   - 2

&#x09;Anudip - 3

&#x09;foundation - 4 

StringTokenizer(String str, String delim)

StringTokenizer(String str, String delim, boolean returnDelims)



