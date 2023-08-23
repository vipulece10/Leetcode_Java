class Solution {
    public String reorganizeString(String s) {
        int max_count = Integer.MIN_VALUE;
        HashMap<Character,Integer> freq_map = new HashMap<>();
        PriorityQueue <Character> pq = new PriorityQueue<>((a,b)->freq_map.get(b) - freq_map.get(a));
        for(int i =0;i<s.length();i++){
            if(freq_map.containsKey(s.charAt(i))){
                freq_map.put(s.charAt(i),1+freq_map.get(s.charAt(i)));
            }
            else{
                freq_map.put(s.charAt(i),1);
            }
            
            max_count = Math.max(max_count,freq_map.get(s.charAt(i)));
        }
        
        for(Character c : freq_map.keySet()){
            pq.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size() >1){
           
            Character first = pq.poll();
            Character second = pq.poll();
            sb.append(first);
            sb.append(second);
            if(freq_map.get(first) > 0)
            freq_map.put(first,freq_map.get(first) - 1);
            if(freq_map.get(second) > 0)
            freq_map.put(second,freq_map.get(second) - 1);
            if(freq_map.get(first) > 0)
            pq.add(first);
            if(freq_map.get(second) > 0)
            pq.add(second);
        }
        
        if(!pq.isEmpty()){
                if(freq_map.get(pq.peek()) > 1)
                    return "";
                sb.append(pq.poll());
            }
          
            
        
       return sb.toString(); 
        
    }
}