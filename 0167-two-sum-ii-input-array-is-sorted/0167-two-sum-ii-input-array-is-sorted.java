class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length - 1;
       // int [] res = new int [2];
        while(i < j){
            if((numbers[i] + numbers[j]) - target == 0){
                //  res[0]=i+1;
                //  res[1]=j+1;
                // break;
                return new int [] {i+1,j+1};
            }
            else if ((numbers[i] + numbers[j]) - target > 0)
                j--;
            else
                i++;
        }
        return new int[]{};
        
    }
}