public class Solution3{
    public int[] solution(String[] genres, int[] plays) {
        // plays map은 각 장르별 조회수가 포함됨.
        Map<String, Integer> playsMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (playsMap.containsKey(genres[i])) {
                playsMap.replace(genres[i], playsMap.get(genres[i]) + plays[i]);
            }else{
                playsMap.put(genres[i], plays[i]);
            }
        }

        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();

        playsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        // 각 장르 별로 포문을 돌고 장르별 조회수 맵을 얻은다음 정렬. 그다음 정렬 후 results셋에 더함
        List<Integer> results = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : reverseSortedMap.entrySet()) {
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (entry.getKey().equals(genres[i])){
                    indexMap.put(i, plays[i]);
                }
            }
            LinkedHashMap<Integer, Integer> tempMap = new LinkedHashMap<>();

            indexMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> tempMap.put(x.getKey(), x.getValue()));
            Set<Integer> keySet = tempMap.keySet();
            Iterator iterator = keySet.iterator();
            for (int i = 0; i < 2; i++) {
                if(iterator.hasNext()){
                    results.add((int)iterator.next());
                }
            }
        }

        int[] answer = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }

        return answer;
    }
}
}