class Solution {
  private List<Integer>[] adj;
  private boolean[] seen;

  private int dfs(int node) {
    seen[node] = true;
    var cnt = 1;
    
    for (var neighbor : adj[node])
      if (!seen[neighbor])
        cnt += dfs(neighbor);
    
    return cnt;
  }
    public int maximumDetonation(int[][] bombs) {
        var max = 0;
    var n = bombs.length;
    seen = new boolean[n];
    adj = new ArrayList[n];

    for (var i=0; i<n; i++)
      adj[i] = new ArrayList<>();

    for (var i=0; i<n; i++) {
      for (var j=0; j<n; j++) {
        if (i == j) continue;

        var a = bombs[i];
        var b = bombs[j];

        if (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2) <= Math.pow(a[2], 2))
          adj[i].add(j);
      }
    }
    for (var i=0; i<n; i++) {
      Arrays.fill(seen, false);
      max = Math.max(max, dfs(i));
    }
    return max;
  }
    }