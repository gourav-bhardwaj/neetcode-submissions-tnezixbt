class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftNums = new int[nums.length];
        int[] rightNums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                leftNums[i] = nums[i];
                continue;
            }
            leftNums[i] = nums[i] * leftNums[i - 1];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == (nums.length - 1)) {
                rightNums[i] = nums[i];
                continue;
            }
            rightNums[i] = nums[i] * rightNums[i + 1];
        }

        int[] result = new int[nums.length];
        int i = -1;
        int j = 1;
        int idx = 0;
        while(j <= nums.length) {
            if(i == -1) {
                result[idx] = rightNums[j];
            } else if(j == nums.length) {
                result[idx] = leftNums[i];
            } else {
                result[idx] = (leftNums[i] * rightNums[j]);
            }
            idx++;
            i++;
            j++;
        }
        System.gc();
        return result;
    }
}  
