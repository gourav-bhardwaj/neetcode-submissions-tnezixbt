class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            prefix[i] = (i == 0) ? nums[i] : (prefix[i - 1] * nums[i]);
            suffix[(nums.length - 1) - i] = ((nums.length - i) == nums.length) ? nums[nums.length - 1] : suffix[nums.length - i] * nums[(nums.length - 1) - i];
        }
        int[] result = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            int prefixIdx = (i - 1);
            int suffixIdx = (i + 1);
            if(prefixIdx < 0) {
                result[i] = suffix[suffixIdx];
            } else if(suffixIdx >= nums.length) {
                result[i] = prefix[prefixIdx];
            } else {
                result[i] = (prefix[prefixIdx] * suffix[suffixIdx]);
            }
        }

        return result;
    }
}  
