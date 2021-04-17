package com.algorithmstudy;

import java.util.*;

public class Solution3 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] charSkill = skill.toCharArray();
        Map<Character, Integer> skillMap = new HashMap<>();
        LinkedHashMap<Character, Integer>[] skillTreeMap = new LinkedHashMap[skill_trees.length];

        for (int i = 0; i < charSkill.length; i++) {
            skillMap.put(charSkill[i], i);
        }

        for (int i = 0; i < skill_trees.length; i++) {
            skillTreeMap[i] = new LinkedHashMap<>();
            char[] userSkill = skill_trees[i].toCharArray();
            for (int j = 0; j < userSkill.length; j++) {
                skillTreeMap[i].put(userSkill[j], j);
            }
        }

        boolean isCorrect = true;
        for (LinkedHashMap<Character, Integer> map : skillTreeMap) {
            for (int i = charSkill.length-1; i >= 0; i--) {
                if (map.containsKey(charSkill[i])) {
                    if (i != 0) {
                        if (!map.containsKey(charSkill[i-1]) || map.get(charSkill[i]) < map.get(charSkill[i-1])) {
                            isCorrect = false;
                            break;
                        }
                    }
                }
            }
            if (isCorrect) answer++;
            isCorrect = true;
        }

        return answer;
    }
//    테스트 1 〉	통과 (0.16ms, 52.4MB)
//    테스트 2 〉	통과 (0.16ms, 52.3MB)
//    테스트 3 〉	통과 (0.20ms, 52.4MB)
//    테스트 4 〉	통과 (0.19ms, 52.9MB)
//    테스트 5 〉	통과 (0.22ms, 53.3MB)
//    테스트 6 〉	통과 (0.19ms, 52.8MB)
//    테스트 7 〉	통과 (0.24ms, 53.2MB)
//    테스트 8 〉	통과 (0.25ms, 52.3MB)
//    테스트 9 〉	통과 (0.29ms, 54.4MB)
//    테스트 10 〉	통과 (0.26ms, 52.4MB)
//    테스트 11 〉	통과 (0.26ms, 53.1MB)
//    테스트 12 〉	통과 (0.32ms, 52.6MB)
//    테스트 13 〉	통과 (0.30ms, 52MB)
//    테스트 14 〉	통과 (0.21ms, 52.6MB)


    //다른 사람 풀이
    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();
        System.out.println(skillTrees);
        while (it.hasNext()) {
            String str = it.next();
            String str2 = str;
            System.out.println(str2);
            String str3 = str2.replaceAll("[^" + skill + "]", "");
            System.out.println(str3);
            int test = skill.indexOf(str3);
            System.out.println(test);
            System.out.println();
            if (skill.indexOf(str.replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
//    테스트 1 〉	통과 (9.84ms, 53.5MB)
//    테스트 2 〉	통과 (8.82ms, 53.4MB)
//    테스트 3 〉	통과 (8.00ms, 53.2MB)
//    테스트 4 〉	통과 (8.55ms, 53.4MB)
//    테스트 5 〉	통과 (10.02ms, 54MB)
//    테스트 6 〉	통과 (9.71ms, 52.6MB)
//    테스트 7 〉	통과 (8.83ms, 53MB)
//    테스트 8 〉	통과 (8.46ms, 52.6MB)
//    테스트 9 〉	통과 (9.67ms, 52.9MB)
//    테스트 10 〉	통과 (8.83ms, 53.1MB)
//    테스트 11 〉	통과 (8.89ms, 53MB)
//    테스트 12 〉	통과 (11.19ms, 52.2MB)
//    테스트 13 〉	통과 (8.53ms, 53MB)
//    테스트 14 〉	통과 (8.97ms, 52.9MB)
}
