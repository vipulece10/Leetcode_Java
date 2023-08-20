class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        //https://youtu.be/7ReZyOniO74
        Map<String,List<String>> graph = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for(List<String> edge : tickets){
            String start = edge.get(0);
            String end = edge.get(1);
            graph.computeIfAbsent(start,g->new ArrayList<>());
            graph.computeIfAbsent(end,g->new ArrayList<>());
            graph.get(start).add(end);
        }
        
        for(String key : graph.keySet()){
            Collections.sort(graph.get(key));
        }
        
        String begin = "JFK";
        findItinerary(begin,graph,tickets.size(),res);
        return res;
    }
    
    private boolean findItinerary(String begin,Map<String,List<String>> graph,int size,List<String> res){
        List<String> list = graph.get(begin);
        res.add(begin);
        if(list.size() == 0){
            if(size == 0)
                return true;
            return false;
        }
        
        for(int i = 0;i<list.size();i++){
            String top = list.remove(i);
            if(findItinerary(top,graph,size-1,res))
                return true;
            list.add(i,top);
            res.remove(res.size()-1);
        }
        return false;
    }
}