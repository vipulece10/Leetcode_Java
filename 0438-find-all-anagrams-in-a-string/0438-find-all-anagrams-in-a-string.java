class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[]freq_p = new int [26];
        int[]freq_win = new int [26];
        for(int i =0;i<p.length();i++){
            freq_p[p.charAt(i) - 'a']++;
        }
        
        int start =0;
        int end = 0;
        while(end < s.length()){
            freq_win[s.charAt(end) - 'a']++;
            if(end - start + 1 == p.length()){
                if(Arrays.equals(freq_p,freq_win)){
                    res.add(start);
                }
                freq_win[s.charAt(start)-'a']--;
                start++;
            }
            end++;
        }
        return res;
    }
}