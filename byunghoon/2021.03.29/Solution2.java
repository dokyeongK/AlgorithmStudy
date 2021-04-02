import java.util.*;
class Solution {
    public static int solution(int[] money){
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        // 첫번째 Elem으로 시작했으니 마지막꺼는 traverse하지 않음.
        for (int i = 2; i < money.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], money[i] + dp[i - 2]);
        }
        int[] dp2 = new int[money.length];
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], money[i] + dp2[i - 2]);
        }


        return Math.max(Arrays.stream(dp).max().getAsInt(), Arrays.stream(dp2).max().getAsInt());
    }
}