package com.algorithmstudy.leetcode;


import com.algorithmstudy.leetcode.DP.*;
import com.algorithmstudy.leetcode.arrays.BTBSS;
import com.algorithmstudy.leetcode.arrays.TwoSum;
import com.algorithmstudy.leetcode.programmers.dp.*;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        EnforcementCamera ec = new EnforcementCamera();
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(routes.length);
        System.out.println(ec.solution(routes));
    }
}

