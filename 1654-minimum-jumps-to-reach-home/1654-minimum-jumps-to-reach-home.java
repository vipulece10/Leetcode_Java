class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2)->a1[0] - a2[0]);
        Set<Integer> visited = new HashSet<>();
        for(int num : forbidden){
            visited.add(num);
        }
        pq.add(new int[]{0,0,0});
        visited.add(0);
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int position = top[0];
            int step = top[1];
            int isBackward = top[2];
            // System.out.println(position);
            if(position == x){
                 //System.out.println(position);
                return step;
               
            }
            
            int forward = position + a;
            int backward = position - b;
            
            if(forward <=6000 && !visited.contains(forward)){
                pq.add(new int[]{forward,step+1,0});
                visited.add(forward);
            }
            
            if(backward >= 0 && !visited.contains(backward) && isBackward != 1){
                pq.add(new int[]{backward,step+1,1});
                visited.add(backward);
            }
        } 
    return -1;
        
    }
}