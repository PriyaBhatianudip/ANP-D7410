Quick Sort

\----------

Step1 : select an element as pivot

&#x09;-  take middle value

&#x09;-  take first value

&#x09;-  take last value

Step 2:  rearrange the array into two parts

&#x09;- values which are smaller than the pivot,

&#x09;	- will go into left side of array

&#x09;- values which are greater than the pivot,

&#x09;	- will go into the right side of array

pivot =5



0	1	2	3	4	5

10	7	8	9	1	5

1	7	8	9	10	5

index = low;

low=0, high= 5, pivot=high(5)

Element 	<5	Array after operation

10		no	\[10,7,8,9,1,5]

7		no	\[10,7,8,9,1,5]

8		no	\[10,7,8,9,1,5]

9		no	\[10,7,8,9,1,5]

1		yes	\[1,7,8,9,10,5] index = low+1=0+1=1



After this iteration finishes

swap pivot value with changed position

\[1,7,8,9,10,5] ->  \[1,5,8,9,10,7]

a\[5]=pivot, index= 1

low=2 , high=5, pivot=last value= 7

\[1,5,8,9,10,7]

index=low=2

Element 	<7	Array after operation

8		no	\[1,5,8,9,10,7]

9		no	\[1,5,8,9,10,7]

10		no	\[1,5,8,9,10,7]

swap pivot value with changed position

\[1,5,8,9,10,7] -> \[1,5,7,9,10,8]

index with pivot 2 with 5



next sub array to sort \[9,10,8]

low = 3, high= 5, pivot=8, index=low

index=low=3

Element 	<8	Array after operation

9		no	\[1,5,7,9,10,8]

10		no	\[1,5,7,9,10,8]

swap pivot with low value

\[1,5,7,9,10,8] - \[1,5,7,8,10,9]

swap 3 with 5



low = 4, high= 5 pivot= 9

index=4

Element 	<9	Array after operation

10		no	\[1,5,7,8,10,9]



swap pivot element with low value

\[1,5,7,8,10,9] -> \[1,5,7,8,9,10]

swap 4 and 5



\[0 ,1 , 2, 3, 4, 5]

\[12,78,45,87,32,40]

\[78,12,45,87,32,40]1

\[78,45,12,87,32,40]2

\[78,45,87,12,32,40]3

\[78,45, 87,40,32,12]

\[87,45,78,40,32,12]

\[87,45,78,40,12,32]

low=0, high= 5





public void quicksort(arr, low, high)

{

&#x09;if(low<high)

&#x09;{

&#x09;	int pivot =partition(arr, low, high);

&#x09;	quicksort(arr, low,pivot-1);left array

&#x09;	quicksort(arr, pivot+1, high); right array

&#x09;}

}



public int partition(arr, low, high)

{

&#x09;int pivot= arr\[high]; // 40

&#x09;int index = low;  // 0

&#x09;for(j=low;j<high;j++) // j= 0 1 2 3 j<5

&#x09;{

&#x09;	if(arr\[j]>pivot) //>87 t

&#x09;	{

&#x09;		int temp= arr\[j]; // temp= 87

&#x09;		arr\[j]= arr\[index]; // arr\[3]= 12

&#x09;		arr\[index]=temp;  // arr\[2]= 87

&#x09;		**index++;// index=1 2 3**

&#x09;	}

&#x09;}

&#x09;int temp=arr\[index]; temp= 12

&#x09;arr\[index]=arr\[high];arr\[3]=40

&#x09;arr\[high]=temp;arr\[5]=12

&#x09;return index;

}

