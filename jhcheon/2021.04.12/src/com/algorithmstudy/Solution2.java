package com.algorithmstudy;

import java.util.*;

//모든 조건에 대한 info set들 구하기.
//방법에는 비트연산통해서 for문으로 하던가, dfs로 하던가
//둘 다 해보자
public class Solution2 {
    public void getCaseOfUserKey(HashMap<String, ArrayList<Integer>> applicantInfos, String[] splitKey,
                                 String[] key, boolean[] visited, int len, int start, int depth) {
        if (depth == len) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 4; i++) str.append(key[i]);
            applicantInfos.computeIfAbsent(str.toString(), v -> new ArrayList<>()).add(Integer.parseInt(splitKey[4]));
        }

        for (int i = depth; i < 4; i++) {
            if (!visited[i]) {
                visited[i] = true;
                key[depth] = splitKey[i];
                getCaseOfUserKey(applicantInfos, splitKey, key, visited, len, i+1, depth+1);
                key[depth] = "";
                visited[i] = false;
            }
        }
    }

    //dfs를 통해 모든 경우의 key set을 구함.
    //아 어떤 건 통과하고 어떤 건 못하는데 왜 그렇지ㅋㅋ
    //ㅋㅋ 이분탐색 문제로 결론남.
    public int[] solution2(String[] info, String[] query) {
        int[] answer = new int[query.length];

        boolean[] visited = new boolean[4];
        Arrays.fill(visited, false);
        HashMap<String, ArrayList<Integer>> applicantInfos = new HashMap<>();

        for (String strInfo : info) {
            String[] splitKey = strInfo.split(" ");
            String[] keyArr = new String[4];
            Arrays.fill(keyArr, "");
            for (int i = 0; i < 5; i++) {
                getCaseOfUserKey(applicantInfos, splitKey, keyArr, visited, i, 0, 0);
            }
        }

        for (ArrayList<Integer> scores : applicantInfos.values()) {
            // equal to scores.sort(Comparator.naturalOrder())
            scores.sort(null);
        }

        ArrayList<Integer> emptyList = new ArrayList<>();
        for (int i = 0; i < query.length; i++) {
            String[] splitQuery = query[i].replaceAll("-", "").split(" and | ");
            String key = splitQuery[0] + splitQuery[1] + splitQuery[2] + splitQuery[3];
            int queryScore = Integer.parseInt(splitQuery[4]);
            ArrayList<Integer> matchedInfos = applicantInfos.getOrDefault(key, emptyList);

            int left = 0;
            int right = matchedInfos.size()-1;
            int mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (queryScore > matchedInfos.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            answer[i] = matchedInfos.size() - left;

        }

        return answer;
    }
//    테스트 1 〉	통과 (22.92ms, 54MB)
//    테스트 2 〉	통과 (29.85ms, 53.2MB)
//    테스트 3 〉	통과 (35.34ms, 53.9MB)
//    테스트 4 〉	통과 (82.59ms, 58.3MB)
//    테스트 5 〉	통과 (87.69ms, 62.8MB)
//    테스트 6 〉	통과 (82.15ms, 63.3MB)
//    테스트 7 〉	통과 (122.46ms, 62.3MB)
//    테스트 8 〉	통과 (254.58ms, 77.4MB)
//    테스트 9 〉	통과 (241.64ms, 79.1MB)
//    테스트 10 〉	통과 (252.56ms, 80.2MB)
//    테스트 11 〉	통과 (90.95ms, 63.4MB)
//    테스트 12 〉	통과 (86.36ms, 65.5MB)
//    테스트 13 〉	통과 (110.00ms, 61.5MB)
//    테스트 14 〉	통과 (177.58ms, 72.6MB)
//    테스트 15 〉	통과 (165.81ms, 72.3MB)
//    테스트 16 〉	통과 (123.81ms, 63.2MB)
//    테스트 17 〉	통과 (100.37ms, 63.7MB)
//    테스트 18 〉	통과 (172.30ms, 71.8MB)
//    효율성  테스트
//    테스트 1 〉	통과 (1688.82ms, 382MB)
//    테스트 2 〉	통과 (1537.04ms, 366MB)
//    테스트 3 〉	통과 (1592.61ms, 351MB)
//    테스트 4 〉	통과 (1652.63ms, 369MB)

    // bit 연산을 통해 모든 경우의 key set을 구함.
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        HashMap<String, ArrayList<Integer>> applicantInfos = new HashMap<>();

        for (String userInfoStr : info) {
            String[] splitAppInfo = userInfoStr.split(" ");
            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder applicantKey = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) {
                        applicantKey.append(splitAppInfo[j]);
                    }
                }
                applicantInfos.computeIfAbsent(applicantKey.toString(),
                        v -> new ArrayList<>()).add(Integer.parseInt(splitAppInfo[4]));
            }
        }

        for (ArrayList<Integer> scores : applicantInfos.values()) {
            // equal to scores.sort(Comparator.naturalOrder())
            scores.sort(null);
        }

        ArrayList<Integer> emptyList = new ArrayList<>();
        for (int i = 0; i < query.length; i++) {
            String[] splitQuery = query[i].replaceAll("-", "").split(" and | ");
            String key = splitQuery[0] + splitQuery[1] + splitQuery[2] + splitQuery[3];
            int queryScore = Integer.parseInt(splitQuery[4]);
            ArrayList<Integer> matchedInfos = applicantInfos.getOrDefault(key, emptyList);

            int left = 0;
            int right = matchedInfos.size();
            int mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (queryScore > matchedInfos.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            answer[i] = matchedInfos.size() - left;

        }

        return answer;
    }
//    테스트 1 〉	통과 (22.19ms, 53.8MB)
//    테스트 2 〉	통과 (20.10ms, 54.5MB)
//    테스트 3 〉	통과 (29.95ms, 53.9MB)
//    테스트 4 〉	통과 (78.07ms, 58.2MB)
//    테스트 5 〉	통과 (83.34ms, 58.7MB)
//    테스트 6 〉	통과 (78.97ms, 57.5MB)
//    테스트 7 〉	통과 (117.62ms, 62MB)
//    테스트 8 〉	통과 (148.68ms, 70.9MB)
//    테스트 9 〉	통과 (161.68ms, 74.4MB)
//    테스트 10 〉	통과 (192.32ms, 74.1MB)
//    테스트 11 〉	통과 (89.98ms, 58.2MB)
//    테스트 12 〉	통과 (101.37ms, 59MB)
//    테스트 13 〉	통과 (111.38ms, 62.3MB)
//    테스트 14 〉	통과 (113.89ms, 64.6MB)
//    테스트 15 〉	통과 (130.00ms, 63.9MB)
//    테스트 16 〉	통과 (78.00ms, 58.8MB)
//    테스트 17 〉	통과 (81.47ms, 57.7MB)
//    테스트 18 〉	통과 (125.06ms, 64.3MB)
//    효율성  테스트
//    테스트 1 〉	통과 (1422.95ms, 336MB)
//    테스트 2 〉	통과 (1241.46ms, 328MB)
//    테스트 3 〉	통과 (1286.22ms, 358MB)
//    테스트 4 〉	통과 (1523.67ms, 366MB)
}

// 인터넷에서 찾은 코드. 아이디어를 얻었으니 안보고 짜보자.
//    Map<String, List<Integer>> infos = new HashMap<>();
//        for (String in : info) {
//                String[] split = in.split(" ");
//                int score = Integer.parseInt(split[4]);
//
//                for (int i = 0; i < (1 << 4); i++) {
//        StringBuilder key = new StringBuilder();
//        for (int j = 0; j < 4; j++) {
//        if ((i & (1 << j)) > 0) key.append(split[j]);
//        }
//
//        infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
//        }
//        }
//
//        List<Integer> empty = new ArrayList<>();
//        for (Map.Entry<String, List<Integer>> entry : infos.entrySet())
//        entry.getValue().sort(null);
//
//        int[] answer = new int[query.length];
//        for (int i = 0; i < query.length; i++) {
//        String[] split = query[i].replaceAll("-", "").split(" and | ");
//        String key = String.join("", split[0], split[1], split[2], split[3]);
//        int score = Integer.parseInt(split[4]);
//
//        List<Integer> list = infos.getOrDefault(key, empty);
//        int s = 0, e = list.size();
//
//        while (s < e) {
//        int mid = (s + e) / 2;
//
//        if (list.get(mid) < score) s = mid + 1;
//        else e = mid;
//        }
//
//        answer[i] = list.size() - s;
//        }
//
//        return answer;




// 내가 직접 짠 코드
// 정확도는 만점받았지만, 효율성 부문에서 단 한개도 통과못함ㅋㅋㅋ
// 인터넷에서 얻은 코드에서 아이디어를 얻었으니 한 번 고쳐보
//        int[] answer = new int[query.length];
//
//        HashMap<String, String>[] applicantInfos = new HashMap[info.length];
//        HashMap<String, String>[] queryInfos = new HashMap[query.length];
//
//        for (int i = 0; i < info.length; i++) {
//            applicantInfos[i] = new HashMap<>();
//            String appInfo = info[i];
//            String[] splitAppInfo = appInfo.split(" ");
//            applicantInfos[i].put("lang", splitAppInfo[0]);
//            applicantInfos[i].put("job", splitAppInfo[1]);
//            applicantInfos[i].put("career", splitAppInfo[2]);
//            applicantInfos[i].put("soulfood", splitAppInfo[3]);
//            applicantInfos[i].put("score", splitAppInfo[4]);
//        }
//
//        for (int i = 0; i < query.length; i++) {
//            queryInfos[i] = new HashMap<>();
//            String qInfo = query[i];
//            String[] splitQInfo = qInfo.split(" and ");
//            String[] splitSoulAndScore = splitQInfo[3].split(" ");
//            queryInfos[i].put("lang", splitQInfo[0]);
//            queryInfos[i].put("job", splitQInfo[1]);
//            queryInfos[i].put("career", splitQInfo[2]);
//            queryInfos[i].put("soulfood", splitSoulAndScore[0]);
//            queryInfos[i].put("score", splitSoulAndScore[1]);
//        }
//
//        for (int qIdx = 0; qIdx < query.length; qIdx++) {
//            int count = 0;
//            for (int aIdx = 0; aIdx < info.length; aIdx++) {
//                if (!queryInfos[qIdx].get("lang").equals("-")) {
//                    if (!queryInfos[qIdx].get("lang").equals(applicantInfos[aIdx].get("lang"))) continue;
//                }
//                if (!queryInfos[qIdx].get("job").equals("-")) {
//                    if (!queryInfos[qIdx].get("job").equals(applicantInfos[aIdx].get("job"))) continue;
//                }
//                if (!queryInfos[qIdx].get("career").equals("-")) {
//                    if (!queryInfos[qIdx].get("career").equals(applicantInfos[aIdx].get("career"))) continue;
//                }
//                if (!queryInfos[qIdx].get("soulfood").equals("-")) {
//                    if (!queryInfos[qIdx].get("soulfood").equals(applicantInfos[aIdx].get("soulfood"))) continue;
//                }
//                int queryScore = Integer.valueOf(queryInfos[qIdx].get("score"));
//                int appScore = Integer.valueOf(applicantInfos[aIdx].get("score"));
//                if (appScore >= queryScore) count++;
//            }
//            answer[qIdx] = count;
//        }
//
//        return answer;