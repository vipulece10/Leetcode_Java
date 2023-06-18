class Solution {
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
                return a.compareTo(b);
            }
            else{
                return map.get(b) - map.get(a);
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
            pq.add(key);
        }
        
        // while(pq.size() > k){
        //     pq.remove();
        // }
        
        while(k > 0){
            res.add(pq.poll());
            k--;
        }
        return res;
    }
}