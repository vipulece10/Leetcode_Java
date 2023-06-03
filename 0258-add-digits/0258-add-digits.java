class Solution {
    public int addDigits(int num) {
        int sum = 0;
        int x= num;
        
        while(x > 9){
            sum += x % 10;
            x = x / 10;
            if(x <= 9){
                sum += x;
                x = sum;
                sum = 0;
            }
        }
        
      return x;  
        
    }
}