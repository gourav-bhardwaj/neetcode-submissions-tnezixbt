class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) {
            return nums;
        } else if (k == nums.length) {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < k; i++) {
                max = Math.max(max, nums[i]);
            }
            return new int[]{max};
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<Pair> queue = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            while(queue.size() > 0 && nums[i] > queue.getLast().element) {
                queue.removeLast();
            }
            queue.addLast(new Pair(i, nums[i]));
        }
        result[0] = queue.getFirst().element;
        for(int i = k; i < nums.length; i++) {
            if(queue.getFirst().index <= (i - k)) {
                queue.removeFirst();
            }
            while(queue.size() > 0 && nums[i] > queue.getLast().element) {
                queue.removeLast();
            }
            queue.addLast(new Pair(i, nums[i]));
            result[i - k + 1] = queue.getFirst().element;
        }

        return result;
    }
    class Pair {
        int index;
        int element;
        public Pair(int index, int element) {
            this.index = index;
            this.element = element;
        }
    }
}
