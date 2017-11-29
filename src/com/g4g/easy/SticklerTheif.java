package com.g4g.easy;

import java.util.Scanner;

//Stickler Theif
//Show Topic Tags
/**
 * Divide and Conquer
 */

/*Description*/
//******************************************************************************************************************
// Stickler is a thief and wants to loot money from a society of n houses placed in a line. He is a weird person and follows a rule while looting the houses and according to
// the rule he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable
// to find the maximum amount he can end up with. He asks for your help to find the maximum money he can get if he strictly follows the rule. Each house has a[i] amount of money present
// in it.

//      Input:
//        The first line of input contains an integer T denoting the number of test cases. Each test case contains an integer n which denotes the number of elements in the array a[]. Next line contains space separated n elements in the array a[].
//
//        Output:
//        Print an integer which denotes the maximum amount he can take home.
//
//        Constraints:
//        1<=T<=200
//        1<=n<=1000
//        1<=a[i]<=10000
//
//        Example:
//        Input:
//        2
//        6
//        5 5 10 100 10 5
//        3
//        1 2 3
//
//        Output:
//        110
//        4
//
//        ** For More Input/Output Examples Use 'Expected Output' option **
//
//        Contributor: Shashwat Jain
//        All submissions

//******************************************************************************************************************
//Companies: Walmart Labs, Paytm, Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/stickler-theif/0/?ref=self
//******************************************************************************************************************

public class SticklerTheif {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int l = scan.nextInt();
            int[] arr = new int[l];
            for(int i=0;i<l;i++){
                arr[i] = scan.nextInt();
            }


            System.out.println( FindMaxSum(arr, arr.length));


        }

      //  System.out.println( max(new int[] {1,2,3,4,5,6,7}, 0, 6));
      //  System.out.println( max(new int[] {5,5,10,100,10,5,20,8 }, 0, 7));
        //1 49 5 5 6  5 6 4 5 7 6 5 4 33 5 5 666 87 90 9 7 2 4 7 8 1 8 7 55 33 332 67 98 8 65 43 2376 6 45 5 32 2 34 54 43 45 54 43 2 76 56 8 98 67 54 65 76 54 76 56 87 54 65
        //1 20 5 5 6  5 6 4 5 7 6 5 4 33 5 5 666 87 90 9 7 2
        //1 10 5 5 6  5 6 4 5 7 6 5

    }
    static int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }

    static int max(int[] arr, int start, int end){
        if(start > end)
            return 0;
        if(start == end)
            return arr[start];
        if(start + 1 == end)
            return arr[start] > arr[end]? arr[start] : arr[end];

        int max = 0;
        int maxIndx = -1;

        for(int i=start;i<=end;i++){
            if(arr[i] >= max){
                max = arr[i];
                maxIndx = i;
            }
        }

        System.out.println(maxIndx);

        if(maxIndx-1< start || maxIndx+1 > end || max> arr[maxIndx-1] + arr[maxIndx+1]) {
            return max  + max(arr, start, maxIndx - 2) + max(arr, maxIndx + 2, end);
        }
        else{
            return arr[maxIndx + 1] + arr[maxIndx - 1] + max(arr, start, maxIndx-3) + max(arr, maxIndx+3, end);
        }

    }


    static long run(int[] arr) {

        //find the max of the array, then split/conquer each part if it is having a size bigger than or equal to 3


        long max = 0;

        //2 loops should do it
        for(int i=0;i<(2>arr.length?arr.length:2);i++){

            long c = arr[i];
            for(int j=i+2;j<arr.length;j+=2){
                c += arr[j];
            }

            if(c>max)
                max = c;

        }
        //1 649 3087 9133 5131 4522 3161 674 498 5347 4416 4770 8652 2234 8460 7511 9911 2611 1980 8184 49 385 7963 1757 7572 6831 9869 9897 4307 6464 6765 8883 3464 6204 8017 8596 7079 7530 5622 7577 9230 6390 8699 7882 4976 7160 1745 4887 9771 3726 9424 9820 4111 7387 1577 8036 570 7798 7933 1229 615 1050 113 4079 3607 4482 9027 686 8364 1002 4615 7594 7392 3315 1828 2369 475 3574 3608 6598 7300 9384 2771 7763 6771 700 5799 3694 8499 3733 4923 9114 1135 1388 9545 4742 5870 8573 1780 4235 5927 6396 1829 3319 6063 10 2040 6538 3584 2001 9488 884 1385 2259 8647 4509 9312 799 8203 7811 884 3126 3277 2019 4515 2822 3114 6737 7747 4894 7324 3674 1290 9154 3346 3705 9164 1738 6595 9100 3739 6084 6336 5125 4695 1335 9634 4007 2134 4189 1818 3018 7315 1447 5038 8182 622 4504 1272 8369 9398 8596 8396 7041 7750 8094 746 3266 9832 7342 8718 3572 9778 5054 5049 4473 6390 1035 8481 8524 5224 6651 7895 8891 8099 2933 7074 8721 3789 8346 3442 3187 3294 1838 6580 7397 9932 3679 663 6117 1021 5734 9689 799 788 1090 1624 7178 2125 105 2055 7349 3109 9950 2592 7560 9235 9666 2633 3024 4364 6075 2563 7659 4266 9144 5056 550 2823 2071 6667 196 4157 2708 7347 4946 3798 8971 8476 2275 5429 531 5976 4890 6833 8569 2450 6068 4587 5083 5444 5304 1158 8008 9315 1776 3504 723 2327 6327 9146 8994 2875 3304 8055 222 8250 8205 5545 3078 481 974 3610 2809 5864 6795 1378 4666 2864 2318 9749 8308 7622 7260 2668 6937 9036 6172 4012 1363 8851 3158 6710 1726 6462 1117 8300 1064 9322 3846 4143 6155 1172 4105 8965 3389 900 343 8055 116 9013 7805 8425 6635 5065 7445 9924 453 3618 3936 1817 2469 7095 4879 548 9909 5996 8848 7326 1670 2694 7821 7826 3867 1926 6791 7256 9178 3486 5311 9295 8852 9468 4072 5487 4533 7869 5412 4987 1487 5700 3156 309 9147 4387 857 5409 6735 9705 2735 8405 2400 556 6231 2619 8834 9374 6227 4364 9213 1538 11 8065 1007 435 9904 1892 8305 1668 3231 9792 7369 2739 101 2868 3478 7310 8277 213 7016 1012 8619 5768 7920 1202 4739 6754 6929 966 1119 2494 2504 7482 6911 9863 7918 6815 8108 6223 4836 7691 6015 2205 6783 2469 5073 261 9779 9703 475 3147 715 9094 5267 8636 6648 6 1742 3577 972 9213 2423 9829 6696 9334 9692 4614 2502 4152 837 7338 8196 3204 5895 4979 2025 7320 5240 8157 7023 5715 7656 7739 1161 2924 2727 7810 2930 821 7739 255 35 163 84 3083 5849 6128 4049 8351 281 1238 5689 8477 794 1584 9808 2820 5257 5048 977 2280 7116 4985 6371 8277 7909 9098 2439 7192 6272 6531 7447 6307 3046 7531 5742 8895 11 6143 3599 292 7381 5640 5121 8175 3577 4929 995 8834 6330 8324 1114 3446 3310 7486 8075 7571 2936 515 4763 9208 3398 8562 1867 6444 6093 7609 1691 6105 3752 5290 2749 7485 931 4223 5661 4508 5504 3008 9694 1834 7685 808 5280 7347 4646 9708 4918 7583 223 9682 6791 9973 8244 8659 6417 690 2620 4460 3147 2725 9751 2248 210 7034 6471 5871 7894 8328 5232 7588 162 2917 4748 1795 264 9395 1503 5182 6978 8078 1216 3769 8051 5813 8780 820 2855 1401 5280 2354 4126 1383 4602 4336 4769 7426 6560 2663 5754 1792 6603 2268 4709 1352 415 1325 747 1918 6507 7725 6348 4076 7846 751 9889 6627 7923 9096 4380 9556 1450 8506 939 6052 9194 2061 9830 5754 4724 5584 7546 1328 4205 8607 9032 4620 9932 9779 2891 2792 3856 5591 3220 8054 6343 9461 4681 618 8557 9061

//1713639 output
//1966519 expected

        return max;
    }

    //recursive version o(n)
    static int run(int[] arr, int indx, int result) {
        if(indx > arr.length)
            return  result;

        int current =  0;

        for(int i = indx; i<arr.length;i+=2){
            current += arr[i];
        }

        int next = run(arr, indx + 2, current);

        return current > next? current: next;
    }
}
