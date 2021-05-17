package com.algorithmstudy.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public TwoSum() {}

    public int[] solution(int[] nums, int target) {
        int answer[] = {-1, -1};
        Map<Integer, ArrayList<Integer>> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.computeIfAbsent(nums[i], v -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (numsMap.get(temp) != null) {
                if (temp == nums[i] && numsMap.get(temp).size() > 1) {
                    answer[0] = numsMap.get(temp).get(0);
                    answer[1] = numsMap.get(temp).get(1);
                } else {
                    answer[0] = numsMap.get(temp).get(0);
                    answer[1] = numsMap.get(nums[i]).get(0);
                }
            }
        }

        return answer;
    }
    public int[] solution_muchfaster(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                return new int[] {map.get(nums[i]), i};

            }

            map.put(target - nums[i], i);

        }

        return new int[]{};
    }
    public int[] solution2(int[] nums, int target) {
        int[] answer = {0, 0};
        Map<Integer, ArrayList<Integer>> originNumsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            originNumsMap.computeIfAbsent(nums[i], v -> new ArrayList<>()).add(i);
        }
        Arrays.sort(nums);
        Map<Integer, ArrayList<Integer>> sortedNumsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sortedNumsMap.computeIfAbsent(nums[i], v -> new ArrayList<>()).add(i);
        }
        System.out.println(originNumsMap);
        int startIdx = -1;
        int temp = target;
        while (true) {
            if (sortedNumsMap.get(temp) != null) {
                startIdx = sortedNumsMap.get(temp).get(0);
                break;
            }
            else temp--;
        }

        for (int i = 0; i <= startIdx; i++) {
            int temp2 = target - nums[i];
            if (sortedNumsMap.get(temp2) != null) {
                if (nums[i] == temp2 && originNumsMap.get(nums[i]).size() > 1) {
                    answer[0] = originNumsMap.get(nums[i]).get(0);
                    answer[1] = originNumsMap.get(nums[i]).get(1);
                } else {
                    answer[0] = originNumsMap.get(nums[i]).get(0);
                    answer[1] = originNumsMap.get(temp2).get(0);
                }

            }
        }

        return answer;



    }
}
