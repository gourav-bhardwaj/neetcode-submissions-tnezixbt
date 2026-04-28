class Solution {
    public boolean isPalindrome(String s) {
        String ts = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int i = 0;
        int j = ts.length() - 1;
        while(i < j) {
            if(ts.charAt(i) != ts.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
