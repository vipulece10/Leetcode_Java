class Solution {
    public int compareVersion(String version1, String version2) {
        
        String [] version1arr = version1.split("\\.");
        String [] version2arr = version2.split("\\.");
        int n = version1arr.length;
        int m = version2arr.length;
        
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            
         int revision1 = Integer.parseInt(version1arr[i]);
         int revision2 = Integer.parseInt(version2arr[j]);
            System.out.println(revision1);
            System.out.println(revision2);
            if(revision1 < revision2)
                return -1;
            else if(revision1 > revision2)
                return 1;
          
          i++;
          j++;
        }
        
        while(i < n){
            int revision1 = Integer.parseInt(version1arr[i]);
            if(revision1 > 0)
                return 1;
            i++;
        }
        
        while(j < m){
            int revision2 = Integer.parseInt(version2arr[j]);
            if(revision2 > 0)
                return -1;
            j++;
        }
        
        return 0;        
    }
}