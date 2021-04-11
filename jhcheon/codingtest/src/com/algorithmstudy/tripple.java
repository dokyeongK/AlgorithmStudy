package com.algorithmstudy;

import java.util.*;

public class tripple {

    public static void main(String args[]) {
        int[] A = {42, 33, 60, 6, 600};
        System.out.println(solution1(A));
    }

    //N 개의 정수를 포함한 배열 A가 주어짐.
    //이 함수는 각 자릿수의 합이 같은 정수 2개의 합이 최대가 되는 값을 반환.
    //만약 각 자릿수의 합이 같은 정수들이 없으면 -1 반환.
    //N의 범위는 1 ~ 200,000
    //A의 각각의 요소들의 범위는 1 ~ 1,000,000,000
    //이거 이전 값들 중 최댓값들을 안구해서 틀렸다... 시발..
    public static int solution1(int[] A) {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        int resultMax = -1;
        for (int idx = 0; idx < A.length; idx++) {
            int value = A[idx];
            int tmpValue = value;
            int digitSum = 0;

            while (tmpValue != 0) {
                digitSum += tmpValue % 10;
                tmpValue = tmpValue / 10;
            }

            if (result.containsKey(digitSum)) {
                int maxSum = value + result.get(digitSum);
                if (maxSum > resultMax) resultMax = maxSum;
            }
            else result.put(digitSum, value);
        }
        return resultMax;
    }

    public static int solution2(int[] A) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        insert(hashMap, 0, -1);

        int count = 0;

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
//            System.out.println("index is " + i + ", sum is " + sum);
//            Iterator<Integer> iter = hashMap.keySet().iterator();
//            while (iter.hasNext()) {
//                Integer key = iter.next();
//                String value = hashMap.get(key).toString();
//                System.out.println(key + " : " + value);
//            }
            if (hashMap.containsKey(sum)) {
                List<Integer> list = hashMap.get(sum);
                count += list.size();
                for (Integer value: list) {
                    System.out.println("Subarray [" + (value + 1) + "..." + i +"]");
                }
            }
            insert(hashMap, sum, i);
//            System.out.println("+++++++++++++++++++++++++++++");
//            System.out.println("index is " + i);
//            Iterator<Integer> iter = hashMap.keySet().iterator();
//            while (iter.hasNext()) {
//                Integer key = iter.next();
//                String value = hashMap.get(key).toString();
//                System.out.println(key + " : " + value);
//            }
//            System.out.println("+++++++++++++++++++++++++++++");
        }

        return count;
    }

    public static<K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }


    //N개의 전구가 있음. (1부터 N까지)
    //첫 번째 전구는 파워 소켓에 연결되어져 있고 각각의 연속적인 전구들은 이전 전구에 연결되어있음.
    //처음에 모든 전구가 꺼져있음.
    //K의 순간 (K는 0부터 N-1까지), 우리는 A[K]번째 전구를 킴.
    //전구를 키고 모든 이전 전구들이 켜져있을 때 전구는 빛남.
    //이 때 전구키는 순서인 A가 주어졌을 때
    //켜져있는 전구가 모두 빛나는 순간의 횟수를 반
    public static int solution3(int[] A) {
        int[] bulbs = new int[A.length];
        Arrays.fill(bulbs, 0);

        int result = 0;
        for (int i = 0; i < A.length; i++){
            int bulbIndex = A[i] - 1;
            bulbs[bulbIndex] = 1;
            if (checkBlink(bulbs)){
                result += 1;
            }
        }
        return result;
    }

    private static boolean checkBlink(int[] A){
        if (A[0] != 1){
            return false;
        }
        boolean temp = false;

        for(int i = 1; i < A.length; i++){
            if (A[i] == 0){
                temp = true;
            }else if(temp && A[i] == 1){
                return false;
            }
        }
        return true;
    }

}
