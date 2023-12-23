class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> isVisited = new HashSet<>();
        int xOrigin = 0;
        int yOrigin = 0;
        isVisited.add(String.valueOf(0) + "," + String.valueOf(0));
        
        for(int i = 0;i<path.length();i++){
            if(path.charAt(i) == 'N'){
                yOrigin += 1;
            }
            else if(path.charAt(i) == 'S'){
                 yOrigin -= 1;
            }
            else if(path.charAt(i) == 'E'){
                xOrigin += 1;
            }
            else if(path.charAt(i) == 'W'){
                 xOrigin -= 1;
            }
            
            if(isVisited.contains(String.valueOf(xOrigin) + "," + String.valueOf(yOrigin))){
            return true;
            }else{
                isVisited.add(String.valueOf(xOrigin) + "," + String.valueOf(yOrigin));
            }
        }
        
        
        return false;
    }
}