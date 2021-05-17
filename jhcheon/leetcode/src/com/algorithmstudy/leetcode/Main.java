package com.algorithmstudy.leetcode;


import com.algorithmstudy.leetcode.arrays.BTBSS;
import com.algorithmstudy.leetcode.arrays.TwoSum;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] prices = {1, 4, 1, 4, 3, 6};
        BTBSS btbss = new BTBSS();
        System.out.println(btbss.maxProfit(prices));
    }
}

