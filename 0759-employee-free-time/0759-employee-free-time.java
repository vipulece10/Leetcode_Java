/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> {
         if(a.start != b.start){
             return a.start - b.start;
         }
        else{
            return a.end - b.end;
        }
        });
        List<Interval>res = new ArrayList<>(); 
        for(List<Interval> periods : schedule){
            for(Interval period : periods){
                pq.add(period);
            }
        }
        
        Interval prev = pq.poll();
        
        while(!pq.isEmpty()){
            Interval curr = pq.poll();
            if(prev.end < curr.start){
                res.add(new Interval(prev.end,curr.start));
            }
                prev.end = Math.max(prev.end,curr.end);
        }
        return res;
    }
}