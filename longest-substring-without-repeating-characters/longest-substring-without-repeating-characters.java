class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlength = Integer.MIN_VALUE;
        Set <Character> hs = new HashSet<>();
        int j = 0;
        int i = 0;
        if(s.length() == 0)
            return 0;
        while( j < s.length()){
            if(hs.add(s.charAt(j))){
                maxlength=Math.max(maxlength,j-i+1);
                j++;
            }
            else{
                hs.remove(s.charAt(i));
                i++;
              /*  while(i<j){
                    if(s.charAt(i) != s.charAt(j)){
                         hs.remove(s.charAt(i));
                        i++;
                    }
                    else{
                        hs.remove(s.charAt(i));
                        i++;
                        break;
                    }
                } */
            }
             
        }
        return maxlength;
    }
}