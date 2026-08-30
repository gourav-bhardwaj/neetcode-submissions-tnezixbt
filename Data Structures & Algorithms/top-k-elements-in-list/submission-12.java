class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
        int[] freqArr = new int[maxValue - minValue + 1];
        for(int i = 0; i < nums.length; i++) {
            freqArr[nums[i] - minValue]++;
        }

        int maxFreq = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < freqArr.length; i++) {
            if(freqArr[i] == 0) {
                continue;
            }
            maxFreq = Math.max(maxFreq, freqArr[i]);
            map.putIfAbsent(freqArr[i], new ArrayList<>());
            map.get(freqArr[i]).add(minValue + i);
        }

        int j = 0;
        int[] result = new int[k];
        while(maxFreq >= 1) {
            if(map.containsKey(maxFreq)) {
                for(Integer num : map.get(maxFreq)) {
                    if(j == k) {
                        break;
                    }
                    result[j] = num;
                    j++;
                }
            }
            maxFreq--;
        }

        return result;
    }
}
