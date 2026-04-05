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

        LinkedList<Integer>[] bucket = new LinkedList[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int idx = entry.getValue();
            if(null == bucket[idx]) {
                bucket[idx] = new LinkedList<>();
            }
            bucket[idx].add(entry.getKey());
        }
        int x = 0;
        int[] arr = new int[k];
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(null == bucket[i]) {
                continue;
            }
            for(Integer ele : bucket[i]) {
                if(x == k) {
                    break;
                }
                arr[x] = ele;
                x++;
            }
            if(x == k) {
                break;
            }
        }
        return arr;
    }
}
