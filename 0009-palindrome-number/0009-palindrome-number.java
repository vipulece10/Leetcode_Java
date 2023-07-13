class Solution {
    public boolean isPalindrome(int x) {
        int num=0;
        int rem=0;
        int number=x;
        if(x<0) return false;
        while(x>0){
        rem=x%10;
        num=num*10+rem;
        x=x/10;    
        }
        System.out.print(num);
        // if(number==num)
        //     return true;
        // else
        //     return false;
         return number == num;   
        
    }
}