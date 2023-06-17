class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
         PriorityQueue<int[]> q = new PriorityQueue<>(1000, (int[] a, int[] b) ->{         //index, changes, value
        if(a[1] != b[1]) return a[1] - b[1];
        if(a[0] != b[0]) return b[0] - a[0];
        return                  a[2] - b[2];});

    TreeSet<Integer> nums2 = new TreeSet<>();                  
    for(int n: arr2) nums2.add(n);
    
    q.add(new int[]{0, 1, nums2.first()});             //put two starts
    q.add(new int[]{0, 0, arr1[0]});

    int[] values  = new int[arr1.length];              //for backtracing
    Arrays.fill(values, Integer.MAX_VALUE);

    while(!q.isEmpty()){                    
      int t[] = q.poll(); 
      int id = t[0], ch = t[1], val = t[2];
      if(id == arr1.length - 1) return ch;             //we have answer

      if(values[id] <= val) continue;                  //if we visited with lower value
      values[id] = val;

      if(arr1[++id] > val) q.add(new int[]{id, ch, arr1[id]});    //if next value from array is increasing
      Integer num = nums2.higher(val);
      if(num != null) q.add(new int[]{id, ch+1, num});          //if number from arr2 can increase current sequence
    }

    return -1;
    }
}