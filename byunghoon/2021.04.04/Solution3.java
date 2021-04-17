import java.util.*;
class Solution {
    public static int solution(String[] user_id, String[] banned_id) {
        // 경우의 수를 구함. 뭐가 어떻게 될지.
        //["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]
        //각 banned id에 대해서 배열에서 후보군들을 뽑고 그 후보군들 끼리의 조합을 구하면 될듯.
        List<Set<String>> data = new ArrayList<>();

        for (int i = 0; i < banned_id.length; i++) {
            data.add(new HashSet<>());
            for (int j = 0; j < user_id.length; j++) {
                // 각 banned Id에 적합한 후보군이 있으면 일단 추가.
                if (banned_id[i].length() == user_id[j].length()){
                    boolean result = true;
                    for (int k = 0; k < banned_id[i].length(); k++){
                        if (banned_id[i].charAt(k) == '*'){

                        } else if (banned_id[i].charAt(k) != user_id[j].charAt(k)){
                            result = false;
                        }
                    }
                    if (result){
                        data.get(i).add(user_id[j]);
                    }
                }
            }
        }

        Set<String>[] resultData = new HashSet[data.size()];
        int i = 0;
        for (Set<String> dataSet: data){
            resultData[i] = dataSet;
            i += 1;
        }

        Set<Set<String>> resultDataSet = _cartesianProduct(0, resultData);


        return ((int) resultDataSet.stream().filter(row -> row.size() == banned_id.length).count());
    }

    private static Set<Set<String>> _cartesianProduct(int index, Set<String>... sets) {
        Set<Set<String>> result = new HashSet<>();
        if (index == sets.length) {
            result.add(new HashSet<String>());
        } else {
            for (String obj : sets[index]) {
                for (Set<String> set : _cartesianProduct(index + 1, sets)) {
                    set.add(obj);
                    result.add(set);
                }
            }
        }
        return result;
    }
}