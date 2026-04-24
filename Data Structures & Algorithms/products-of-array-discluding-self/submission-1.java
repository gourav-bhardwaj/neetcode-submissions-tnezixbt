class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] larr = new int[nums.length];
        int[] rarr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                larr[i] = nums[i];
                continue;
            }
            larr[i] = larr[i - 1] * nums[i];
        }
        
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == (nums.length - 1)) {
                rarr[i] = nums[i];
                continue;
            }
            rarr[i] = rarr[i + 1] * nums[i]; 
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int l = (i - 1) >= 0 ? larr[i - 1] : 1;
            int r = (i + 1) < nums.length ? rarr[i + 1] : 1;
            result[i] = l * r;
        }

        return result;

    }
}  
