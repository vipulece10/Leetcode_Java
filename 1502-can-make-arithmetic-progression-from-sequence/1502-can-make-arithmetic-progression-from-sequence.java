class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        
        if(max - min == 0)
            return true;
        if((max - min) % (n-1) != 0)
            return false;
        int cd = (max - min)/(n - 1);
        //System.out.println(min + " " + max + " " + cd);
        
        for(int i = 0;i<arr.length;i++){
            if((arr[i] - min) % cd != 0)
                return false;
            
            set.add(arr[i]);
        }
        return set.size() == n;
    }
}