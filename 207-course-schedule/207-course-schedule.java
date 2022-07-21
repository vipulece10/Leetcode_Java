class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int []indegree = new int [numCourses];
        //create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0 ;i<numCourses ;i++){
            ArrayList<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        
        for(int [] prereq : prerequisites){
            adj.get(prereq[1]).add(prereq[0]);
        }
        
        //create indegree 
        for(int i=0;i<numCourses;i++){
            for(Integer it : adj.get(i))
                indegree[it]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i =0;i<numCourses;i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        int cnt =0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            cnt++;
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        if (cnt == numCourses)
            return true;
        else return false;
    }
}