class Solution {
    class Pair{
        int count;
        int time;
        Pair(int count,int time){
            this.count = count;
            this.time = time;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int [] freq = new int[26];
        for(int i = 0;i<tasks.length;i++){
            freq[tasks[i] - 'A']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        Queue<Pair> q = new LinkedList<>();
        for(int i =0;i<26;i++){
            if(freq[i] > 0)
                pq.add(freq[i]);
        }
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
            int val = pq.poll();
            val--;
            if(val > 0){
                q.add(new Pair(val,time+n));
            }
            }
            if(!q.isEmpty() && q.peek().time == time){
                pq.add(q.remove().count);
            }    
        }
        return time;
    }
}