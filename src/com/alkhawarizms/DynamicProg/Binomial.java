package com.alkhawarizms.DynamicProg;

/**
 * Created by msoliman on 2/7/17.
 */
public class Binomial {
    int ctr = 0;
    int ctr1 = 0;
    public static void main(String[] args) {
        Binomial b = new Binomial();
        int i = b.binomial(4, 2);
        System.out.print(i + " in " + b.ctr + " initialization in " + b.ctr1);

    }

    int binomial(int n, int k) {

        Integer[][] memo = new Integer[n + 1][k + 1];

        for (int i = 0;i<=n;i++) { //n times
            for(int i1 = 0;i1<=k;i1++) { //n times k O(n*k)
                ctr1++;
                memo[i][i1] = -1;
            }
        }

        return binomial(memo, n, k);
    }

    int binomial(Integer[][] memo, int n, int k) {

        if (k == 0 || k == n)
            return 1;

        if (memo[n][k] == -1) { // n times
            ctr++;
            memo[n][k] = binomial(memo, n - 1, k - 1) + binomial(memo, n - 1, k);
        }
        return memo[n][k];

    }


}
