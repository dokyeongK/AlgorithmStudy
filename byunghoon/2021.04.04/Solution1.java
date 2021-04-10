import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public static int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            String nextWord = words[i + 1];
            if (!nextWord.startsWith(word.substring(word.length() - 1))){
                int person = (i + 1) % n + 1;
                int idx = (i + 1) / n + 1;
                return new int[]{person, idx};
            }

            if (set.contains(nextWord)){
                int person = (i + 1) % n + 1;
                int idx = (i + 1) / n + 1;
                return new int[]{person, idx};
            }else{
                set.add(nextWord);
            }
        }

        return new int[]{0, 0};
    }
}