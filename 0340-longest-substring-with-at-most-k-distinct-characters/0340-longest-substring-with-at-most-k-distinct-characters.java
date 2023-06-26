class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        /*
        s = "eceba", k = 2
        left = 0; right = 0
        hm = {e->1,b->1}
        
        e c e b a
            ^
                 ^
        
        */
        
        
        
        int maxLength = 0;
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        int l = 0;int r = 0;
        
        while(r < n){
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0) + 1);
            while(hm.size() > k){
                if(hm.get(s.charAt(l)) > 1){
                    hm.put(s.charAt(l),hm.get(s.charAt(l)) - 1);
                }else{
                    hm.remove(s.charAt(l));
                }
                l++;
            }
            maxLength = Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
        
    }
}