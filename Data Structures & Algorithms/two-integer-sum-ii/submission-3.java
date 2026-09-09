class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j) {
            if(target < (numbers[i] + numbers[j])) {
                j--;
                continue;
            } else if(target > (numbers[i] + numbers[j])) {
                i++;
                continue;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{};
    }
}
