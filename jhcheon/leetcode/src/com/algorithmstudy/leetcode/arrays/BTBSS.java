package com.algorithmstudy.leetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;

//Best Time to Buy and Sell Stock
public class BTBSS {
    public int maxProfit(int[] prices) {
        int answer = 0;



        return answer;
    }



    //space complexity is very good, but time complexity is very suck.
    public int maxProfit_Bad(int[] prices) {
        int answer = 0;

        Set<Integer> set = Arrays.stream(prices.clone()).boxed().collect(Collectors.toSet());
        int idx = 0;
        int[] sortedPrices = new int[set.size()];
        for (Integer integer : set) {
            sortedPrices[idx++] = integer;
        }

        Map<Integer, Integer> buyPricesMap = new HashMap<>();
        Map<Integer, Integer> sellPricesMap = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            if (!buyPricesMap.containsKey(prices[i])) {
                buyPricesMap.put(prices[i], i);
            }
        }

        for (int i = prices.length-1; i >= 0; i--) {
            if (!sellPricesMap.containsKey(prices[i])) {
                sellPricesMap.put(prices[i], i);
            }
        }

        boolean flag = false;

        for (int j = sortedPrices.length-1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                int buy = buyPricesMap.get(sortedPrices[i]);
                int sell = sellPricesMap.get(sortedPrices[j]);
                if (sell > buy) {
                    answer = Math.max(answer, sortedPrices[j] - sortedPrices[i]);
                }
            }
        }
        return answer;
    }

    public int maxProfit3(int[] prices) {
        int answer = 0;
        int[] sortedPrices = prices.clone();
        Arrays.sort(sortedPrices);

        Map<Integer, ArrayList<Integer>> pricesMap = new HashMap<>();
        for (int i = 0; i < prices.length; i++) pricesMap.computeIfAbsent(prices[i], v -> new ArrayList<>()).add(i);

        Map<Integer, Integer> buyIdx = new HashMap<>();
        Map<Integer, Integer> sellIdx = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            buyIdx.put(prices[i], 0);
            sellIdx.put(prices[i], 0);
        }
        boolean flag = false;

        for (int j = prices.length-1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                int bIdx = buyIdx.get(sortedPrices[i]);
                int buy = pricesMap.get(sortedPrices[i]).get(bIdx);
                buyIdx.put(sortedPrices[i], bIdx+1);

                int sIdx = sellIdx.get(sortedPrices[j]);
                int sell = pricesMap.get(sortedPrices[j]).get(sIdx);
                sellIdx.put(sortedPrices[j], sIdx+1);
                if (sell > buy) {
                    answer = sortedPrices[j] - sortedPrices[i];
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        return answer;
    }
}
