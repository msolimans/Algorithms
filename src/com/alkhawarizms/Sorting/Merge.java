package com.alkhawarizms.Sorting;

/**
 * Created by msoliman on 1/24/17.
 * O(n log n) Stable, not in place
 *
 * Description:
    Simple Implementation of merge sort which is a one type of divide and conquer algorithms
    It continue splitting the array into 2 halfs and sort them separately then merge the results back
    Out of place Algorithm (it needs extra memory space to make the sort) same size of the array
    Stable sort: it preserves the relative order of equal elements.


 * Time Complexity:
    O(n log n) in worst case

 * Tests:
    int[] o = Merge.sort(new int[]{2,3,0,1});
    System.out.println(Arrays.toString(o));

 */
public class Merge {

    public static int[] sort(int[] items){
        return mergesort(items);
    }

    private static int[] mergesort(int[] items){
        int mid = items.length / 2;

        //this is the stopping condition
        if(items.length == 1)
            return new int[]{items[0]};

        int[] l = new int[mid];

        for(int i = 0;i<=mid - 1;i++)
            l[i] = items[i];

        int[] r = new int[items.length - mid];

        //j is used here to point to index from the beginning of the second half of the array
        //we still can use i-mid but intentionaly I used different variable for simplicity
        int j = 0;
        for(int i = mid; i <= items.length - 1;i++)
            r[j++] = items[i];


        //recursively divide (split) again into 2 halfs till reaching out only one elem
        mergesort(l);
        mergesort(r);

        //merge 2 arrays together .. we need extra space here, I mean "results" array
        return merge(l,r);



    }

    private static int[] merge(int[] left, int[] right) {
        //l: current position in left array
        //r: current position in right array
        //k: current position in results array
        int l = 0, r = 0, k = 0;
        //results array that hold sorted data into it
        int[] result = new int[left.length+right.length];


        //move the lowest value from current position of left or right array to the results
        while (l <= left.length - 1 &&  r <= right.length - 1){

            //if left is less than right .. move left and increment position of left
            if(left[l] <= right[r]){
                result[k++] = left[l];
                l++;
            }

            else{

                result[k++] = right[r];
                r++;
            }

        }

        while(l <= left.length -1){
            result[k++] = left[l++];
        }


        while(r <= right.length -1){
            result[k++] = right[r++];
        }


        return  result;

    }


}
