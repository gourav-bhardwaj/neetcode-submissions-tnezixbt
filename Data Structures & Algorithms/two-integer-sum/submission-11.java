class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> setObj = new HashMap<>();
        setObj.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++) {
            if(setObj.containsKey(target - nums[i])) {
                return new int[]{setObj.get(target - nums[i]), i};
            }
            setObj.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
