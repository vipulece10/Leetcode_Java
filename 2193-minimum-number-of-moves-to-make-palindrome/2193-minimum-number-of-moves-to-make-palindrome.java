class Solution {
    public int minMovesToMakePalindrome(String s) {
        int count = 0;
        while(s.length() > 2) {
            char ch1 = s.charAt(0);
            int len = s.length();
            char ch2 = s.charAt(len - 1);
            if(ch1 == ch2){
                s= s.substring(1,len - 1);
            }
            else{
                int idx1 = s.lastIndexOf(ch1);
                int idx2 = s.indexOf(ch2);
                int step1 = len - 1 - idx1;
                int step2 = idx2;
                StringBuilder sb = new StringBuilder();
                if(step1 > step2){
                    count += step2;
                    sb.append(s.substring(0,idx2));
                    sb.append(s.substring(idx2+1,len-1));
                }
                else{
                    count += step1;
                    sb.append(s.substring(1,idx1));
                    sb.append(s.substring(idx1+1));
                }
                s = sb.toString();
            }
            
        }
        return count;
    }
}