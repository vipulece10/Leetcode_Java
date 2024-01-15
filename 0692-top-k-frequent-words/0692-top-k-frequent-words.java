class Solution {
    //https://leetcode.com/problems/top-k-frequent-words/discuss/176865/O(nlogk)-time-to-O(n)-time
    // class Pair{
    //     int frequency_count;
    //     int index_count;
    //     public pair(int frequency_count,int index_count){
    //         this.frequency_count = frequency_count;
    //         this.index_count = index_count
    //     }
    // }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(map.get(a) == map.get(b)){
                return b.compareTo(a);
            }
            else{
                return map.get(a) - map.get(b);
            }
        });
        for(int i =0;i < words.length;i++){
            // if(!map.containsKey(words[i])){
            //     map.put(words[i],new Pair(1,i));
            // }else{
            //     int freq_val = map.get(words[i]).frequency_count;
            //     int index_val = map.get(words[i]).index_count;
            //      map.put(words[i],new Pair(freq_val + 1,index_val));
            // }
            map.put(words[i],map.getOrDefault(words[i],0) + 1);
        }
        
        int i = 0;
        for(String key : map.keySet()){
            // if (pq.size() < k){
            //     pq.add(key);
            // }else{
            //     if(map.get(pq.peek()) < map.get(key)){
            //         pq.remove();
            //         pq.add(key);
            //     }
            //     else if(map.get(pq.peek()) == map.get(key)){
            //         pq.add(key);
            //     }
            // }
            
            pq.offer(key);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
       
        
        while(pq.size() > 0){
            res.add(0,pq.poll());
           // k--;
        }
        return res;
    }
}