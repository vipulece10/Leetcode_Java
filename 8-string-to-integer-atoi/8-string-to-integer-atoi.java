class Solution {
    public int myAtoi(String s) {
        //s.trim();
        boolean isNegative = false;
        int result = 0;
        int i=0;
        int flag=0;
        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }
        
        while(i<s.length() && s.charAt(i) == '-'){
            if(isNegative)
                return 0;
            isNegative = true;
            i++;
        }
        
        while(i<s.length() && s.charAt(i) == '+'){
           // isNegative = false;
            if(flag == 1)
                return 0;
            flag=1;
            if(isNegative)
                return 0;
            i++;
        }
        
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            if((Integer.MAX_VALUE - (s.charAt(i)-'0'))/10 < result ){
                    if(isNegative){
                        return Integer.MIN_VALUE;
                    }
                    else{
                       return Integer.MAX_VALUE; 
                    }
                }
            result= result * 10 + (s.charAt(i)-'0');
            i++;
        }
        
        if(isNegative){
            return result * -1;
        }
        else{
        return result;
        }
        }
        
    }
