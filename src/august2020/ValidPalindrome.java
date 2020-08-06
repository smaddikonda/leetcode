package august2020;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String inputs[] = new String[]{
                "A man, a plan, a canal: Panama",
                "race a car",
                "",
                "a",
                "aa",
                "aaa",
                "aab",
                "aba",
                "baa",
                "p     a ap",
                "?//123021"
        };
        for (String input : inputs) {
            System.out.println(input + "\t\t" + vp.isPalindrome(input));
        }
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        int fIndex = 0;
        int rIndex = s.length() - 1;
        s = s.toLowerCase();
        while (fIndex < rIndex) {
            char fChar = s.charAt(fIndex);
            char rChar = s.charAt(rIndex);
            if (!Character.isLetterOrDigit(fChar)) {
                fIndex++;
                continue;
            }
            if (!Character.isLetterOrDigit(rChar)) {
                rIndex--;
                continue;
            }
            if (fChar != rChar) {
                return false;
            }
            fIndex++;
            rIndex--;
        }
        return true;
    }
}
