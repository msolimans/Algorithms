package com.glassdoor.bloomberg;


import java.util.Scanner;

//Remove Arbitrary Spaces

/*Description*/
//******************************************************************************************************************
// Remove Arbitrary or extra space (trim the ends)
//"hello, this is world " => "hello, this is world"
//******************************************************************************************************************
//Companies: Bloomberg
//******************************************************************************************************************



public class RemoveArbitrarySpaces {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int T = scan.nextInt();
            while (T-- > 0) {
                String s = scan.nextLine();
                System.out.println(run(s));
               System.out.println(run1(s));
            }
        }

        //naive
        static String run(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == ' ' && stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == ' ')
                    continue;
                else
                    stringBuilder.append(s.charAt(i));
            }

            return stringBuilder.toString().trim();
        }


        //2 indexes, both of them will move and once we get a space we will keep i and move j until we found a nonspace char at this time move the cursor of i and j to the same index
        static  String run1(String s){
            char[] arr = s.toCharArray();

            int i=0;
            int j=1;

            while(j < arr.length){

                //shift and keep i to the end of correct array (our result)
                if(arr[j] == ' ' && arr[i] == ' '){
                    j++;//only move j
                }
                else if(arr[j] == ' ' && arr[i] != ' '){
                    i++;//move both
                    j++;
                }
                else {
                    //ar[j] is non-space
                    i++;
                    //shift from j to i
                    arr[i] = arr[j];

                    if(j != i)
                        arr[j] = ' ';//empty it  (this is a gap)

                    j++;
                }
            }

            StringBuilder builder = new StringBuilder();
            if(arr.length > 0) {
                for (int x = 0; x <= i; x++) {
                    builder.append(arr[x]);
                }
                return builder.toString().trim();
            }return  "";

        }
}
