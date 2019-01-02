package com.leetcode;



import java.util.*;

/**
 * Created by msoliman on 2/14/17.
 */
public class NextGreaterElement_496 {

    //Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
    //Output: [-1,3,-1]
    //Input: nums1 = [2,4], nums2 = [1,2,3,4].
    //Output: [3,-1]
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {


        Map<Integer, Integer> mapping = new HashMap();
        Stack<Integer> stack = new Stack<>();

        for(int num: nums){
            while(!stack.isEmpty() && stack.peek() < num) {
                int i = stack.pop();
                mapping.put(i, num);
            }

            stack.push(num);
        }

        int[] result = new int[findNums.length];

        for(int i =0;i< findNums.length;i++)
            if(mapping.get(findNums[i]) != null)
                result[i] = mapping.get(findNums[i]);
            else
                result[i] = -1;

        return result;



    }

    public static void main(String[] args){
        int[] res = nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
        int[] res2 = nextGreaterElement(new int[]{2,4},new int[]{1,2,3,4});

        int[] res3 = nextGreaterElement(new int[]{4,1,2},new int[]{2,1,3,4});

        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));

    }
}
