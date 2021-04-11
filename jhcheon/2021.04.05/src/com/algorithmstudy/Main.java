package com.algorithmstudy;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        String[] test = {"***", "f*fdf*", "********", "asdd*"};
//        solution3(test, test);
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
//        String[] banned_id = {"*rodo", "*rodo", "*****"};
//        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        solution3(user_id, banned_id);


    }

    public static int[] solution1(int n, String[] words) {
//region ArrayList와 HashSet을 썼을 때
//        ArrayList<String> checkDup = new ArrayList<String>();
//        int[] answer = {0, 0};
//        int[] counts = new int[n];
//        Arrays.fill(counts, 0);
//
//        checkDup.add(words[0]);
//        counts[0]++;
//        for (int idx = 1; idx < words.length; idx++) {
//            String previousStr = words[idx-1];
//            String currentStr = words[idx];
//
//            if (!previousStr.substring(previousStr.length()-1).equals(currentStr.substring(0, 1)) || checkDup.contains(currentStr)) {
//                answer[0] = (idx % n) + 1;
//                answer[1] = counts[idx % n] + 1;
//                break;
//            } else {
//                checkDup.add(currentStr);
//                counts[idx % n]++;
//            }
//        }
//        return answer;
//        HashMap과 HashSet을 안썼을 때 결과. 만약 이 둘을 쓰면 어떻게 바뀔까. 한 번 해보자.
//        테스트 1 〉	통과 (0.06ms, 52.9MB)
//        테스트 2 〉	통과 (0.08ms, 52.6MB)
//        테스트 3 〉	통과 (0.03ms, 52.8MB)
//        테스트 4 〉	통과 (0.07ms, 53.1MB)
//        테스트 5 〉	통과 (0.16ms, 52.2MB)
//        테스트 6 〉	통과 (0.05ms, 53.1MB)
//        테스트 7 〉	통과 (0.06ms, 53.9MB)
//        테스트 8 〉	통과 (0.05ms, 53.6MB)
//        테스트 9 〉	통과 (0.07ms, 52.1MB)
//        테스트 10 〉	통과 (0.17ms, 52.7MB)
//        테스트 11 〉	통과 (0.12ms, 52MB)
//        테스트 12 〉	통과 (0.09ms, 52.4MB)
//        테스트 13 〉	통과 (0.04ms, 52.3MB)
//        테스트 14 〉	통과 (0.04ms, 53MB)
//        테스트 15 〉	통과 (0.04ms, 52.2MB)
//        테스트 16 〉	통과 (0.04ms, 52.4MB)
//        테스트 17 〉	통과 (0.04ms, 52.9MB)
//        테스트 18 〉	통과 (0.06ms, 52.2MB)
//        테스트 19 〉	통과 (0.04ms, 51.9MB)
//        테스트 20 〉	통과 (0.41ms, 52.6MB)

//        HashSet<String> checkDup = new HashSet<String>();
//        int[] answer = {0, 0};
//
//        checkDup.add(words[0]);
//        for (int idx = 1; idx < words.length; idx++) {
//            String previousStr = words[idx-1];
//            String currentStr = words[idx];
//
//            checkDup.add(currentStr);
//            if (!previousStr.substring(previousStr.length()-1).equals(currentStr.substring(0, 1)) ||
//                checkDup.size() != idx + 1) {
//                answer[0] = (idx % n) + 1;
//                answer[1] = (idx / n) + 1;
//                break;
//            }
//        }
//        return answer;
//        테스트 1 〉	통과 (0.07ms, 52.3MB)
//        테스트 2 〉	통과 (0.19ms, 52.4MB)
//        테스트 3 〉	통과 (0.04ms, 52.6MB)
//        테스트 4 〉	통과 (0.07ms, 53.1MB)
//        테스트 5 〉	통과 (0.10ms, 52.7MB)
//        테스트 6 〉	통과 (0.06ms, 52.3MB)
//        테스트 7 〉	통과 (0.05ms, 52.2MB)
//        테스트 8 〉	통과 (0.04ms, 52MB)
//        테스트 9 〉	통과 (0.05ms, 52.9MB)
//        테스트 10 〉	통과 (0.09ms, 52.7MB)
//        테스트 11 〉	통과 (0.07ms, 52MB)
//        테스트 12 〉	통과 (0.06ms, 52.2MB)
//        테스트 13 〉	통과 (0.04ms, 52.9MB)
//        테스트 14 〉	통과 (0.06ms, 52.2MB)
//        테스트 15 〉	통과 (0.04ms, 53.2MB)
//        테스트 16 〉	통과 (0.06ms, 52.3MB)
//        테스트 17 〉	통과 (0.06ms, 52.5MB)
//        테스트 18 〉	통과 (0.05ms, 52.9MB)
//        테스트 19 〉	통과 (0.04ms, 52.2MB)
//        테스트 20 〉	통과 (0.11ms, 52.2MB)
        //쓰는게 낫구나! 그럼 이제 HashMap 써보자때
        //endregion E
        HashMap<String, Integer> checkDup = new HashMap<String, Integer>();
        int[] answer = {0, 0};

        checkDup.put(words[0], 1);
        for (int idx = 1; idx < words.length; idx++) {
            String previousStr = words[idx-1];
            String currentStr = words[idx];

            if (!previousStr.substring(previousStr.length()-1).equals(currentStr.substring(0, 1)) ||
                    checkDup.get(currentStr) != null) {
                answer[0] = (idx % n) + 1;
                answer[1] = (idx / n) + 1;
                break;
            }
        }
        return answer;
        //HashMap이 제일 빠르다!!!!
//region
//        테스트 1 〉	통과 (0.04ms, 52.7MB)
//        테스트 2 〉	통과 (0.03ms, 52.8MB)
//        테스트 3 〉	통과 (0.02ms, 52.6MB)
//        테스트 4 〉	통과 (0.06ms, 52.3MB)
//        테스트 5 〉	통과 (0.06ms, 52.9MB)
//        테스트 6 〉	통과 (0.03ms, 52.7MB)
//        테스트 7 〉	통과 (2.97ms, 52.2MB)
//        테스트 8 〉	통과 (0.04ms, 51.9MB)
//        테스트 9 〉	통과 (0.04ms, 51.9MB)
//        테스트 10 〉	통과 (0.06ms, 53.1MB)
//        테스트 11 〉	통과 (0.06ms, 52.5MB)
//        테스트 12 〉	통과 (0.05ms, 51.9MB)
//        테스트 13 〉	통과 (0.04ms, 52.3MB)
//        테스트 14 〉	통과 (0.03ms, 53.2MB)
//        테스트 15 〉	통과 (0.03ms, 52.6MB)
//        테스트 16 〉	통과 (0.04ms, 53.5MB)
//        테스트 17 〉	통과 (0.03ms, 52.5MB)
//        테스트 18 〉	통과 (0.03ms, 52.1MB)
//        테스트 19 〉	통과 (0.03ms, 51.9MB)
//        테스트 20 〉	통과 (0.09ms, 52.3MB)
//endregion
    }

    public static boolean solution2(String s) {
        // toCharArray() vs charAt()
        // 이거 돌려봤는데 기본 테스트에서는 시간 거의 비슷했고,
        // 효율성 테스트에서는 toCharArray로 하는게 더 빨랐음.
//region
//        char[] charS = s.toCharArray();
//        int leftBr = 0;
//        int rightBr = 0;
//
//        if (charS[0] == ')') return false;
//        for (int idx = 0; idx < charS.length; idx++) {
//            if (charS[idx] == '(') {
//                leftBr++;
//            } else if (charS[idx] == ')') {
//                if (leftBr == rightBr) return false;
//                rightBr++;
//            } else continue;
//        }
//
//        return leftBr == rightBr;
//endregion

        //좀 더 깔끔하게 풀면 이렇게 될듯??
        //이게 효율성 테스트에서도 많이 빠름. 7.39 ms -> 6.57 ms, 6.39 ms -> 4.91 ms 로 줄임.
        char[] charS = s.toCharArray();
        int count = 0;

        for (int idx = 0; idx < charS.length; idx++) {
            if (charS[idx] == '(') {
                count++;
            } else if (charS[idx] == ')') {
                count--;
            } else continue;

            if (count < 0) return false;
        }

        return count == 0;
    }

    public static int solution3(String[] user_id, String[] banned_id) {
        //banned_id 들의 * 위치를 구한 다음에 서로 다 빼고 같은지 계산.
        int answer = 0;
        HashMap<Integer, ArrayList<String>> idMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> bannedIdStarAt = new HashMap<>();

        //이 부분은 정규식을 쓰게 된다 필요없는 부분.
        for (int idx1 = 0; idx1 < banned_id.length; idx1++) {
            char[] charBanned = banned_id[idx1].toCharArray();
            ArrayList<Integer> starAt = new ArrayList<>();
            for (int idx2 = 0; idx2 < charBanned.length; idx2++) {
                if (charBanned[idx2] == '*') starAt.add(idx2);
            }
            if (starAt.size() == charBanned.length) starAt.clear();
            bannedIdStarAt.put(idx1, starAt);
        }

        for (int idx1 = 0; idx1 < banned_id.length; idx1++) {
            ArrayList<Integer> starAt = bannedIdStarAt.get(idx1);
            ArrayList<String> similarId = new ArrayList<>();
            String withoutStarBanId = banned_id[idx1].replaceAll("\\*", "");
            for (int idx2 = 0; idx2 < user_id.length; idx2++) {
                if (banned_id[idx1].length() == user_id[idx2].length()) {
                    if (starAt.isEmpty()) similarId.add(user_id[idx2]);
                    else {
                        StringBuilder withoutStarUserId = new StringBuilder(user_id[idx2]);
                        for (int idx3 = 0; idx3 < starAt.size(); idx3++) {
                            withoutStarUserId.deleteCharAt(starAt.get(idx3) - idx3);
                        }
                        if (withoutStarBanId.equals(withoutStarUserId.toString())) similarId.add(user_id[idx2]);
                    }
                }
            }
            idMap.put(idx1, similarId);
        }

        ArrayList<ArrayList<String>> numberOfCasesWithDup = new ArrayList<>(); //얘는 걍 전역으로 빼자.
        ArrayList<String> oneCase = new ArrayList<>();
        boolean[] visited = new boolean[banned_id.length];
        Arrays.fill(visited, false);
        getNumberOfCases(numberOfCasesWithDup, oneCase, idMap, visited, 0);

//        for (ArrayList<String> temp : numberOfCasesWithDup) {
//            System.out.println(temp);
//        }

        for (ArrayList<String> temp : numberOfCasesWithDup) {
            Collections.sort(temp);
        }

        HashSet<ArrayList<String>> answerSet = new HashSet<>();
        for (ArrayList<String> temp2 : numberOfCasesWithDup) {
            answerSet.add(temp2);
        }
        answer = answerSet.size();
        return answer;
    }

    public static void getNumberOfCases(ArrayList<ArrayList<String>> numberOfCasesWithDup, ArrayList<String> oneCase,
                                        HashMap<Integer, ArrayList<String>> idMap, boolean[] visited, int depth) {
        if (depth == idMap.size()) {
            numberOfCasesWithDup.add(oneCase);
            return;
        }

        for (int idx = depth; idx < idMap.size(); idx++) {
            for (int idx2 = 0; idx2 < idMap.get(idx).size(); idx2++) {
                if (!oneCase.contains(idMap.get(idx).get(idx2)) && !visited[idx]) {
                    oneCase.add(idMap.get(idx).get(idx2));
                    visited[idx] = true;
                    getNumberOfCases(numberOfCasesWithDup, (ArrayList<String>) oneCase.clone(), idMap, visited, depth + 1);
                    oneCase.remove(idMap.get(idx).get(idx2));
                    visited[idx] = false;
                }
            }
        }
    }
//
//    테스트 1 〉	통과 (0.41ms, 52.1MB)
//    테스트 2 〉	통과 (3.11ms, 52MB)
//    테스트 3 〉	통과 (1.17ms, 52.4MB)
//    테스트 4 〉	통과 (1.01ms, 52.5MB)
//    테스트 5 〉	통과 (0.02ms, 53.9MB)
//    테스트 6 〉	통과 (46.34ms, 61.1MB)
//    테스트 7 〉	통과 (1.03ms, 52.7MB)
//    테스트 8 〉	통과 (2.07ms, 52.1MB)
//    테스트 9 〉	통과 (3.08ms, 51.6MB)
//    테스트 10 〉	통과 (0.02ms, 52.3MB)
//    테스트 11 〉	통과 (3.69ms, 52.4MB)
}
