package com.algorithmstudy.leetcode;


import com.algorithmstudy.leetcode.DP.CoinChange;
import com.algorithmstudy.leetcode.DP.UniquePaths;
import com.algorithmstudy.leetcode.arrays.BTBSS;
import com.algorithmstudy.leetcode.arrays.TwoSum;

public class Main {

    public static void main(String[] args) {
	// write your code here
        UniquePaths uniquePaths = new UniquePaths();
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths.uniquePaths(m, n));
    }
}

