package com.algorithmstudy.leetcode.DP;

import java.util.Arrays;

//Longest Increasing Subsequence
//https://leetcode.com/problems/longest-increasing-subsequence/
public class LIS {
    public int lengthOfLIS(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int[] counts = new int[nums.length];
        Arrays.fill(counts, -1);
        return answer;
    }

    //success, but runtime faster than 13.75%, memory less than 71.28%
    //need to speed up
    public int lengthOfLIS_write_by_myself(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int[] counts = new int[nums.length];
        Arrays.fill(counts, -1);
        for (int i = nums.length-1; i >= 0; i--) dpLengthOfLIS_write_by_myself(nums, i, counts);
        for (int count : counts) answer = (count > answer) ? count : answer;
        return answer;
    }

    private int dpLengthOfLIS_write_by_myself(int[] nums, int idx, int[] counts) {
        if (idx == 0) {
            counts[idx] = 1;
            return counts[idx];
        }
        if (counts[idx] != -1) return counts[idx];

        int max = Integer.MIN_VALUE;
        for (int i = idx - 1; i >= 0; i--) {
            if (nums[i] < nums[idx]) {
                int temp = dpLengthOfLIS_write_by_myself(nums, i, counts);
                max = Math.max(max, 1 + temp);
            }
        }
        max = (max == Integer.MIN_VALUE) ? 1 : max;
        counts[idx] = max;
        return counts[idx];
    }
}
