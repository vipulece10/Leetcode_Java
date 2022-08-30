class Solution {
    public int minimumKeypresses(String s) {
        int count=0;
        Integer [] freq = new Integer [26];
        Arrays.fill(freq,0);
        for(int i =0;i< s.length();i++){
            freq[s.charAt(i) -'a']++;
        }
        
        Arrays.sort(freq, (a,b)->b-a);
        for(int i =0;i<26;i++){
            if(i < 9 )
                count += 1 * freq[i];
            else if (i >= 9 && i < 18)
                count += 2 * freq[i];
            else
                count += 3 * freq[i];
        }
        
        return count;
    }
}