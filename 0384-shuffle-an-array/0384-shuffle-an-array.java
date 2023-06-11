class Solution {
    private int[] res;
    Random rand = new Random();
    public Solution(int[] nums) {
        this.res = nums;
    }
    
    public int[] reset() {
        return res;
    }
    
    public int[] shuffle() {
        int [] shuffle_array = new int [res.length];
        int max = shuffle_array.length -1;
        int min = 0;
        int range = max - min;
        for(int i=0;i<res.length;i++){
            shuffle_array[i] = res[i];
        }
        for(int i = 0;i<shuffle_array.length;i++){
            //int index = (int)(Math.random() * range) + min;
            int index = rand.nextInt(shuffle_array.length - i) +i;
            int temp = shuffle_array[i];
            shuffle_array[i] = shuffle_array[index];
            shuffle_array[index] = temp;
        }
        return shuffle_array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */