package com.hackerrank.Warmup;

/**
 * Created by msoliman on 5/9/17.
 * https://www.hackerrank.com/challenges/mini-max-sum
 * Explanation
 * <p>
 * Our initial numbers are , , , , and . We can calculate the following sums using four of the five integers:
 * <p>
 * If we sum everything except , our sum is .
 * If we sum everything except , our sum is .
 * If we sum everything except , our sum is .
 * If we sum everything except , our sum is .
 * If we sum everything except , our sum is .
 * As you can see, the minimal sum is  and the maximal sum is . Thus, we print these minimal and maximal sums as two space-separated integers on a new line.
 */
public class p_7_MinMaxSum {
    public static void main(String[] args) {
        System.out.println(run(0,new int[]{1,2,3,4,5}));

        int[] is = new int[]{1,2,3,4,5};
        Integer min = -1;
        Integer max = -1;
        minmax(0,is, min,max);
        System.out.print(min + " " + max);

    }



    static int min(int i, int j) {
        return i < j ? i : j;
    }

    static int run(int prefix, int[] nums) {

        int sum = 0;
        sum = nums[0];
        nums[0] = nums[prefix];
        nums[prefix] = sum;
        sum = 0;

        for (int i = 1; i < nums.length; i++)
            sum += nums[i];


        if (prefix == nums.length - 1)
            return sum;
        else

            return min(sum, run(prefix + 1, nums));


    }


    static void minmax(int prefix, int[] nums, Integer min, Integer max) {

        int sum = 0;
        sum = nums[0];
        nums[0] = nums[prefix];
        nums[prefix] = sum;
        sum = 0;

        for (int i = 1; i < nums.length; i++)
            sum += nums[i];


        if(sum < min) min = sum;
        if(sum > max) max = sum;

        if (prefix == nums.length - 1)
            return;
        else
            minmax(prefix + 1, nums, min, max);


    }





}
