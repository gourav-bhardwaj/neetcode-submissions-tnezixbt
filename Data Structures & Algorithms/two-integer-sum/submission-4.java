class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapObj = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(mapObj.containsKey(target - nums[i])) {
                return new int[]{mapObj.get(target - nums[i]), i};
            }
            mapObj.put(nums[i], i);
        }
        return new int[]{};
    }
}
