class Solution {
    public int maxArea(int[] heights) {
        int maxContainer = Integer.MIN_VALUE;
        int i = 0;
        int j = heights.length - 1;
        while(i < j) {
            int width = (j - i);
            int height = Math.min(heights[i], heights[j]);
            int currentContainer = width * height;
            maxContainer = Math.max(maxContainer, currentContainer);
            if(heights[i] <= heights[j]) {
                i++;
            } else if(heights[i] >= heights[j]) {
                j--;
            }
        }
        return maxContainer;
    }
}