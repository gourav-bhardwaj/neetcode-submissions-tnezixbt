class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Set<Integer> setObj = new HashSet<>();
        List<Pair> pairList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(setObj.contains(nums[i])) {
                continue;
            }
            setObj.add(nums[i]);
            int counter = 0;
            for(int j = i; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    counter++;
                }
            }
            pairList.add(new Pair(nums[i], counter));
        }
        Collections.sort(pairList);
        int[] arr = new int[k];
        for(int j = 0; j < k; j++) {
            arr[j] = pairList.get(j).i;
        }
        return arr;
    }

    class Pair implements Comparable<Pair> {
        public int i;
        public int k;
        Pair(int i, int k) {
            this.i = i;
            this.k = k;
        }

        public int compareTo(Pair obj) {
            return obj.k - this.k;
        }

        public String toString() {
            return "[" + this.i + "," + this.k + "]";
        }
    }
}
