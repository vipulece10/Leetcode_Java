class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;
        for(int num : nums){
            int number = 0;
            elementSum += num;
            number = num;
            while(number > 0){
                digitSum += number % 10;
                number /= 10;
            }
        }
        
        return Math.abs(elementSum - digitSum);
        
    }
}