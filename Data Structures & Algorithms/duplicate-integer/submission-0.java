class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> inputSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!inputSet.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}