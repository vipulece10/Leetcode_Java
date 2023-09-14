class Solution {
    //https://leetcode.com/problems/find-the-closest-palindrome/discuss/122957/Java-compare-five-candidates-get-result-easy-to-understand
    
    public String nearestPalindromic(String n) {
        List<Long> list = new ArrayList<>();
        
        if (n.length() == 1)
            return String.valueOf(Integer.parseInt(n) - 1);
        
        int length = n.length();
        long diff = Long.MAX_VALUE;
        
        int middle = length % 2 == 0 ? length/2 - 1 : length/2;
        long left = Long.parseLong(n.substring(0,middle+1));
        long input = Long.parseLong(n);
        String ans = "";
        
        list.add(getPalindrome(left,length%2==0));
        list.add(getPalindrome(left+1,length%2==0));
        list.add(getPalindrome(left-1,length%2==0));
        list.add((long)Math.pow(10,length -1)-1);
        list.add((long)Math.pow(10,length)+1);
        
        for(long value : list){
            // System.out.println(value);
            // System.out.println(input);
            if(value == input)
                continue;
            
            if(Math.abs(input - value) < diff){
                diff = Math.abs(input - value);
                ans = String.valueOf(value);
            }
            else if(Math.abs(input - value) == diff){
                ans = String.valueOf(Math.min(Long.parseLong(ans),value));
            }
        }
        
        return ans;
    }
    
    private long getPalindrome(long left,boolean even){
         System.out.println(even);
        long res = left;
        if(!even){
            left = left/10;
        }
        
        while(left > 0){
            res = res * 10 + left % 10;
            left = left / 10;
        }
        
        return res;
    }
}