package com.remark.helper;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangzhaoyang on 2017/5/16.
 */
public class ArrayHelperTest {

    @Test
    public void getMostFrequentElementsOfK() {
        String[] a = {"aabb","test","test","test","test"};
        System.out.println("input array: " + Arrays.toString(a));
        Object[] result = ArrayHelper.getMostFrequentElementsOfK(a, 5);
        System.out.println("result array:" + Arrays.toString(result));
    }

}
