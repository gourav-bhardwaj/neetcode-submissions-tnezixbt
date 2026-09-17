class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        //-----Left Side-----
        left[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]); 
        }

        //-----Right Side-----
        right[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]); 
        }

        int trapWater = 0;
        for(int i = 1; i < height.length - 1; i++) {
            int tmp = (Math.min(left[i], right[i]) - height[i]);
            if(tmp > 0) {
                trapWater += tmp;
            }
        }

        return trapWater;
    }
}
