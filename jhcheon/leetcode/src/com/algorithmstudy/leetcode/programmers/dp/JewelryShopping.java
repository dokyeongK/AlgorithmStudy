package com.algorithmstudy.leetcode.programmers.dp;

import java.util.*;

//[카카오 인턴] 보석 쇼핑
public class JewelryShopping {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> gemType = new HashSet<>(Arrays.asList(gems));
        if (gemType.size() == 1) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        Map<String, Integer> gemMap = new HashMap<>();
        int startIdx = 0;
        int lastIdx = 0;
        int distance = Integer.MAX_VALUE;

        while (true) {
            if (gemMap.size() == gemType.size()) {
                if (lastIdx - startIdx < distance) {
                    distance = lastIdx - startIdx;
                    answer[0] = startIdx + 1;
                    answer[1] = lastIdx;
                }
                int temp = gemMap.get(gems[startIdx]) - 1;
                if (temp == 0) gemMap.remove(gems[startIdx]);
                else gemMap.replace(gems[startIdx], temp);
                startIdx++;
            } else if (lastIdx == gems.length) {
                break;
            } else {
                if (gemMap.containsKey(gems[lastIdx])) {
                    gemMap.replace(gems[lastIdx], gemMap.get(gems[lastIdx]) + 1);
                } else {
                    gemMap.put(gems[lastIdx], 1);
                }
                lastIdx++;
            }
        }
        System.out.println(distance);
        System.out.println(answer[0] + " " + answer[1]);

        return answer;
    }



//    정확성  테스트
//    테스트 1 〉	통과 (0.18ms, 53.4MB)
//    테스트 2 〉	통과 (0.41ms, 52.9MB)
//    테스트 3 〉	통과 (1.24ms, 52.9MB)
//    테스트 4 〉	통과 (2.80ms, 53.4MB)
//    테스트 5 〉	통과 (0.30ms, 52.5MB)
//    테스트 6 〉	통과 (0.16ms, 52.5MB)
//    테스트 7 〉	통과 (0.34ms, 52.5MB)
//    테스트 8 〉	통과 (7.37ms, 53.2MB)
//    테스트 9 〉	통과 (9.34ms, 53.2MB)
//    테스트 10 〉	통과 (1.81ms, 52.5MB)
//    테스트 11 〉	통과 (3.58ms, 53.7MB)
//    테스트 12 〉	통과 (16.40ms, 54.6MB)
//    테스트 13 〉	통과 (18.37ms, 53.9MB)
//    테스트 14 〉	통과 (36.84ms, 54.3MB)
//    테스트 15 〉	통과 (31.32ms, 58.6MB)
//    효율성  테스트
//    테스트 1 〉	통과 (53.90ms, 59MB)
//    테스트 2 〉	통과 (200.32ms, 58.3MB)
//    테스트 3 〉	통과 (174.70ms, 66.4MB)
//    테스트 4 〉	통과 (131.66ms, 63.5MB)
//    테스트 5 〉	통과 (355.84ms, 64.8MB)
//    테스트 6 〉	통과 (96.52ms, 66.9MB)
//    테스트 7 〉	통과 (491.83ms, 67.9MB)
//    테스트 8 〉	통과 (589.18ms, 69.8MB)
//    테스트 9 〉	통과 (207.35ms, 74.1MB)
//    테스트 10 〉	통과 (432.07ms, 77.7MB)
//    테스트 11 〉	실패 (시간 초과)
//    테스트 12 〉	통과 (1329.73ms, 81.4MB)
//    테스트 13 〉	실패 (시간 초과)
//    테스트 14 〉	실패 (시간 초과)
//    테스트 15 〉	실패 (시간 초과)
//    채점 결과
//    정확성: 33.3
//    효율성: 48.9
//    합계: 82.2 / 100.0
    public int[] solution_time_limit(String[] gems) {
        int[] answer = new int[2];
        Set<String> gemType = new HashSet<>(Arrays.asList(gems));
        if (gemType.size() == 1) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        Map<String, Integer> gemIdx = new HashMap<>();
        int startIdx = 0;
        int lastIdx = 0;
        int distance = Integer.MAX_VALUE;
        gemIdx.put(gems[startIdx], 0);

        while (lastIdx != gems.length-1){
//            if (gemIdx.size() == gemType.size()) {
//                if (lastIdx - startIdx < distance) {
//                    distance = lastIdx - startIdx;
//                    answer[0] = startIdx;
//                    answer[1] = lastIdx;
//                }
//                if (gemIdx.get(gems[startIdx]).equals(startIdx)) {
//                    gemIdx.remove(gems[startIdx]);
//                }
//                startIdx += 1;
//                continue;
//            }
            //문제
            //일반화 시키는 거지
            //투 포인터
            //언제 쓰이는 거지?
            //특정 배열에서 조건을 만족하는 최소 구간을 구할 때.
            //조건 : 조건에 대한 답을 구할 때, 사용되는 구간들이 연속적이어야 한다.
            //연속적이지 않을 때는?

            for (int i = startIdx + 1; i < gems.length; i++) {
                lastIdx = i;
                if (!gemIdx.containsKey(gems[i])) {
                    gemIdx.put(gems[i], i);
                }
                if (gems[startIdx].equals(gems[i])) {
                    if (i - startIdx == 1) {
                        startIdx += 1;
                        gemIdx.replace(gems[startIdx], startIdx);
                    } else {
                        gemIdx.replace(gems[startIdx], i);
                        startIdx = startIdx + 1;
                    }
                    break;
                }
                if (gemIdx.size() == gemType.size()) {
                    if (lastIdx - startIdx < distance) {
                        distance = lastIdx - startIdx;
                        answer[0] = startIdx + 1;
                        answer[1] = lastIdx + 1;
                    }
//                    if (gemIdx.get(gems[startIdx]).equals(startIdx)) {
//                        gemIdx.remove(gems[startIdx]);
//                    }
                    startIdx += 1;
                    break;
                }
            }
        }
        return answer;
    }

}
