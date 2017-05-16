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
     * find the k most frequent elements in one specified object array
     * the step is as following:
     * 1.Loop the obj array, count each element
     * and put the count in HashMap(key is the element,value is the number of times)
     * 2.Convert the HashMap to ArrayList
     * 3.Sort the ArrayList
     * 4.Return the top rank of K in the ArrayList
     *
     * @param obj the source object array that need to be handled
     * @param k   number of most frequent elements
     * @return the object array that most frequently appears in the source array for specified k number
     */

    public static Object[] getMostFrequentElementsOfK(final Object[] obj, Integer k) {

        if (null == obj || obj.length <= 0) {
            return obj;
        }
        final int mapSize = obj.length + 1;
        //prevent to resize
        Map<Object, Integer> resultMap = new HashMap<>(mapSize, 1);
        for (Object o : obj) {
            // the element has been put into the map yet
            if (resultMap.containsKey(o)) {
                Integer update = resultMap.get(o);
                resultMap.put(o, ++update);
            } else {
                //first time to put the element to the map
                resultMap.put(o, 1);
            }
        }

        // convert map.entrySet() to entryList
        List<Map.Entry<Object, Integer>> entryList = new ArrayList<>(resultMap.entrySet());

        // sort the entryList
        Collections.sort(entryList, new Comparator<Map.Entry<Object, Integer>>() {
            @Override
            public int compare(Map.Entry<Object, Integer> o1, Map.Entry<Object, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //set the result array size to the entryList size if k is greater than size of the list
        if (k > entryList.size()) {
            k = entryList.size();
        }

        Object[] result = new Object[k];

        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }
        return result;
    }

}
