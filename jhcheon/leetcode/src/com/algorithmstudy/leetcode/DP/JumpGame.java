package com.algorithmstudy.leetcode.DP;

import java.util.Arrays;

public class JumpGame {
    //easy implementation, 1ms (bottom up)
    public boolean canJump(int[] nums) {
        boolean answer = false;

        int lastIdx = nums.length-1;

        for (int i = lastIdx-1; i >= 0; i--) {
            if (nums[i] + i >= lastIdx) lastIdx = i;
        }

        return lastIdx == 0;
    }


    //faster than 34.31%, 186 ms (top down)
    private boolean dpCanJump_my_self(int[] nums, int curStartIdx, int lastIdx, int[] mem) {
        int jumpLength = nums[curStartIdx];
        if (mem[curStartIdx] == 1) return true;
        if (mem[curStartIdx] == 0) return false;
        if (jumpLength >= lastIdx - curStartIdx) {
            mem[curStartIdx] = 1;
            return true;
        }

        for (int i = curStartIdx+1; i <= curStartIdx+jumpLength; i++) {
            if (i == lastIdx) return true;
            if (i > lastIdx) break;
            if (dpCanJump_my_self(nums, i, lastIdx, mem)) {
                mem[i] = 1;
                return true;
            }
        }
        mem[curStartIdx] = 0;
        return false;
    }
}
