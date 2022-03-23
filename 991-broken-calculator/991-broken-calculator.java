class Solution {
    public int brokenCalc(int startValue, int target) {
        int count=0;
       if(startValue == target)
           return 0;
        else if(target<startValue){
            return startValue-target;
        }
        else{
            while(target>startValue){
                count+=1;
                if(target % 2 ==0){
                    target/=2;
                }else{
                    target+=1;
                }
            }
            return count + startValue-target;
        }
        
    }
}