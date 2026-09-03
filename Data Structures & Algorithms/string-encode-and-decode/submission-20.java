class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) {
            return "";
        }
        StringJoiner joiner = new StringJoiner("~");
        for(String str : strs) {
            if(str.equals("")) {
                joiner.add("[BLANK]");
                continue;
            }
            joiner.add(str);
        }
        return joiner.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if(!str.isEmpty()) {
            for(String ele : str.split("~")) {
                if(ele.equals("[BLANK]")) {
                    result.add("");
                    continue;
                }
                result.add(ele);
            }
        }
        return result;
    }
}
