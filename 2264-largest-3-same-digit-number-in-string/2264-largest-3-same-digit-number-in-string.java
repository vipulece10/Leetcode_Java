class Solution {
    public String largestGoodInteger(String num) {
        int maxVal = -1;
         StringBuilder res = new StringBuilder();
        for(int i = 0;i<num.length();i++){
            int left = i;
           // int right = i;
           
            int count = 1;
            while(left < num.length()-1 && num.charAt(left) == num.charAt(left+1)){
                count++;
                left++;
                if(count == 3){
                    int val = num.charAt(left) - '0';
                    if(val > maxVal){
                         maxVal = val;
                    }
                   i = left;
                  count = 1;
                    break;
                }
            }
        }
        
        
            for(int i=0;i<3 ;i++){
            res.append(String.valueOf(maxVal));
        }
        
        System.out.println(maxVal);
        
        return maxVal != -1? res.toString():"" ;
    }
}