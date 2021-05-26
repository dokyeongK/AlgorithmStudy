package com.algorithmstudy.leetcode.programmers.dp;

//124 나라의 숫자
// 1 % 3 = 1
// 2 % 3 = 2
// 3 % 3 = 0
public class NumberOfCountry124 {
    public String solution(int n) {
        String answer = "";
        String[] list = {"4", "1", "2"};
        while (n > 0) {
            int rem = n % 3;
            n = n / 3;
            if (rem == 0) n--;
            answer = list[rem] + answer;
        }

        return answer;
    }

    public int getPow(int n, int sum, int p) {
        int temp = sum;
        temp += Math.pow(3, p)*3;
        if (temp >= n) return p;
        else return getPow(n, temp, p+1);
    }
}
