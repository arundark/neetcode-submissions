class Solution {
    List<String> result = new ArrayList<>();
    HashMap<Character, String> digitToChar = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return result;
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        dfs(0, "", digits);

        return result;
    }

    public void dfs(int index, String current, String digits) {
        if (current.length() == digits.length()) {
            result.add(current);
            return;
        }

        String characters = digitToChar.get(digits.charAt(index));

        for (char c : characters.toCharArray()) {
            dfs(index + 1, current + c, digits);
        }
    }
}
