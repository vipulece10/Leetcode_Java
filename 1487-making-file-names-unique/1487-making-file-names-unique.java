class Solution {
    public String[] getFolderNames(String[] names) {
        /*names = ["gta","gta(1)","gta","avalon"]
        map = ["gta"-> 1,gta(1)->1,]
        
        */
        String[] ans = new String[names.length];
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<names.length;i++){
            if(map.containsKey(names[i])){
                int count = map.get(names[i]);
                String fileName = names[i] + "(" + String.valueOf(count) + ")";
                while(map.containsKey(fileName)){
                    count++;
                    fileName = names[i] + "(" + String.valueOf(count) + ")";
                }
                ans[i] = fileName;
                map.put(names[i],count+1);
                map.put(fileName,1);
            }else{
                ans[i] = names[i];
                map.put(names[i],1);
            }
        }
        return ans;
    }
}