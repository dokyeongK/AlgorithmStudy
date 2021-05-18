package com.algorithmstudy.leetcode.DP;

import java.util.*;

//https://leetcode.com/problems/coin-change/solution/
public class CoinChange {
    //서로 다른 금액의 동전 배열 coins, 총합 amount
    //총합을 이루는 가장 작은 코인 개수를 반환
    //dp[coin][amount] = amount/coin + dp[coin][amount%coin];
    public int coinChange(int[] coins, int amount) {
        int answer = 0;
        int[] count = new int[amount];
        if (amount == 0) return 0;
        answer = dp(coins, amount, count);

        return answer;
    }

    private int dp(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        else if (amount == 0) return 0;
        if (count[amount-1] != 0) return count[amount-1];
        int temp1 = 2147483647;
        for (int coin : coins) {
            int temp2 = dp(coins, amount-coin, count);
            if (temp2 != -1) temp1 = Math.min(temp1, temp2 + 1);
        }

        if (temp1 == 2147483647) temp1 = -1;
        count[amount-1] = temp1;
        return count[amount-1];
    }

    private int dp2(int[] coins, int amount, int mok) {
        if (amount != 0 && mok == 0) return -1;
        else if (amount == 0 && mok != 0) return mok;

        if (mok == -1) mok = 0;
        int answer;

        int temp1 = 2147483647;
        for (int coin : coins) {
            int temp2 = dp2(coins, amount%coin, amount/coin);
            if (temp2 != -1) temp1 = Math.min(temp1, temp2 + mok);
        }

        if (temp1 == 2147483647) temp1 = -1;
        return temp1;
    }
}

