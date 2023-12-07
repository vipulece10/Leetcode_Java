class Solution {
    /*
    https://youtu.be/yjHXS2w_IvY
    */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
    int rows = grid.length;
    int cols = grid[0].length;

    int[][] dist = new int[rows][cols];
    int[][] reach = new int[rows][cols];

    int totalBuildings = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 1) {
                bfs(grid, reach, dist, i, j);
                totalBuildings++;
            }    
        }
    }
    int minDistance = Integer.MAX_VALUE;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 0 && reach[i][j] == totalBuildings)
                minDistance = Math.min(minDistance, dist[i][j]);
        }
    }
    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;

    }
    
    private void bfs(int[][] grid, int[][] reach, int[][] dist, int row, int col) {
    int rows = grid.length;
    int cols = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{row, col});
    boolean[][] visited = new boolean[rows][cols];
    visited[row][col] = true;

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int distance = 0;

    while (!queue.isEmpty()) {
        distance++;

        for (int count = queue.size(); count > 0; count--) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (!isValid(grid, nx, ny, visited)) continue;

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
                reach[nx][ny]++;
                dist[nx][ny] += distance;
            }
        }
    }
}
private boolean isValid(int[][] grid, int row, int col, boolean[][] visited) {
    return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && 
        !visited[row][col] && grid[row][col] == 0;
}
}