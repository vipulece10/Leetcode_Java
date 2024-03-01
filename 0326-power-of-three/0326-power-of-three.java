class Solution {
    public boolean isPowerOfThree(int n) {
       // System.out.println(1/3);
        if (n == 1)
            return true;
        double num = n*1.00;
        while(num>=1){
            if(num == 3.00)
                return true;
        num=num/3;
        }
        return false;
    }
}