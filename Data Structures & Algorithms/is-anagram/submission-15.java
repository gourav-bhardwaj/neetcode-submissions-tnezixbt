class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Set<Character> processedSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            int count = 1;

            if(processedSet.contains(s.charAt(i))) {
                continue;
            }

            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }

            for(int k = 0; k < t.length(); k++) {
                if(s.charAt(i) == t.charAt(k)) {
                    count--;
                }
            }

            processedSet.add(s.charAt(i));

            if(count < 0 || count > 0) {
                return false;
            }
        }
        return true;
    }
}
