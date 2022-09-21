class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] freq_s1 = new int [26];
        int [] freq_s2 = new int [26];
        
        int length = s1.length();
        
        for(int i=0;i<s1.length();i++){
            freq_s1[s1.charAt(i)-'a']++;
        }
        
        int i =0;
        int j=0;
        while(j<s2.length()){
            freq_s2[s2.charAt(j)-'a']++;
            if(j-i+1 == s1.length()){
                if(Arrays.equals(freq_s1,freq_s2)){
                    return true;
                }else{
                   freq_s2[s2.charAt(i)-'a']--;
                   i++; 
                }
            }
            
            j++;
        }
        return false;
        
    }
}