package com.algorithmstudy.leetcode.programmers.dp;

import java.util.*;
import java.util.stream.Collectors;

public class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length-1;
        Arrays.sort(people);
        while (left <= right) {
            if (left == right) {
                answer++;
                break;
            }
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                answer++;
            } else {
                right--;
                answer++;
            }
        }

        return answer;
    }

//    public int solution(int[] people, int limit) {
//        int answer = 0;
//        Arrays.sort(people);
//        Map<Integer, Integer> peopleMap = new TreeMap<>();
//        ArrayList<Integer> peopleList = new ArrayList<>();
//        for (int p : people) {
//            peopleList.add(p);
//            if (peopleMap.containsKey(p)) peopleMap.put(p, peopleMap.get(p)+1);
//            else peopleMap.put(p, 1);
//        }

//        while (!peopleMap.isEmpty()) {
//            int curWeight = peopleList.stream().findFirst().get();
//            int sum = curWeight;
//            if (!peopleMap.containsKey(curWeight)) {
//                peopleList.remove(0);
//                continue;
//            }
//            for (int i = 1; i < peopleList.size(); i++) {
//                int temp = peopleList.get(i);
//                if (curWeight + temp > limit && peopleMap.containsKey(temp)) {
//                    int temp2 = peopleList.get(i-1);
//                    if (i-1 != 0) {
//                        sum += temp2;
//                        if (curWeight == temp2) {
//                            int curCnt = peopleMap.get(curWeight);
//                            int tempCnt = curCnt % 2;
//                            answer += curCnt / 2;
//                            if (tempCnt == 1) peopleMap.put(curWeight, 1);
//                            else peopleMap.remove(curWeight);
//                        } else {
//                            int curCnt = peopleMap.get(curWeight);
//                            int otherCnt = peopleMap.get(temp2);
//                            int cnt = 0;
//                            if (curCnt == otherCnt) cnt = curCnt;
//                            else cnt = curCnt > otherCnt ? otherCnt : curCnt;
//                            answer += cnt;
//                            if (cnt == curCnt) {
//                                peopleMap.remove(curWeight);
//                            } else peopleMap.put(curWeight, peopleMap.get(curWeight) - cnt);
//                            if (cnt == otherCnt) {
//                                peopleMap.remove(temp2);
//                            } else peopleMap.put(temp2, peopleMap.get(temp2) - cnt);
//                        }
//                    }
//                    break;
//                }
//            }
//            if (sum == curWeight) {
//                answer += 1;
//                int curCnt = peopleMap.get(curWeight);
//                if (curCnt - 1 == 0) peopleMap.remove(curWeight);
//                else peopleMap.put(curWeight, peopleMap.get(curWeight) - 1);
//            }
//            peopleList.remove(0);
//        }


//        while (!peopleList.isEmpty()) {
//            int curWeight = peopleList.stream().findFirst().get();
//            int sum = curWeight;
//            for (int i = 1; i < peopleList.size(); i++) {
//                if (curWeight + peopleList.get(i) > limit) {
//                    if (i-1 != 0) {
//                        sum += peopleList.get(i-1);
//                        peopleList.remove(i-1);
//                    }
//                    break;
//                }
//            }
//            peopleList.remove(0);
//            answer += 1;
//        }
//
//
//        return answer;
//    }
}
