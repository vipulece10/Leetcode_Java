class Solution {
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return IsValid(s,i+1,j) || IsValid(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean IsValid(String s,int k,int l) {
        
        while(k<=l){
            if(s.charAt(k)!=s.charAt(l)){
                return false;
            }
            k++;
            l--;
        }
        return true;
    }
    
    
}