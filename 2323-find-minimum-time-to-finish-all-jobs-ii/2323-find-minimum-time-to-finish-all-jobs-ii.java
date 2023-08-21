class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        /*
        jobs = [5,2,4], workers = [1,7,5]
        
        pq_jobs [5,4,2] ,  [18,15,9,3]
        
        pq_workers [7,5,1],[6,5,3,1]     (3,3,3,3) 
        
        */
        
        PriorityQueue<Integer> pqJobs = new PriorityQueue<Integer>((a,b)->b-a);
        PriorityQueue<Integer> pqWorkers = new PriorityQueue<Integer>((a,b)->b-a);

        for(int job : jobs){
            pqJobs.add(job);
        }
        
        for(int work : workers){
            pqWorkers.add(work);
        }
        
        double day = 0.0;
        
        while(!pqJobs.isEmpty() && !pqWorkers.isEmpty()){
            int job = pqJobs.poll();
            int work = pqWorkers.poll();
            double time = (job * 1.0)/work;
           
            
            day = Math.max(day,Math.ceil(time));
        }
        return (int)day;
    }
}