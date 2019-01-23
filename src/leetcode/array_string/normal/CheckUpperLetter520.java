package leetcode.array_string.normal;

public class CheckUpperLetter520 {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.equals("") || word.length() == 1) {
            return true;
        }
        boolean first = isUp(word.charAt(0));
        boolean second = isUp(word.charAt(1));
        if (!first && second) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            boolean isUp = isUp(word.charAt(i));
            if (!(first && second && isUp || first && !second && !isUp || !first && !second && !isUp)) {
                return false;
            }
        }
        return true;
    }

    public boolean isUp(char c) {
        return c <= 'Z' && c >= 'A';
    }
}
