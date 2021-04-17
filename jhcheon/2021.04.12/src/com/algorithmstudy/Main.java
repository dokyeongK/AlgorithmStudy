package com.algorithmstudy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
//        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
//        String[] query = {"- and - and - and - 0"};
//        String[] query = {"- and - and - and - 150"};

//        Solution2 s2 = new Solution2();
//        int[] result = s2.solution2(info, query);
//        for (int val : result) System.out.println(val);

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        Solution3 s3 = new Solution3();
        System.out.println(s3.solution2(skill, skill_trees));
    }

}
