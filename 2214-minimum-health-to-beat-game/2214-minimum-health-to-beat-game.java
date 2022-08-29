class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for(int i =0;i<damage.length;i++){
            max = Math.max(damage[i],max);
            sum+=damage[i];
        }
        
        if(max > armor)
            return sum - armor + 1;
        else
            return sum - max + 1;
    }
}