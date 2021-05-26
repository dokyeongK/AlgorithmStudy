package com.algorithmstudy.leetcode.programmers.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class EnforcementCamera {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                Integer a1 = ints[0];
                Integer a2 = ints[1];
                Integer b1 = t1[0];
                Integer b2 = t1[1];
                if (a1 == b1) return a2.compareTo(b2);
                return a1.compareTo(b1);
            }
        });
        int start = routes[0][0];
        int end = routes[0][1];
        answer += 1;
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= end) {
                start = routes[i][0];
                end = Math.min(end, routes[i][1]);
            } else {
                answer += 1;
                start = routes[i][0];
                end = routes[i][1];
            }
        }
        return answer;
    }

    //시작 지점이 아닌, 거리로 정렬해버려서 틀린 케이스...
    //정확도는 다 통과했는데, 신기하게 효율성에서 시간 초과만 난 게 아니라 그냥 틀린 경우도 있었음.
//    public int solution(int[][] routes) {
//        int answer = 0;
//        Arrays.sort(routes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] ints, int[] t1) {
//                Integer a = ints[1] - ints[0];
//                Integer b = t1[1] - t1[0];
//                return a.compareTo(b);
//            }
//        });
//        ArrayList<int[]> routeList = new ArrayList<>();
//
//        for (int i = 0; i < routes.length; i++) {
//            checkDupSection(routeList, routes[i][0], routes[i][1]);
//        }
//        for (int[] temp : routeList) {
//            System.out.println("["+temp[0] +","+temp[1]+"]");
//        }
//        answer = routeList.size();
//
//        return answer;
//    }
//
//    void checkDupSection(ArrayList<int[]> list, int start, int end) {
//        boolean check = false;
//        for (int i = 0; i < list.size(); i++) {
//            int[] temp = list.get(i);
//            if (temp[1] < start || end < temp[0]) {
//
//            } else if (temp[0] >= start || temp[1] <= end){
//                check = true;
//                break;
//            } else if (temp[0] == end) {
//                list.remove(i);
//                int[] ns = {end, end};
//                list.add(ns);
//                check = true;
//                break;
//            } else if (temp[1] == start) {
//                list.remove(i);
//                int[] ns = {start, start};
//                list.add(ns);
//                check = true;
//                break;
//            } else if (temp[0] <= start) {
//                list.remove(i);
//                int[] ns = {start, temp[1]};
//                list.add(ns);
//                check = true;
//                break;
////                if (temp[1] <= end) {
////
////                }
//            } else if (temp[1] >= end) {
//                list.remove(i);
//                int[] ns = {temp[0], end};
//                list.add(ns);
//                check = true;
//                break;
//            }
//        }
//
//        if (!check) {
//            int[] ns = {start, end};
//            list.add(ns);
//        }
//        list.sort(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] ints, int[] t1) {
//                Integer a = ints[1] - ints[0];
//                Integer b = t1[1] - t1[0];
//                return a.compareTo(b);
//            }
//        });
//    }
}
