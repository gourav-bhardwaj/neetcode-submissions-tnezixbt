class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        int startIdx = 97;
        Integer[] freqArr = new Integer[26];
        for(int i = 0; i < 26; i++) {
            freqArr[i] = 0;
        }

        for(int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i);
            freqArr[ascii - startIdx] += 1;
        }

        for(int i = 0; i < t.length(); i++) {
            int ascii = t.charAt(i);
            freqArr[ascii - startIdx] -= 1;
        }

        for(int i = 0; i < 26; i++) {
            if(freqArr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
