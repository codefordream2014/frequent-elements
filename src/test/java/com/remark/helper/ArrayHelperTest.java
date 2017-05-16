package com.remark.helper;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by zhangzhaoyang on 2017/5/16.
 */
public class ArrayHelperTest {

    @Test
    public void getMostFrequentElementsOfK() {

        //Empty char array test
        Object[] emptyArray = {};
        Assert.assertArrayEquals(new Object[]{},
                ArrayHelper.getMostFrequentElementsOfK(emptyArray, 10));

        //char array test with negative k
        Object[] chars= {'0','1'};
        try {
            Assert.assertArrayEquals(new Object[]{},
                    ArrayHelper.getMostFrequentElementsOfK(chars, -10));
        }catch (RuntimeException e){
            Assert.assertEquals(e.getMessage(),"k must be greater than 1.");
        }
        //Char array test
        Object[] charsArray = {'0', '1', '1', '0', '2', '0', '0', '1', '5', '6', '9', '8'};
        Assert.assertArrayEquals(new Object[]{'0', '1', '2', '5', '6', '9', '8'},
                ArrayHelper.getMostFrequentElementsOfK(charsArray, 10));
        //String array test
        Object[] strArray = {"aabb", "test", "test", "test", "test", "bbcc"};
        Assert.assertArrayEquals(new Object[]{"test", "aabb", "bbcc"},
                ArrayHelper.getMostFrequentElementsOfK(strArray, 10));
        //Integer array test
        Object[] integerArray = {2, 4, 4, 3, 1};
        Assert.assertArrayEquals(new Object[]{4, 2, 3, 1},
                ArrayHelper.getMostFrequentElementsOfK(integerArray, 10));

        //User array test(the unique user is identified by id only for the test)
        User user1 = new User(1, "eric", 18);
        User user2 = new User(1, "eric", 18);
        User user3 = new User(2, "lee", 18);
        User user4 = new User(3, "lee", 18);
        Object[] users = {user1, user2, user3, user4};
        Assert.assertArrayEquals(new Object[]{new User(1, "eric", 19),
                        new User(2, "lee", 18),
                        new User(3, "lee", 18)},
                ArrayHelper.getMostFrequentElementsOfK(users, 10));

    }

}
