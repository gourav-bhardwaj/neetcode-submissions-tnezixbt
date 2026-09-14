class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> result = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int tripletSum = nums[i] + nums[j] + nums[k];
                if(tripletSum == 0) {
                    int hashCode = Arrays.hashCode(new int[]{nums[i], nums[j], nums[k]});
                    result.put(hashCode, Arrays.asList(nums[i], nums[j], nums[k]));
                }

                if(tripletSum < 0) {
                    j++;
                } else if(tripletSum > 0) {
                    k--;
                } else {
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(result.values());
    }
}
