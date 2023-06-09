class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int [] indegree = new int[n+1];
        List<List<Integer>>graph = new ArrayList<>();
        for(int i =0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[]relation : relations){
            graph.get(relation[0]).add(relation[1]);
            indegree[relation[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int studyCount = 0;
        for(int i = 1;i<n+1;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int step = 0;
        
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int node = q.poll();
                studyCount++;
                for(int elem : graph.get(node)){
                    indegree[elem]--;
                    if(indegree[elem] == 0){
                        q.add(elem);
                        
                    }
                }
            }
           step++; 
        }
        System.out.println(studyCount);
        return studyCount == n ? step : -1;
    }
}