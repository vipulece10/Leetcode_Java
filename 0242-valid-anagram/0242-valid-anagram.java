class Solution {
    
    /***
    0 1 2 3 4 5 6 7 8 9 10 11  12  13  14  15
    H e l l o 7 8 6   M  i  k  h   a   e   l   abc
    i i i i i 
    si = 9;currMax = 0,resInd = 0
    currMax = 5;
    resind = 0;
    
    ***/
    
    public boolean isAnagram(String s, String t) {
        int [] charcount=new int [128];
        for(int i=0;i<s.length();i++){
            charcount[s.charAt(i)-'a']++;
        }
         
        for(int i=0;i<t.length();i++){
            charcount[t.charAt(i)-'a']--;
        }
        
        for(int i=0;i<charcount.length;i++){
            if(charcount[i]!=0){
                return false;
            }
        }
        return true;
    }
}