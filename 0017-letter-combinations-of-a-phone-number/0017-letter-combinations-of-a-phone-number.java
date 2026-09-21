class Solution {
    String[] keypad = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        backtrack(digits, 0, "");
        return ans;
    }
    void backtrack(String digits, int index, String current) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = keypad[digit];
        for (char ch : letters.toCharArray()) {
            backtrack(
                digits,
                index + 1,
                current + ch
            );
        }
    }
}