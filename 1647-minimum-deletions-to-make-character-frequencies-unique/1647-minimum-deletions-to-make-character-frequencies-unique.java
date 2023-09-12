class Solution {
    public int minDeletions(String s) {
        /*
        s = "aab"   [a->2,b->1]  0
        s = "aaabbbcc" [a->3,b->3,c->2]  set[3,2,1]
        s = "ceabaacb" [a->3,b->2,c->2,e->1]
        */
        
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        int [] freq = new int[26];
        
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        
        for(int i = 0;i<freq.length;i++){
            if(freq[i] > 0){
            int count = freq[i];
            while(set.contains(count) && count > 0){
                count--;
                ans++;
            }
            set.add(count);
            }
        }
        
        return ans;
        
    }
}