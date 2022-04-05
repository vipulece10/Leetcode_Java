class Solution {
    public int maxArea(int[] height) {
        
        int low=0;
        int high=height.length-1;
        int max_area=Integer.MIN_VALUE;
        while(low<high){
            max_area=Math.max(max_area,Math.min(height[low],height[high])*(high-low));
            if(height[low]<height[high])
                low++;
            else
                high--;
        }
        return max_area;
        
    }
}