class Solution {
    public int convertTime(String current, String correct) {
        int operation=0;
        String [] current_tokens=current.split(":");
        int current_hour=Integer.parseInt(current_tokens[0]);
        int current_minutes=Integer.parseInt(current_tokens[1]);
        String [] correct_tokens=correct.split(":");
        int correct_hour=Integer.parseInt(correct_tokens[0]);
        int correct_minutes=Integer.parseInt(correct_tokens[1]);
        int diff=0; 
        if(correct_hour > current_hour && current_minutes > correct_minutes){
        int k= (correct_hour - current_hour -1);
        diff= k* 60 +correct_minutes + (60-current_minutes);   
        }
        
        else{
        int k= (correct_hour - current_hour);
        diff= (k* 60) +correct_minutes - current_minutes; 
        }
        System.out.println(diff);
        while(diff > 0){
            int mul;
            if(diff>=60){
                mul=diff/60;
                operation+=mul;
                diff-=mul*60;
            }
           
            else if( diff <60 && diff>=15){
                mul=diff/15;
                operation+=mul;
                diff-=mul*15;
            }
            if(diff >= 5 &&
              diff < 15){
                mul=diff/5;
                operation+=mul;
                diff-=mul*5;
            }
            if(diff>=1  &&
                diff< 5){
                 mul=diff/1;
                operation+=mul;
                diff-=mul*1;
            }
        }
        return operation;
    }
}