class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        ArrayList<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            for (String row : rows) {
                boolean valid = true;
                for (char ch : lower.toCharArray()) {
                    if (row.indexOf(ch) == -1) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    result.add(word);
                    break;
                }
            }
        }
        return result.toArray(new String[0]);
    }
}