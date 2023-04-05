class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] indegree = new int [numCourses];
        int [] ans=new int [numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            ArrayList<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        
        for(int [] prereq : prerequisites){
            adj.get(prereq[1]).add(prereq[0]);
        }
        
        int k=0;
        for(int i=0;i<numCourses;i++){
            for(Integer it :adj.get(i)){
                indegree[it]++;  
                k++;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i< numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int index=0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            ans[index++] = node;
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        if(index == numCourses)
        return ans;
        else
        return new int [0];     
    }
}