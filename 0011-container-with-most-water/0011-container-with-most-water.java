 class Solution {
    public int maxArea(int[] height) {
        int maxh=0;
        int l=0;
        int r=height.length-1;

        while(l<r){

            int min = Math.min(height[l], height[r]);
            int len = Math.abs(r-l);
            maxh = Math.max(maxh, (min*len));

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxh;
    }
}