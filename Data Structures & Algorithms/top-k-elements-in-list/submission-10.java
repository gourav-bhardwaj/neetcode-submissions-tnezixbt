class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int tempK = 0;
        Map<Integer, Integer> numFreq = new LinkedHashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numFreq.put(nums[i], numFreq.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> orderElement = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            orderElement.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            orderElement.get(entry.getValue() - 1).add(entry.getKey());
        }

        int m = k - 1;
        int[] result = new int[k];
        for(int i = orderElement.size() - 1; i >= 0; i--) {
            for(int j = 0; j < orderElement.get(i).size(); j++) {
                if(m < 0) {
                    break;
                }
                result[m] = orderElement.get(i).get(j);
                m--;
            }
            if(m < 0) {
                break;
            }
        }

        return result;
    }
}
