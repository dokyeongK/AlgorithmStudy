package com.algorithmstudy.leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/combination-sum-iv/
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int answer = 0;
        int[] mem = new int[target];
        Arrays.fill(mem, -1);
        answer = dpCombinationSum4(target, nums, mem);
        return answer;
    }

    private int dpCombinationSum4(int rem, int[] nums, int[] mem) {
        if (rem == 0) {
           return 1;
        }
        if (mem[rem] != -1) return mem[rem];
        int temp = 0;
        for (int num : nums) {
            if (rem >= num) {
                if (mem[rem - num] == -1) mem[rem - num] = dpCombinationSum4(rem - num, nums, mem);
                temp += mem[rem - num];
            }
        }
        mem[rem] = temp;
        return temp;
    }

    private void dpCombinationSum4_MEMORY_LIMIT(int rem, ArrayList<ArrayList<Integer>> tC, int[] nums, ArrayList<Integer> com) {
        if (rem == 0) {
            System.out.println(com);
            tC.add((ArrayList<Integer>) com.clone());
            return;
        }

        for (int num : nums) {
            if (rem >= num) {
                com.add(num);
                dpCombinationSum4_MEMORY_LIMIT(rem - num, tC, nums, com);
                com.remove(com.size()-1);
            }
        }
    }
}
