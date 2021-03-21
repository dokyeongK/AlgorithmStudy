package com.algorithmstudy;

public class PermCheck {
    public int solution(int[] A) {
        double sum = 0;
        int length = A.length;
        int[] visited = new int[length+1];

        for (int i = 0; i < length; i++) {
            sum += i + 1;
        }

        for (int i = 0; i < length; i++) {
            if (A[i] > length) {
                return 0;
            } else if (visited[A[i]] == 11) {
                return 0;
            } else {
                sum -= A[i];
                visited[A[i]] = 11;
            }
        }

        if (sum == 0) return 1;

        return 0;
    }

    /*
    첫 번째 submit에서
    1. antiSum1 : total sum is correct, but it is not a permutation, N <= 10
    2. antiSum2 : total sum is correct, but it is not a permutation, N = ~100,000
    3. extreme_values : all the same values, N = ~100,000
    만족못했음.
     */
}
