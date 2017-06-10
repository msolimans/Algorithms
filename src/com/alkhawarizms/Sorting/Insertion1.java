package com.alkhawarizms.Sorting;

/**
 * Created by msoliman on 4/13/17.
 * Description:
 *      Slight modification of insertion sort
 *      No swapping done, but shifting till putting the item to be moved in its proper order or place
 *
 * Tests:
 *
 *      int[] results = Insertion1.sort(new int[]{0,3,1,4,2,2,1,0,-1});
 *      System.out.println(Arrays.toString(result));
 */
public class Insertion1 {

    public static int[] sort(int[] items){
        for(int i = 1;i<items.length;i++){
            int toMove = items[i];
            int indx = i - 1;
            while (indx >= 0 && items[indx] > toMove) {

                items[indx + 1] = items[indx];

                indx--;
            }

            items[indx + 1] = toMove;

        }

        return items;
    }

}
