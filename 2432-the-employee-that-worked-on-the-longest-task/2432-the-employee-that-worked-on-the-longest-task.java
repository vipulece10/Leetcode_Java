class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int time=logs[0][1];
        int id =logs[0][0];
        for(int i =1;i<logs.length;i++){
            int task_time = logs[i][1] - logs[i-1][1]; 
            //System.out.println("task_time " + task_time);
            if(task_time > time){
                time = task_time;
                id = logs[i][0];
                //System.out.println(time);
                //System.out.println(id);
            }
            else if(task_time == time){
                id = Math.min(id,logs[i][0]);
            }
        }
        return id;
    }
}
