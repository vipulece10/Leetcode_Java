class Solution {
    public boolean makePalindrome(String s) {
        int count = 0;
        int low = 0;
        int high = s.length() - 1;
        
        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                count++;
            }
            low++;
            high--;
        }
        
        return count<3 ? true : false;
        
    }
}