package com.remark.helper;

import java.util.*;

/**
 * This class contains static methods for operating arrays
 *
 * @author Eric Zhang
 */
public class ArrayHelper {

    //not allowed to instantiate
    private ArrayHelper() {
    }

    /**
     * Find the k most frequent elements in one specified object array
     * Time complexity is better than O(nlogn)
     * The step is as following:
     * 1.Loop the obj array, count each element
     * and put the count in LinkedHashMap(key is the element,value is the number of times)
     * 2.Convert the LinkedHashMap to ArrayList
     * 3.Sort the ArrayList with Collections.sort
     * 4.Return the top rank of K in the ArrayList
     *
     * @param obj the source object array that need to be handled,return the null array if the array is null
     * @param k   number of most frequent elements,k must be greater than 1(K>=1)
     * @return the object array that most frequently appears in the source array for specified k number
     */
    public static Object[] getMostFrequentElementsOfK(final Object[] obj, Integer k) {

        if (null == obj || obj.length <= 0) {                                                       //短路运算 执行1次或2次
            return obj;                                                                             //执行1次或者0次
        }                                                                                           //if语句执行最多3次，属于常数级T(n)=O(1)

        if (k <= 0) {//执行1次
            throw new RuntimeException("k must be greater than 1.");                                //执行1次或者0次
        }                                                                                           //if语句执行最多2次T(n)=O(1)

        Map<Object, Integer> resultMap = new LinkedHashMap<>();                                     //LinkedHashMap实例化执行1次T(n)=O(1)
        //1. Time complexity is O(n)
        for (Object o : obj) {                                                                      //执行obj.size()+1次(也就是n+1次)T(n) = O(n+1)
            // The element has been put into the map yet
            if (resultMap.containsKey(o)) {                                                         //执行0次或者n次
                Integer update = resultMap.get(o);                                                  //执行0次或者n次
                resultMap.put(o, ++update);                                                         //执行0次或者n次（其中++update并非原子操作，至少是要执3次）
            } else {                                                                                //执行0次或者n次
                //First time to put the element to the map
                resultMap.put(o, 1);                                                                //执行0次或者n次
            }                                                                                       //省略常数项和系数，if else语句T(n) = O(n)
        }
        // Convert map.entrySet() to entryList
        List<Map.Entry<Object, Integer>> entryList = new ArrayList<>(resultMap.entrySet());         //由于Map转换Array需要循环resultMap.size()次T(n) = O(n)

        //2. Time complexity is O(nlgn)
        // Sort the entryList
        Collections.sort(entryList, new Comparator<Map.Entry<Object, Integer>>() {
            @Override
            public int compare(Map.Entry<Object, Integer> o1, Map.Entry<Object, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });                                                                                         //使用的是TimSort优化后的归并排序，排序时间复杂度：T(n)=O(n log n)

        //Set the result array size to the entryList size if k is greater than size of the list
        if (k > entryList.size()) {                                                                 //执行1次或者0次
            k = entryList.size();                                                                   //执行1次或者0次
        }                                                                                           //if语句执行1次或者0次T(n)=O(0) or T(n)=O(1)

        Object[] result = new Object[k];                                                            //初始化数组，执行1次T(n)=O(1)
        //3. Time complexity is O(n)
        for (int i = 0; i < k; i++) {                                                               //执行k+1次T(k)=O(k+1)
            result[i] = entryList.get(i).getKey();                                                  //执行k次T(k)=O(k)
        }
        return result;                                                                              //执行1次T(n)=O(1)
    }

    /**
     * 时间复杂度：
     * 根据复杂度的加法规则，将上面按顺序（实际上并非按顺序，编译器和CPU都会进行指令重排序）
     * 执行的代码的时间复杂度相加，T(n,m) = T1(n) + T2(n) = O (max ( f(n), g(m) )
     * 同时忽略常量、低次幂和最高次幂的系数
     * 可以得到算法的时间复杂度是: T(n) = O(nlogn)
     * Note:
     * 调用的现成的JDK的API方法分析同理，
     * 由于时间原因，没有深入进去把每一行代码都做执行次数的统计
     * 
     * 空间复杂度：
     * 目前来说，需要使用额外空间的是上面List用的优化的归并排序，
     * 归并排序需要临时的数组和递归时压入栈的数据占用的空间：n + logn，
     * 所以空间复杂度为: S(n)=O(n)
     */
}
