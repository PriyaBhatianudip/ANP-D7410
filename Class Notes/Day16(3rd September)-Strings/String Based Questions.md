Q1. Reverse a string

input : Hello  olleH

input : Hello World ->  dlroW olleH

input : Hello World ->  olleH dlroW

0      1  2    3      4  5

Delhi is the capital of India

str= ihleD si eht latipac fo aidnI



0\. create an empty string(optional)

1\. split string into an array of words.

2\. access each word one by one

3\. when accessing the word, reverse individual word.

4\. either save this word in the new string or back in the array at

same index.

5\. if we have an array, the join all the words together in a string.



String words\[]=str.split(" ");



String ss = String.join(words," ");







Q2. check whether a string is anagram or not.

input :  silent   listen

sb.reverse();



if both strings contain same characters, then they are anagram

Q3. check whether a string is palindrome or not.

input :  nitin   output:  nitin

malayalam



Q4. Count the number of words in a string.

Q5. write a program to remove duplicate characters from a string.

&#x09;input :  hello java output: helo jav

Q6. find the longest word in a sentence.

Q7. find the most frequent character in a string.

Q8. find the first non-repeating character.

Q9. check if a string is a rotation of another string or not.

&#x09;input : waterbottle       output : ewaterbottl

Q10. write a program to check whether two strings are isomorphic strings or not.

Two strings are isomorphic if:

* Each character in s1 must always map to the same character in s2.
* No two different characters in s1 can map to the same character in s2.
* A character may map to itself.

Example:

s1= aab   s2= xxy

True



s1 = aab  s2=xyz false

s1 = abc  s2= xxz  false

