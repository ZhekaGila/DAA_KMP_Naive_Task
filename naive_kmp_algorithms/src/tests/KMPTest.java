package tests;

import algorithms.KMP;

public class KMPTest {
    public static void main(String[] args) {
        testCase("ABABDABACDABABCABAB", "ABABCABAB");

        testCase("AABAACAADAABAABA", "AABA");

        testCase("THIS IS A TEST TEXT WHERE WE TEST THE TEST PATTERN IN A LONGER CONTEXT IDK TUDA SUDA MILIONER, LIKA SUPER MEGA TEXT TEST.", "TEST");

        testCase("HELLO WORLD", "BYE");

        testCase("AAAAAAAAAAAAAAAAAA", "AAA");

        testCase("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "the");

        String longText = "a".repeat(100000) + "b";
        String longPattern = "a".repeat(500) + "b";
        testCase(longText, longPattern);

    }

    private static void testCase(String text, String pattern) {
        System.out.println("--------------------------------------------------");
        if(text.length() < 1500){
            System.out.println("Text:    " + text);
            System.out.println("Pattern: " + pattern);

        }else{
            System.out.println("Text: Super long " + text.length()+ " symbols" );
            System.out.println("Pattern: Just long " +  pattern.length()+ " symbols" );
        }
        System.out.println("Results:");
        long startTime = System.nanoTime();
        KMP kmp = new KMP(text.toLowerCase(), pattern.toLowerCase());
        kmp.search();
        long endTime = System.nanoTime();

        System.out.println("Algorithm: KMP");
        double durationMs = (endTime - startTime) / 1_000_000.0;
        System.out.printf("Execution Time: %.5f ms%n", durationMs);
        System.out.println();
    }
}
