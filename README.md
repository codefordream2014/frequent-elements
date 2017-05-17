# most frequent-elements in a given array

Given a array of char, return the k most frequent elements

For example,

Given ['1','1','1','2','2','3'] and k = 2, return ['1','2'].

If the array is empty , return the empty array.

Usage:

//Initialize the given array

Object[] charsArray = {'0', '1', '1', '0', '2', '0', '0', '1', '5', '6', '9', '8'};

//specify the k

int k = 3;

//Get the result

Object[] resultArray = ArrayHelper.getMostFrequentElementsOfK(charsArray, k);

//Print the result array

System.out.println(Arrays.toString(resultArray));


Note:

Please refer to the unit test for more detail usage.


The implmentation step is as following:

1.Loop the obj array, count each element
  and put the count in LinkedHashMap(key is the element,value is the number of times)

2.Convert the LinkedHashMap to ArrayList

3.Sort the ArrayList with Collections.sort

4.Return the top rank of K in the ArrayList
