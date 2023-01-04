class Solution {
    public int minimumRounds(int[] tasks) {
       /* int count = 0;
        boolean canComplete = true;
        HashMap<Integer,Integer> tasks_frequency = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(!tasks_frequency.containsKey(tasks[i])){
                tasks_frequency.put(tasks[i],1);
            }
            else{
                tasks_frequency.put(tasks[i],1+tasks_frequency.get(tasks[i]));
            }
        }
        
        for(Integer it : tasks_frequency.keySet()){
            int val = tasks_frequency.get(it);
            while(val > 0)
            if(val % 2 == 0 && val % 3 == 0){
                count += val / 3;
                val = val - 3*(val/3);
            }
            else if(val % 2 == 0){
                count += val / 2;
                val = val - 2*(val/2);
            }
            else if(val % 3 == 0 || val % 3 == 2){
                count += val / 3;
                val = val - 3*(val/3);
            }
            else{
                canComplete = false;
                break;
            } 
        }
        return canComplete == true ? count : -1; */
        
        //Simplified Version
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i:tasks){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        int ans = 0;
        for(int i:freq.values()){
            if(i==1) return -1;
            ans += (i+2)/3;
        }
        return ans;
    }
}