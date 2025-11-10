import algorithms.KMP;
import algorithms.Naive;

public class Main {
    public static void main(String[] args) {
        String text = "ABABABA";
        String pattern = "ABA";

        KMP strings = new KMP(text, pattern);

        int[] lps = strings.computeLPS(pattern);

        for (int i = 0; i < pattern.length(); i++) {
            System.out.print(pattern.charAt(i) + " " + lps[i]);
            System.out.println();
        }
        strings.search();
    }
}