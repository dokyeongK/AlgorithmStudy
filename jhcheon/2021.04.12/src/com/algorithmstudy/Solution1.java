package com.algorithmstudy;

//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
//        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//        4-3. ')'를 다시 붙입니다.
//        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//        4-5. 생성된 문자열을 반환합니다.

public class Solution1 {
    public String solution(String p) {
        if (p.isEmpty() || isCorrectBracket(p)) return p;

        String answer = convertBracket(p);

        return answer;
    }

    public String convertBracket(String s) {
        if (s.isEmpty()) return s;
        String u = "";
        String v = "";
        int count = 0;
        char[] charS = s.toCharArray();

        for (int i = 0; i < charS.length; i++) {
            if (charS[i] == '(') count++;
            else count--;
            if (count == 0) {
                u = s.substring(0, i+1);
                v = s.substring(i+1, s.length());
                break;
            }
        }

        if (isCorrectBracket(u)) return u + convertBracket(v);
        else {
            String temp = "(" + convertBracket(v) + ")";
            String delU = u.substring(1, u.length()-1);
            char[] charDelU = delU.toCharArray();
            for (int j = 0; j < charDelU.length; j++) {
                if (charDelU[j] == '(') charDelU[j] = ')';
                else charDelU[j] = '(';
            }
            delU = String.valueOf(charDelU);
            return temp + delU;
        }
    }

    public boolean isCorrectBracket(String str) {
        char[] charStr = str.toCharArray();
        int count = 0;

        if (charStr[0] == ')') return false;
        for (int i = 0; i < charStr.length; i++) {
            if (charStr[i] == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return true;
    }

//    테스트 1 〉	통과 (0.02ms, 53.2MB)
//    테스트 2 〉	통과 (13.28ms, 52.9MB)
//    테스트 3 〉	통과 (0.02ms, 52MB)
//    테스트 4 〉	통과 (9.31ms, 52.1MB)
//    테스트 5 〉	통과 (0.02ms, 52.1MB)
//    테스트 6 〉	통과 (8.61ms, 52.1MB)
//    테스트 7 〉	통과 (14.58ms, 52.4MB)
//    테스트 8 〉	통과 (0.04ms, 52.3MB)
//    테스트 9 〉	통과 (9.28ms, 54.2MB)
//    테스트 10 〉	통과 (10.71ms, 51.6MB)
//    테스트 11 〉	통과 (12.24ms, 53MB)
//    테스트 12 〉	통과 (8.70ms, 52.4MB)
//    테스트 13 〉	통과 (11.41ms, 52.4MB)
//    테스트 14 〉	통과 (9.44ms, 52.9MB)
//    테스트 15 〉	통과 (10.74ms, 52.2MB)
//    테스트 16 〉	통과 (11.36ms, 52.8MB)
//    테스트 17 〉	통과 (14.13ms, 53.7MB)
//    테스트 18 〉	통과 (11.20ms, 53.4MB)
//    테스트 19 〉	통과 (11.54ms, 52.6MB)
//    테스트 20 〉	통과 (10.11ms, 53.6MB)
//    테스트 21 〉	통과 (24.96ms, 56.8MB)
//    테스트 22 〉	통과 (8.95ms, 52.8MB)
//    테스트 23 〉	통과 (15.15ms, 53.4MB)
//    테스트 24 〉	통과 (8.33ms, 53.1MB)
//    테스트 25 〉	통과 (9.47ms, 53.1MB)
}
