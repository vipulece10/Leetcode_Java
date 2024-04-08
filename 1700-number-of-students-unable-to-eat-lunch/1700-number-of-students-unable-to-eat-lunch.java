class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // s_1 == number of student likes square(1) sandwiches
        //s_0== number of students likes circular(0) sandwiches
       int s_1=0;
       int s_0=0;
       for(int i=0;i<students.length;i++){
        if(students[i]==1){
            s_1++;
        }else{
            s_0++;
        }
       }
        for(int i=0;i<sandwiches.length;i++){
            if(sandwiches[i]==0 && s_0!=0){
                s_0--;
            }
            else if(sandwiches[i]==1 && s_1!=0){
                s_1--;
             }
             else if(sandwiches[i]==1 && s_1==0){
               return s_0;
             }
             else{
                return s_1;
             }
          }
       
       return 0;
        
    }
}