package com.probs;

import java.util.Stack;

/**
 * Created by msoliman on 6/16/17.
 */
public class p_21_PostfixEvaluation {
    //evaluate string 8,7,*,9,+ = 8*7+9
    public static  void main(String[] args){
        System.out.print(run(new char[]{'2','3','2','+','-','4','9','+','*' }));
    }

    static int run(char[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '*':
                    st.push(st.pop() * st.pop());
                    break;
                case '+':
                    st.push(st.pop() + st.pop());
                    break;
                case '-':
                    int r = st.pop() - st.pop();
                    st.push(r);
                    break;
                case '/':
                    st.push(st.pop() / st.pop());
                    break;
                default:
                    st.push(Integer.parseInt(Character.toString(arr[i])));
                    break;
            }

        }

        return st.pop();

    }
}
