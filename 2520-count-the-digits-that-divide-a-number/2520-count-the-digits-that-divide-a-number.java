class Solution {
    public int countDigits(int num) {
        int count=0;
        int number = num;
        while(num > 0){
            int digit = num % 10;
            if(number % digit == 0){
                count++;
            }
            num = num / 10;
        }
        return count;
        
    }
}