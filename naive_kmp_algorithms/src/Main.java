import algorithms.KMP;
import algorithms.Naive;

public class Main {
    public static void main(String[] args) {

        // Short string
        System.out.println("Short test: ");
        KMP kmp1 = new KMP("nano banana", "ana");
        kmp1.search();


        // Medium string
        System.out.println("\nMedium test: ");
        KMP kmp2 = new KMP("abababababab", "ababa");
        kmp2.search();


        // Long string
        System.out.println("\nLong test: ");
        String longText = "a".repeat(100000) + "b";
        String longPattern = "a".repeat(500) + "b";
        KMP kmp3 = new KMP(longText, longPattern);
        kmp3.search();
    }
}