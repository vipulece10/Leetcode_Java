class Solution {
    public int divide(int dividend, int divisor) {
        /*
        100,3
        100 -3 = 97
        100 - 3*2 = 94
        ....
        ....
        ....
        100 - 3*32 = 4
        
        
        3,6,12,24,48,96
        1,2,4,8,16,32
        */
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        if(dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;
            
        boolean isNegative = false;
        if((dividend < 0 && divisor >= 0) || (divisor < 0 && dividend >= 0))
            isNegative = true;
         long dd = Math.abs((long)dividend);
         long dr = Math.abs((long)divisor);
        int ans = 0;
        while(dr <= dd){
             long count = 1;
             long sum = dr;
            
            while(sum <= dd - sum){
                sum += sum;
                count += count;
            }
            ans += count;
            dd -= sum;
        }
        return isNegative == true ? -ans : ans;
    }
}