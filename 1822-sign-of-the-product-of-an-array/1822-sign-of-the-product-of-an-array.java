class Solution {
    public int arraySign(int[] nums) {
        long product = 1;
        for(int num : nums){
            if(num > 0)
                product = product * 1;
            else if (num < 0)
                product = product * -1;
            else
                product = product * 0;
        }
        System.out.println(product);
        if(product > 0)
            return 1;
        else if(product < 0)
            return -1;
        else 
            return 0;
    }
}