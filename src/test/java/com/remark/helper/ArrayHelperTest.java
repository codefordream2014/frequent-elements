package com.remark.helper;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangzhaoyang on 2017/5/16.
 */
public class ArrayHelperTest {

    @Test
    public void getMostFrequentElementsOfK() {

        Object[] emptyArray = {};
        Assert.assertArrayEquals(new Object[]{},ArrayHelper.getMostFrequentElementsOfK(emptyArray, 5));

        Object[] charsArray= {'0', '1', '1', '0', '2','0','0','1','5'};
        Assert.assertArrayEquals(new Object[]{'0','1','2','5'},ArrayHelper.getMostFrequentElementsOfK(charsArray, 5));


        Object[] strArray = {"aabb", "test", "test", "test", "test"};
        Assert.assertArrayEquals(new Object[]{"test","aabb"},ArrayHelper.getMostFrequentElementsOfK(strArray, 10));

        Object[] integerArray = {2, 4, 4, 3, 1};
        System.out.println(Arrays.toString(ArrayHelper.getMostFrequentElementsOfK(integerArray, 10)));
        Assert.assertArrayEquals(new Object[]{4,2,3,1},ArrayHelper.getMostFrequentElementsOfK(integerArray, 10));

    }

}
