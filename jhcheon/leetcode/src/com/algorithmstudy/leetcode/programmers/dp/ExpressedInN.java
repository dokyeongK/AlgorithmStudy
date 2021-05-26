package com.algorithmstudy.leetcode.programmers.dp;

import java.util.*;

//N으로 표현
public class ExpressedInN {
    public int solution(int N, int number) {
        int answer = 0;
        Map<Integer, Set<Integer>> start = new HashMap<>();
        Set<Integer> startSet = new HashSet<>();
        startSet.add(N);
        start.put(1, startSet);
        answer = dpSolution(start, 1, N, number);
        return answer;
    }

    private int dpSolution(Map<Integer, Set<Integer>> curMap, int curCnt, int N, int number) {
        if (curCnt == 9) return -1;
        if (curMap.get(curCnt).contains(number)) return curCnt;

        Set<Integer> newSet = new HashSet<>();
        int nextCnt = curCnt + 1;
        int temp = 0;
        for (int i = nextCnt-1; i >= 0; i--) {
            temp += N*Math.pow(10, i);
        }
        newSet.add(temp);
        for (int i = 1; i < nextCnt; i++) {
            int tempN = 0;
            for (int j = nextCnt-i-1; j >= 0; j--) {
                tempN += N*Math.pow(10, j);
            }

            for (Integer k : curMap.get(i)) {
                newSet.add(k + tempN);
                newSet.add(k - tempN);
                newSet.add(tempN - k);
                newSet.add(k * tempN);
                newSet.add(k / tempN);
                if (k != 0) newSet.add(tempN / k);
            }
        }
        curMap.put(nextCnt, newSet);

        int res = dpSolution(curMap, nextCnt, N, number);
        return res;
    }

    private int dpSolution_wrong(Set<Integer> curSet, int curCnt, int N, int number) {
        if (curCnt == 9) return -1;
        if (curSet.contains(number)) {
            System.out.println(curSet);
            return curCnt;
        }

        Set<Integer> newSet = new HashSet<>();
        System.out.println("current count : " + curCnt);
        System.out.println(curSet);
        for (Integer i : curSet) {
            newSet.add(i * 10 + N);
            newSet.add(i + N);
            newSet.add(i - N);
            newSet.add(i * N);
            newSet.add(i / N);
            if (i != 0) newSet.add(N / i);
        }

        int res = dpSolution_wrong(newSet, curCnt + 1, N, number);
        return res;
    }

//    private void dpSolution_giveup_while_writing(int curNum, int curCnt, int N, int number, Map<Integer, Integer> nMap) {
//        if (curNum == number) {
//            int temp = curCnt;
//            if (nMap.containsKey(curNum)) {
//                temp = Math.min(nMap.get(curNum), curCnt);
//            }
//            nMap.put(curNum, curCnt);
//            return;
//        }
//
//        if (nMap.containsKey(curNum)) {
//            if (curCnt > nMap.
//        }
//
//        if (curCnt >= 8) {
//            nMap.put(curNum, 9);
//            return;
//        }
//
//        int tempCur = 0;
//        for (int i = 0; i < 5; i++) {
//            if (i == 0) tempCur = curNum * 10 + N;
//            else if (i == 1) tempCur = curNum / N;
//            else if (i == 2) tempCur = curNum * N;
//            else if (i == 3) tempCur = curNum + N;
//            else if (i == 4) tempCur = curNum - N;
//
//            int temp =curCnt+1;
//            if (nMap.containsKey(tempCur)) {
//                temp = Math.min(nMap.get(tempCur), temp);
//            }
//            nMap.put(tempCur, temp);
//
//            dpSolution(tempCur, curCnt+1, N, number, nMap);
//        }
//    }
}
