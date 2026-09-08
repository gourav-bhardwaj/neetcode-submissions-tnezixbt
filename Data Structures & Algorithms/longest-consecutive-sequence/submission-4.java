class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return 1;
        } else {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for(int i = 0; i < nums.length; i++) {
                heap.add(nums[i]);
            }
            
            Set<Integer> set = new HashSet<>();
            int maxLength = Integer.MIN_VALUE;
            int longConsecutiveSeq = 1;
            int prevElement = heap.remove();
            set.add(prevElement);
            while(!heap.isEmpty()) {
                int currentElement = heap.remove();
                if(set.contains(currentElement)) {
                    continue;
                }
                if((currentElement - prevElement) == 1) {
                    longConsecutiveSeq++;
                } else {
                    maxLength = Math.max(maxLength, longConsecutiveSeq);
                    longConsecutiveSeq = 1;
                }
                prevElement = currentElement;
                set.add(prevElement);
            }
            maxLength = Math.max(maxLength, longConsecutiveSeq);
            return maxLength;
        }
    }
}
