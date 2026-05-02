class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> result = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(result.size() > 0) {
                if((result.getLast() == '(' && s.charAt(i) == ')') 
                || (result.getLast() == '[' && s.charAt(i) == ']') 
                || (result.getLast() == '{' && s.charAt(i) == '}')) {
                    result.removeLast();
                } else {
                    result.addLast(s.charAt(i));
                }
            } else {
                result.addLast(s.charAt(i));
            }
        }
        return result.size() == 0;
    }
}
