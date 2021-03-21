package com.algorithmstudy;


import java.util.Arrays;

public class MakeItTo1 {
    public int solution(int X) {
        int[] val = new int[X+1];
        Arrays.fill(val, 0);

        for (int i = 2; i <= X; i++) {
            val[i] = val[i-1] + 1;
            if (i%3 == 0) {
                val[i] = Math.min(val[i], val[i/3] + 1);
            }
            if (i%2 == 0) {
                val[i] = Math.min(val[i], val[i/2] + 1);
            }
        }
        return val[X];
    }
}

/*
첫 번째 시도
bfs로 접근.
그런데 짜다보니 너무 말이 안되는듯..?
애초에 주어지는 X의 크기도 100,000 이하기 때문에
직접 다 구하는게 더 빠르다고 판단.
 */

/*
두 번째 시도
일단 X의 크기만큼의 배열생성. 헷갈림 방지위해 X+1개.
어차피 커봤자 십만개라서 별로 코스트 안들듯?
따라서 인덱스 자체를 정수로 활용가능.
 */
