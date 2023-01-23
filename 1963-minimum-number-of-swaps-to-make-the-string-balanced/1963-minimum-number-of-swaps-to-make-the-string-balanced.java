class Solution {
    public int minSwaps(String s) {
        int maxClose = 0,extraClose = 0;
        
        char[] charArray = s.toCharArray();
        int  i =0;
        while(i < charArray.length){
            if(charArray[i] == ']')
                extraClose += 1;
            else
                extraClose -= 1;
            maxClose = Math.max(maxClose,extraClose);
            i++;
        }
        return (maxClose + 1)/2;
        
        
    }
}