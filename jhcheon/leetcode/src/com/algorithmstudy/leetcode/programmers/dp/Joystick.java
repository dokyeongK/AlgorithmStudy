package com.algorithmstudy.leetcode.programmers.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Joystick {
    //ABAAAAABA
    //case : ABABAAAAABA 일 때 어떻게 해결할 것인가?
    public int solution(String name) {
        int answer = 0;
        Map<Character, Integer> alphabet = new HashMap<>();
        ArrayList<Integer> idxArr = new ArrayList<>();
        int cnt = 0;
        for (int i = 65; i <= 90; i++) {
            char c = (char) i;
            alphabet.put(c, cnt++);
        }
        int lrCnt = 0;
        int lr1 = 0;
        int lr2 = 0;
        int lr2prev = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                idxArr.add(i);
                lr1 = i;
            }
        }
        for (int i = name.length()-1; i >= 1; i--) {
            if (name.charAt(i) != 'A') {
                lr2prev = lr2;
                lr2 = i;
            }
        }
        idxArr.sort(null);
        int lr3 = Integer.MAX_VALUE;
        for (int i = 0; i < idxArr.size()-1; i++) {
            lr3 = Math.min(lr3, (idxArr.get(i)*2) + name.length() - idxArr.get(i+1));
        }

        if (lr1 != 0) {
            lrCnt = Math.min(lr1, name.length() - lr2);
            lrCnt = Math.min(lrCnt, lr3);
        }

        int udCnt = 0;
        for (int i = 0; i < name.length(); i++) {
            int ud1 = alphabet.get(name.charAt(i));
            if (ud1 > 13) ud1 = 26-ud1;
            udCnt += ud1;
        }

        answer = lrCnt + udCnt;
        return answer;
    }
}
