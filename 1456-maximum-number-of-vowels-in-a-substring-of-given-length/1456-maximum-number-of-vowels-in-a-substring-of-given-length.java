class Solution {
    // a b c i i i d e f      n = 9
    // 0 1 2 3 4 5 6 7 8 
    
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        
        int max = Integer.MIN_VALUE;
        int i = 0,j = 0,count = 0;
        while(j < s.length()){
            if(j-i+1 <= k){
                count += vowels.contains(s.charAt(j)) ? 1 : 0;
                if(j-i+1 == k)
                    max = Math.max(max,count);
                j++;
            }
            else{
                count -= vowels.contains(s.charAt(i)) ? 1 : 0;
                i++;
            }
        }
        return max;
    }
    
   
}