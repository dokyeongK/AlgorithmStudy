import java.util.*;
class Solution {

    private static List<String> answer = new ArrayList<>();
    private static boolean[] visited;
    private static String route = "";

    public static String[] solution(String[][] tickets) {

        for (int i = 0; i < tickets.length; i++) {
            // 매번 dfs를 갈때마다 visit배열이 초기화 되어야 함.
            visited = new boolean[tickets.length];
            String src = tickets[i][0];
            String dest = tickets[i][1];

            if (src.equals("ICN")){
                route = src + ",";
                visited[i] = true;
                dfs(dest, tickets, 1);
            }
        }

        // String으로 된 Route 경로를 sort해서 그 경로 중 알파벳 순서로 앞으로 된 경로를 선택
        Collections.sort(answer);
        return answer.get(0).split(",");
    }

    public static void dfs(String visit, String[][] tickets, int visitCount){
        // 현재 방문한 시점의 route를 저장.
        route += visit + ",";
        if (visitCount == tickets.length){
            answer.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 다음 노드 차례
            String src = tickets[i][0];
            String dest = tickets[i][1];
            // 무작위로 방문하는 것이 아니라, src가 dest와 같을때, 그리고 visit node가 없을 때? 방문.
            if (src.equals(visit) && !visited[i]) {
                // visited 가 true이면..
                visited[i] = true;
                // 다음 방문에서는 visited가 true니까... i를 traverse해도 뭐..
                dfs(dest, tickets, visitCount + 1);
                // visited 가 false이면.. =>
                visited[i] = false;
                // Route를 추가.
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}