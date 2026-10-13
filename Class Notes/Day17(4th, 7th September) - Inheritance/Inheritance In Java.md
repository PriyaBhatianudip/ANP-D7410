Inheritance In Java

\--------------------

It enables a class to inherit another class properties for code reusability

and better performance. Its one of the important concepts of OOPs.

In Java, we have 3 types of Inheritance:-

1\. Single Inheritance : we can have one parent and one child class.

2\. Multilevel Inheritance : we have inherited classes in the form of a ladder

&#x09;parent

&#x09;  |

&#x09;child

&#x09;  |

&#x09;child



Example:

&#x09;BasicPhone (call, sms)

&#x09;	|

&#x09;QwertyPhones(camera\_access, games, internetbrowser)

&#x09;	|

&#x09;SmartPhones(PlayStore,Internet)





3\. Multi child (hierarchical) : here we can have multiple child classes of a parent class.

&#x20;		parent

&#x09;	   |

&#x09;------------------------

&#x09;|	|	|	|

&#x09;c1	c2	c3	c4



Example

&#x09;	Payment(It must have a method which can be used

&#x09;   	   |    by every child class.)

&#x09;------------------------

&#x09;|	   |		|

&#x09;Credit     UPI		Cash

&#x09;card       Payments     Payments

&#x09;payments



define a user class



All three class will have their own features(methods) accordingly.

to their usage.





class parent

{}



class c1 extends parent

{}



class c2 extends parent

{}



class c3 extends parent

{}



class c4 extends parent

{}



\-> a child class inherits the properties of its parent class. 

\-> to access the attributes or properties of a sibling class, a class has its object. same level classes don't inherit each other's properties.





**4. Multiple Inheritance : it is not allowed in java due to naming conflicts and ambiguity.**

**class A**

**{}**



**class B**

**{}**



**class C extends A,B**

**{}**

**Note : this is not allowed in Java.**



Q. Why Java doesn't allow Diamond relationship?



=> To inherit a class we use extends keyword



class subclass extends parentclassname

{



}



\-> final keyword: it allows us to define class, methods, variables as final.

&#x09;-> final class : if a class is defined final, then it can't be 

&#x09;		inherited.

&#x09;	final class demo

&#x09;	{}



&#x09;-> final variable :  then the value of the variable can't be changed.

&#x09;			final variable has to be defined with a value.

&#x09;			but if we wan to initialize it later, then define the value in 					the constructor. it has to be the first line of your constructor.

&#x09;		final datatype varname=value;

&#x09;		final datatype varname;

&#x09;		constructor()

&#x09;		{

&#x09;			var=value;  final variable value

&#x09;		}



&#x09;-> final method :  them the method can't be overridden.

&#x09;	final void methodname()

&#x09;	{

&#x09;		dfdf

&#x09;	}



\-> this :   it represents the current class object. To eliminate naming conflicts , when a method or constructor has the same name parameters as class variables, then we can use this keyword to recognize the class level variables. it can also be used to access same class

methods or variables.



\-> super : it refers to the reference of parent class. it can be used to call parent class constructor, method or variable(if there is naming conflicts).



