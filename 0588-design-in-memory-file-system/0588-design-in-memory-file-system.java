/*
https://leetcode.com/problems/design-in-memory-file-system/discuss/103331/Java-Solution-File-class

This is similar to Implement Linux Find asked in Amazon's interview Question(The code is in the comment of above link)
*/
class FileSystem {
    class File{
        boolean isFile = false;
        HashMap<String,File> subDir = new HashMap<>();
        String content = "";
        
    }

    File root;
    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        File t = root;
        List<String> result = new ArrayList<>();
        if(!path.equals("/")){
            String[] dirs = path.split("/");
            for(int i =1;i< dirs.length;i++){
                t = t.subDir.get(dirs[i]);
            }
            
            if(t.isFile){
                result.add(dirs[dirs.length - 1]);
                return result;
            }
        }
         result.addAll(t.subDir.keySet());
         Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
        File t = root;
        String[] dirs = path.split("/");
        for(int i =1;i<dirs.length;i++){
            if(!t.subDir.containsKey(dirs[i])){
                t.subDir.put(dirs[i],new File());
            }
            t = t.subDir.get(dirs[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        File t = root;
        String[] dirs = filePath.split("/");
        for(int i = 1;i< dirs.length -1;i++){
            t = t.subDir.get(dirs[i]);
        }
        if(!t.subDir.containsKey(dirs[dirs.length - 1])){
            t.subDir.put(dirs[dirs.length - 1],new File());
        }
        t = t.subDir.get(dirs[dirs.length - 1]);
        t.isFile = true;
        t.content = t.content + content;
    }
    
    public String readContentFromFile(String filePath) {
        File t = root;
        String[] dirs = filePath.split("/");
        for(int i = 1;i< dirs.length;i++){
            t = t.subDir.get(dirs[i]);
        }
        return t.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */