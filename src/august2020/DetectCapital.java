package august2020;

public class DetectCapital {
    public static void main(String[] args) {
        DetectCapital dc = new DetectCapital();
        String[] inputs = new String[]{
                "mL", "", "1", "12", "1A", "1a", "1Ab", "1AB", "1A2", "a", "A", "a1", "A1", "a1b", "A1b", "a1B", "A1B",
                "Ab", "AB", "Abc", "ABc", "ABC", "abc"
        };
        for (String input : inputs) {
            System.out.println(input + "\t\t" + dc.detectCapitalUse(input));
        }
    }

    public boolean detectCapitalUse(String word) {
        boolean isValid = true;
        if (word.length() == 0) return false;
        if ((word.length() == 1) && Character.isLetter(word.charAt(0))) {
            return true;
        }
        int index = 0;
        boolean restCap = false;
        while (isValid && index < word.length()) {
            char ch = word.charAt(index);
            if (!Character.isLetter(ch)) {
                return false;
            }
            if (index == 1) {
                restCap = Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(ch);
            }
            if (index >= 1) {
                isValid = !(restCap ^ Character.isUpperCase(ch));
            }
            index++;
        }
        return isValid;
    }
}
