package com.algorithmstudy;

public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        if (A.length == 3) return 0;

        int[] leftSum = new int[A.length];
        int[] rightSum = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            leftSum[i] = 0;
            rightSum[i] = 0;
        }

        int max = 0;

        for (int i = 1; i < A.length-1; i++) {
            leftSum[i] = Math.max(leftSum[i-1] + A[i], 0);
        }

        for (int i = A.length-2; i > 1; i--) {
            rightSum[i] = Math.max(rightSum[i+1] +A[i], 0);
        }

        for (int i = 1; i < A.length-1; i++) {
            max = Math.max(leftSum[i-1] + rightSum[i+1], max);
        }

        return max;
    }
}

//N개의 정수를 가진 배열 A가 주어짐. (N > 0)
//0 <= X < Y < Z < N 인 triplet (X, Y, Z)는 double slice라고 불린다.
//double slice의 합은 A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1] 의 총합이다.
//이 때, 배열 A가 주어졌을 때, double slice의 합 중 최댓값을 반환해라.
//N의 범위는 3 이상 100,000 이하임.
//배열 A의 각각의 요소들의 범위는 -10,000 이상 10,000 이하임.

/*
일단 y를 가장 작은 요소로 정하면 어떨까 싶네.
N이 3이면 그냥 0임.
N이 4면 A[1], A[2] 중 더 큰 거.
N이 5면 A[1] 혹은 A[2] 혹은 A[3] 혹은 A[1]+A[2] 혹은 A[1]+A[3]
혹은 A[2]+A[3] 중 더 큰 거.
N이 6이면 A[1], A[2], A[3], A[4], A[1]+A[2], A[1]+A[3], A[2]+A[3], A[2]+A[4], A[3]+A[4], A[1]+A[2]+A[3], A[1]+A[2]+A[4],
A[1]+A[3]+A[4], A[2]+A[3]+A[4] 중 더 큰 거.



A[0] = 3
A[1] = 2
A[2] = 6
A[3] = -1
A[4] = 4
A[5] = 5

A[6] = -1
A[7] = 2


*/