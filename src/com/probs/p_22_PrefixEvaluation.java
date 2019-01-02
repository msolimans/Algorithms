package com.probs;

import java.util.Stack;

/**
 * Created by msoliman on 6/16/17.
 */
public class p_22_PrefixEvaluation {
    //evaluate string -,+,*,2,3,+,5,4,9 which equals {(2*3)+(5+4)} - 9
    //to solve this problem we should start from the end of the string or array then push into stack every expression
    //for operands, we should pop out 2 elements and calculate based of this operand
    public static void main(String[] args) {
        System.out.print(run(new char[]{'-','+','*','2','3','+','5','4','9' }));
        System.out.print(run(new char[]{'-','+', '3','2','1' }));

    }

    static int run(char[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            switch (arr[i]) {
                case '*':
                    st.push(st.pop() * st.pop());
                    break;
                case '+':
                    st.push(st.pop() + st.pop());
                    break;
                case '-':
                    st.push(st.pop() - st.pop());
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
