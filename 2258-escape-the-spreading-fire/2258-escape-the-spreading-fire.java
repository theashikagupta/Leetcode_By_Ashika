import java.util.*;

class Solution {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Multi-source BFS for fire propagation
        int[][] fireTime = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(fireTime[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fireTime[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] k : dir) {
                int R = k[0] + r;
                int C = k[1] + c;
                if (R >= 0 && R < m && C >= 0 && C < n && grid[R][C] != 2) {
                    // Only update if we found a shorter time (unvisited cell)
                    if (fireTime[R][C] == Integer.MAX_VALUE) {
                        fireTime[R][C] = fireTime[r][c] + 1;
                        q.offer(new int[]{R, C});
                    }
                }
            }
        }

        // Binary search on maximum wait time
        int low = 0;
        int high = 1_000_000_000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, grid, fireTime)) {
                ans = mid;
                low = mid + 1; // Try waiting longer
            } else {
                high = mid - 1; // Reduce wait time
            }
        }

        return ans;
    }

    public boolean isPossible(int t, int[][] grid, int[][] fireTime) {
        int m = grid.length;
        int n = grid[0].length;

        // If fire reaches (0,0) before or at wait time t, we can't start
        if (t >= fireTime[0][0]) return false;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        queue.offer(new int[]{0, 0, t});
        vis[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int time = curr[2];

            if (row == m - 1 && col == n - 1) return true;

            for (int[] k : dir) {
                int nr = k[0] + row;
                int nc = k[1] + col;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 2 && !vis[nr][nc]) {
                    int nextTime = time + 1;

                    // Special condition for safehouse: can arrive at same time as fire
                    if (nr == m - 1 && nc == n - 1) {
                        if (nextTime <= fireTime[nr][nc]) {
                            return true;
                        }
                    } else {
                        // Regular cells must be reached strictly BEFORE fire arrives
                        if (nextTime < fireTime[nr][nc]) {
                            vis[nr][nc] = true;
                            queue.offer(new int[]{nr, nc, nextTime});
                        }
                    }
                }
            }
        }

        return false;
    }
}