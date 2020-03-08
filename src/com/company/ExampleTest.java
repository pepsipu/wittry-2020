package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * The test class .
 *
 * @author  Don Allen
 * @version 2020 Wittry Contest
 */
class AddEmUp
{
    /*
     *    All 2D arrays will be rectangular.  That is, each row in the array will be the same length
     *
     *    i.e., number[m].length = number[n].length, 0 <= m,n < number.length
     */
    private int[][] numbers;

    public AddEmUp(int[][] num)
    {
        numbers = num;
    }

    /*
     *    returns a list of all possible sums using two entries from the given row.
     *
     *    The returned List<Integer> should have no repeated values
     */
    public List<Integer> rowSum(int row)
    {
        List<Integer> ans = new ArrayList<Integer>();
        for (int num: numbers[row]) {
            for (int num2: numbers[row]) {
                if (!ans.contains(num2 + num) && num != num2) {
                    ans.add(num2 + num);
                }
            }

        }
        return ans;
    }

    /*
     *  determines the state of row in the 2D array.
     *  (For this method, repeated sums count multiple times.)
     *  Remember, a number, x, is even if x % 2 == 0.
     *  This method returns:
     *    �EVEN� if there exist more even numbers in the List of all possible sum of two entries in a given row.
     *    �ODD� if there exist more odd numbers in the List of all possible sum of two entries in a given row.
     *    �NEITHER� if there exist the same number of even and odd numbers in the List of all possible sum of two entries in a given row.
     */
    public String getState(int row)
    {
        int even = 0;
        int odd = 0;
        List<Integer> sums = this.rowSum(row);
        for (Iterator<Integer> it = sums.iterator(); it.hasNext(); ) {
            Integer num = it.next();
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if (even > odd) return "EVEN";
        if (odd > even) return "ODD";
        return "NEITHER";
    }

    /*
     *   returns a List of all values that are contained in every List returned by rowSum(k) method, 0 <= k < numbers.length
     *   for all rows in the 2D array.
     *
     *   That is, a List of all values that would be contain in the rowSum(k) method for all possible values of k.
     */
    public List<Integer> commonSum()
    {
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        List<Integer> commonSums = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            sums.add(this.rowSum(i));
        }
        List<Integer> allSums = new ArrayList<Integer>();
        for (Iterator<List<Integer>> it = sums.iterator(); it.hasNext(); ) {
            List<Integer> sum = it.next();
            allSums.addAll(sum);
        }
        HashMap<Integer, Integer> occurences = new HashMap<>();
        for (Iterator<Integer> it = allSums.iterator(); it.hasNext(); ) {
            occurences.put(it.next(), 0);
        }
        for (Iterator<Integer> it = allSums.iterator(); it.hasNext(); ) {
            Integer next = it.next();
            occurences.put(next, occurences.get(next) + 1);
        }
        Iterator it = occurences.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((Integer) pair.getValue() == numbers.length) {
                commonSums.add((Integer) pair.getKey());
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        return commonSums;
    }
}

public class ExampleTest {
    private static int[][] nums = { { 3, 6, 8}, {2, 12, 7}, {8, 6, 4}};
    private static int[][] another =  { { 3, -1, 2, 0}, {2, 2, 1, 2} };
    public static void main(String[] args) {
        AddEmUp test = new AddEmUp(nums);
        System.out.println(test.commonSum());
    }
}
