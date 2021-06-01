package com.algorithmstudy.leetcode.programmers.dp;

public class MakeBignumber {
    public String solution(String number, int k ) {
        String answer = "";
        int n = number.length() - k;
        StringBuilder sb = new StringBuilder();
        int length = number.length();
        int idx = 0;
        while (n > 0) {
            char max = number.charAt(idx);
            int maxIdx = idx;
            for (int i = idx; i < length; i++) {
                if (length - i < n) break;
                if (max < number.charAt(i)) {
                    max = number.charAt(i);
                    maxIdx = i;
                }
            }
//            answer += max;
            sb.append(max);
            n--;
            idx = maxIdx + 1;
        }
        answer = sb.toString();
        return answer;
    }

    public String solution2(String number, int k ) {
        String answer = "";
        int n = number.length() - k;
        StringBuilder sb = new StringBuilder();
        int length = number.length();
        int idx = 0;
        String sub = number;
        while (n > 0) {
            char max = sub.charAt(0);
            int maxIdx = 0;
            for (int i = 0; i < sub.length(); i++) {
                if (sub.length() - i < n) break;
                if (max < sub.charAt(i)) {
                    max = sub.charAt(i);
                    maxIdx = i;
                }
            }
//            answer += max;
            sb.append(max);
            n--;
            sub = sub.substring(maxIdx + 1);
        }
        answer = sb.toString();
        return answer;
    }
}
