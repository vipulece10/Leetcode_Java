class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0 || intervals == null){
          return 0;  
        }
        int n = intervals.length;
        int i =1;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<int []> minheap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int [] start =intervals[0];
        minheap.add(start);
        while(i<n){
            
            int [] curr = intervals[i];
            int [] earliest = minheap.remove();
            if (curr[0] >= earliest[1] ){
                earliest[1] = curr[1];
                
            }
            else{
                minheap.add(curr);
                
            }
            minheap.add(earliest);
            i++;
        }
       return minheap.size(); 
    }
}