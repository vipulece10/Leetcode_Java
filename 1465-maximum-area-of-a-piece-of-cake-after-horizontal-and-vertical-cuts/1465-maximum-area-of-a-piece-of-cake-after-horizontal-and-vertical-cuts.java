class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        int maxhorizontal = Integer.MIN_VALUE;
        int maxvertical = Integer.MIN_VALUE;
       // long maxarea = 0;
        int horizontallength = horizontalCuts.length - 1;
        int verticallength = verticalCuts.length - 1;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        maxhorizontal = horizontalCuts[0] - 0;
        maxvertical = verticalCuts[0]-0;
        
        if(horizontalCuts.length > 1){
            for(int i =1;i<horizontalCuts.length;i++){
                maxhorizontal = Math.max(maxhorizontal,horizontalCuts[i]-horizontalCuts[i-1]);
            }
            
        }
        
        maxhorizontal = Math.max(maxhorizontal,h-horizontalCuts[horizontallength]);
        
        if(verticalCuts.length > 1){
            for(int i =1;i<verticalCuts.length;i++){
                maxvertical = Math.max(maxvertical,verticalCuts[i]-verticalCuts[i-1]);
            }
            
        }
        
        maxvertical = Math.max(maxvertical,w-verticalCuts[verticallength]);
        
        //System.out.println(maxvertical);
        //System.out.println(maxhorizontal);
        
       long maxarea = 1L * maxhorizontal * maxvertical;
        
        //System.out.println(maxarea);
        
        return (int) (maxarea % 1000000007);
    }
}