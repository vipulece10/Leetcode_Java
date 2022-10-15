class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mp_s = new HashMap();
        Map<Character, Integer> mp_t = new HashMap<>();
        String res = "";
        if(s.length() < t.length())
            return res;
        int have = 0;
        int need = t.length();
        int min_wsize = Integer.MAX_VALUE; 
        for(int i =0;i<t.length();i++){
            mp_t.put(t.charAt(i),mp_t.getOrDefault(t.charAt(i),0)+1);
        }
        int start = 0;
        
        for(int end =0; end < s.length();end++){
            char ch = s.charAt(end);
            if(!mp_s.containsKey(s.charAt(end))){
               mp_s.put(s.charAt(end), 1); 
                System.out.print("added ");
            }else{
                System.out.print(s.charAt(end)+" ");
                mp_s.put (s.charAt(end), 1 + mp_s.get(s.charAt(end))); 
            }
            
           // mp_s.put(s.charAt(end),1 + mp_s.getOrDefault(s.charAt(end),0));
            if(mp_t.containsKey(s.charAt(end)) && mp_s.get(s.charAt(end)) <= mp_t.get(s.charAt(end))){
                have++;
            }
            
            while(have == need){
                 if(min_wsize > end-start+1){
                     min_wsize = end-start+1;
                     res = s.substring(start, end+1);
                 }
                //  min_wsize = Math.min(min_wsize,end - start + 1);
                // // System.out.print(min_wsize);
                //  res = s.substring(start,end+1);
                
                if(mp_s.get(s.charAt(start)) > 1){
                    mp_s.put(s.charAt(start) ,mp_s.get(s.charAt(start)) -1);
                }
                else{
                    mp_s.remove(s.charAt(start));
                }
                
                if(mp_t.containsKey(s.charAt(start)) && mp_s.getOrDefault(s.charAt(start),0) < mp_t.get(s.charAt(start))){
                    have--;
                }
                start++;
            }
        }
        return res;
    }
}