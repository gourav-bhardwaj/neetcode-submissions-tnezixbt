class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(stack.size() > 0){
                if(stack.getLast() == '[' && s.charAt(i) == ']') {
                    stack.removeLast();
                } else if(stack.getLast() == '(' && s.charAt(i) == ')') {
                    stack.removeLast();
                } else if(stack.getLast() == '{' && s.charAt(i) == '}') { 
                    stack.removeLast();
                } else {
                    stack.addLast(s.charAt(i));
                }
            } else {
                stack.addLast(s.charAt(i));
            }
        }
        return stack.size() == 0;
    }
}
