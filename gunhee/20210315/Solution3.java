import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N + 1];

        br.close();

        result[0] = 0;
        result[1] = 0;

        for (int i = 2; i < N + 1; i++) {
            result[i] = result[i - 1] + 1;
            if (i % 2 == 0) result[i] = Math.min(result[i], result[i / 2] + 1);
            if (i % 3 == 0) result[i] = Math.min(result[i], result[i / 3] + 1);
        }

        System.out.println(result[N]);
    }
}
