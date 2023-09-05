class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        /*
        slots1 = [[10,50],[60,120],[140,210]], 
        slots2 = [[0,15],[60,70]]
        */
        //List<Integer> res = new ArrayList<>();
        Arrays.sort(slots1,(a,b)->a[0] - b[0]);
        Arrays.sort(slots2,(a,b)->a[0] - b[0]);
        
        int i = 0; //iterate on slots1
        int j = 0; //iterate on slots2
        while(i < slots1.length && j < slots2.length){
            int start = Math.max(slots1[i][0],slots2[j][0]);
            int end = Math.min(slots1[i][1],slots2[j][1]);
            if(start + duration <= end){
                // res.add(start);
                // res.add(start + duration);
                // return res;
                return Arrays.asList(start, start + duration);
            }
            if(slots1[i][1] < slots2[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return new ArrayList<>();
    }
}