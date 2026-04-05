class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        queue.addAll(map.entrySet());
        int[] arr = new int[k];
        for(int j = 0; j < k; j++) {
            arr[j] = queue.poll().getKey();
        }
        return arr;
    }
}
