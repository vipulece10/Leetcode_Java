class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()]; 
        return dfs_helper(0,rooms,visited);
    }
    private boolean dfs_helper(int i,List<List<Integer>> rooms,boolean[] visited){
        visited[i] = true;
        for(int key : rooms.get(i)){
            if(visited[key] == false){
                dfs_helper(key,rooms,visited);
            }
        }
        for(boolean val : visited){
            if(val == false)
                return false;
        }
        return true;
    }
}