package com.algorithmstudy.leetcode.programmers.dp;

import java.util.Arrays;
import java.util.Comparator;

//섬 연결하기
//MST (Minimum Spanning Tree) 문제
//MST 문제에는 크루스칼 알고리즘을 활용할 것.
public class ConnectIsland {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                Integer i = ints[2];
                Integer t = t1[2];
                return i.compareTo(t);
            }
        });
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            int from = find(parents, costs[i][0]);
            int to = find(parents, costs[i][1]);
            int cost = costs[i][2];

            if (from != to) {
                parents[to] = from;
                answer += cost;
            }
        }

        return answer;
    }

    public int find(int[] parents, int island) {
        if (parents[island] == island) return island;
        else {
            parents[island] = find(parents, parents[island]);
            return parents[island];

            //그냥 바로 find(parents, parents[island])를 리턴해도 되는가?
        }
    }


}
