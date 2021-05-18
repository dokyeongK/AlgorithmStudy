package com.algorithmstudy.leetcode.DP;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int answer = 0;
        int[][] mem = new int[m][n];
        for (int[] temp : mem) Arrays.fill(temp, 0);

        mem[0][0] = 1;
        answer = dpUniquePaths(m-1, n-1, mem);
        return answer;
    }

    //mem[m, n] = mem[m, n-1] + mem[m-1, n]
    //if n-1 < 0, mem[m, n-1] = 0
    //if m-1 < 0, mem[m-1, n] = 0
    private int dpUniquePaths(int m , int n, int[][] mem) {
        if (m < 0 || n < 0) return 0;
        if (mem[m][n] != 0) return mem[m][n];
        mem[m][n] = dpUniquePaths(m, n-1, mem) + dpUniquePaths(m-1, n, mem);
        return mem[m][n];
    }
}
