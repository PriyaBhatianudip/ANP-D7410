Abstraction

\-----------

\->  interface

\->  abstract class :  it is a restricted class that cannot be instantiated directly using the new keyword. It is used to define a common template or base structure that child classes must extend or implement.

\->  It must be declared with an abstract keyword.

&#x09;abstract class Calculator

&#x09;{}

\->  it cannot be instantiated eg. we can't use this statement

&#x09;Calculator calc=**new Calculator(); wrong statement**

\->  We can create abstract and non-abstract, both kind of methods in an abstract class.

\->  These classes can have constructors which are called when child class object is created.

\->  It can contain final, static and non-static variables

\->  an abstract class is not useful until any child class is there.

Syntax:

abstract class Calculator

{

&#x09;variables



&#x09;abstract returntype methodname(parameters);



&#x09;normal methods

}



class calc extends Calculator

{

&#x09;it is compulsory for the child class to implement/override the abstract method in child class



}





\-> can we declare a constructor as private? if yes, then how will you initialize the object.

\-> Can we avoid implementing abstract methods in a class?

\-> how is it possible?



Then how will we create the object or initialize it?

\-> Difference between an interface and a class.



