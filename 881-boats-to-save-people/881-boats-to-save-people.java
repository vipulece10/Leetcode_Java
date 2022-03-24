class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0;
        int j=people.length - 1;
        int sum=0;
        int count=0;
        while(i <= j){
            sum = people[i] + people[j];
           if(sum <= limit){
             i++;
             j--;
              count++;
           }else{
               j--;
               count++;
           }
        }
        return count;
    }
}