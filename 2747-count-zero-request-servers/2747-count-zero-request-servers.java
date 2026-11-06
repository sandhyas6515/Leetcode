import java.util.*;

class Solution {
public int[] countServers(int n, int[][] logs, int x, int[] queries) {

    Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

    int m = queries.length;

    int[][] sortedQueries = new int[m][2];

    for (int i = 0; i < m; i++) {
        sortedQueries[i][0] = queries[i];
        sortedQueries[i][1] = i;
    }

    Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

    int[] answer = new int[m];

    HashMap<Integer, Integer> map = new HashMap<>();

    int left = 0;
    int right = 0;

    for (int i = 0; i < m; i++) {

        int currentQuery = sortedQueries[i][0];

        int start = currentQuery - x;

        // Add logs within the current time range
        while (right < logs.length && logs[right][1] <= currentQuery) {

            int server = logs[right][0];

            map.put(server, map.getOrDefault(server, 0) + 1);

            right++;
        }

        // Remove logs outside the current time range
        while (left < right && logs[left][1] < start) {

            int server = logs[left][0];

            map.put(server, map.get(server) - 1);

            if (map.get(server) == 0) {
                map.remove(server);
            }

            left++;
        }

        answer[sortedQueries[i][1]] = n - map.size();
    }

    return answer;
}

}
