class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] freqArray = new int[26];

        for(int i = 0; i < s.length(); i++) {
            freqArray[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            freqArray[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < freqArray.length; i++) {
            if(freqArray[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
