//package com.algorithmstudy;
//
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//	// write your code here
//        int k = 1000;
//        int[] arr = {2, 138, 382, 29, 10, 438, 957, 22, 10, 2, 5, 4, 5, 6, 7, 8, 9, 3};
//        System.out.println(solution3(k, arr));
//    }
//
//    public static int solution(int k, int[] arr) {
//        //인덱스+1은 레일 번호, 값은 해당 레일의 장애물 개
//        int[] rails = new int[k];
//
//        //레일 당 장애물 개수 측
//        for(int i = 0; i < arr.length; i++) {
//            int n = arr[i];
//            rails[n - 1]++;
//        }
//        /*
//        ##idea##
//        연속적인 레일에 장애물이 거리 순대로 차례대로 있을시 제거. -> 총 1번.
//        즉, 장애물 제거에 대한 각각의 행동은 서로 독립적임.
//        따라서 연속적인 레일에 장애물이 있는 경우를 제외하고 나머지는 그냥 1번이 듬.
//        연속적인 레일에 장애물이 있는 경우에 대해, 중간 장애물을 먼저 제거하지 않도록 가장 가까운 장애물부터 제거 시작이 이상적이라고 생각됨.
//         */
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int num1 = arr[i];
//            if (rails[num1-1] != 0) {
//                rails[num1-1]--;
//                int interval = 1;
//                for (int j = i + 1; j < arr.length; j++) {
//                    if (arr[j] - arr[i] == interval){
//                        int num2 = arr[j];
//                        if (rails[num2-1] > 0) {
//                            rails[num2-1]--;
//                        } else break;
//                        interval++;
//                    }
//                }
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public static int solution_1(int K, int[] arr) {
//        int[] rails = new int[K];
//        boolean[] check = new boolean[K];
//
//        for (int i = 0; i < arr.length; i++) {
//            int n = arr[i];
//            rails[n - 1]++;
//        }
//        Arrays.fill(check, false);
//
//        return 1;
//
//    }
//
//    public static int solution3(int K, int[] A) {
//        Map<Integer, TreeSet<Integer>> obstacleMap = new HashMap<>();
//        Map<Integer, Integer> checkMap = new HashMap<>();
//
//        for (int i = 0; i < A.length; i++) {
//            obstacleMap.computeIfAbsent(A[i], k -> new TreeSet<>());
//            obstacleMap.get(A[i]).add(i);
//            checkMap.put(i, A[i]);
//        }
//
//        int checkIndex = 0;
//        int lane, nowPosition;
//        int answer = 0;
//
//        while (!checkMap.isEmpty()) {
//            while (checkMap.get(checkIndex) == null) {
//                checkIndex++;
//            }
//
//            lane = checkMap.get(checkIndex);
//            nowPosition = checkIndex;
//            checkMap.remove(checkIndex);
//            obstacleMap.get(lane).remove(obstacleMap.get(lane).first());
//            lane++;
//            answer++;
//            if(checkMap.isEmpty()){
//                break;
//            }
//
//            while (lane <= K && obstacleMap.get(lane) != null && obstacleMap.get(lane).size() > 0) {
//                if(obstacleMap.get(lane).higher(nowPosition) != null){
//                    nowPosition = obstacleMap.get(lane).higher(nowPosition);
//                    obstacleMap.get(lane).remove(nowPosition);
//                    checkMap.remove(nowPosition);
//                    lane++;
//                } else{
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }
//
////    public static int solution3(int K, int[] A) {
////        //obstacleMap은 장애물이 몇번째 인덱스에 있는
////        Map<Integer, List<Integer>> obstacleMap = new HashMap<>();
////        Map<Integer, Integer> checkMap = new HashMap<>();
////
////        for (int i = 0; i < A.length; i++) {
////            obstacleMap.computeIfAbsent(A[i], k -> new LinkedList<>());
////            obstacleMap.get(A[i]).add(i);
////            checkMap.put(i, A[i]);
////        }
////
////        int checkIndex = 0;
////        int lane, nowPosition;
////        int answer = 0;
////        while (!checkMap.isEmpty()) {
////            while (checkMap.get(checkIndex) == null) checkIndex++;
////
////            lane = checkMap.get(checkIndex);
////            nowPosition = checkIndex;
////            checkMap.remove(checkIndex);
////            obstacleMap.get(lane).remove(0);
////            lane++;
////            answer++;
////
////            while (lane <= K && obstacleMap.get(lane) != null && obstacleMap.get(lane).size() > 0) {
////                boolean check = false;
////                for(int i = 0; i < obstacleMap.get(lane).size(); i++){
////                    if(obstacleMap.get(lane).get(i) > nowPosition){
////                        nowPosition = obstacleMap.get(lane).get(i);
////                        obstacleMap.get(lane).remove(i);
////                        checkMap.remove(nowPosition);
////                        lane++;
////                        check = true;
////                        break;
////                    }
////                }
////                if(!check) break;
////            }
////        }
////
////        return answer;
////    }
//
////    public static int solution3_1(int K, int[] A) {
////        Map<Integer, TreeSet<Integer>> obstacleMap = new HashMap<>();
////        Map<Integer, Integer> checkMap = new HashMap<>();
////
////        for (int i = 0; i < A.length; i++) {
////            obstacleMap.computeIfAbsent(A[i], k -> new TreeSet<>());
////            obstacleMap.get(A[i]).add(i);
////            checkMap.put(i, A[i]);
////        }
////
////        int checkIndex = 0;
////        int lane, nowPosition;
////        int answer = 0;
////        while (!checkMap.isEmpty()) {
////            while (checkMap.get(checkIndex) == null) checkIndex++;
////
////            lane = checkMap.get(checkIndex);
////            nowPosition = checkIndex;
////            checkMap.remove(checkIndex);
////            obstacleMap.get(lane).remove(obstacleMap.get(lane).first());
////            lane++;
////            answer++;
////
////            while (lane <= K && obstacleMap.get(lane) != null && obstacleMap.get(lane).size() > 0) {
////                if(obstacleMap.get(lane).higher(nowPosition) != null){
////                    nowPosition = obstacleMap.get(lane).higher(nowPosition);
////                    obstacleMap.get(lane).remove(nowPosition);
////                    checkMap.remove(nowPosition);
////                    lane++;
////                } else{
////                    break;
////                }
////            }
////        }
////
////        return answer;
////    }
//}
