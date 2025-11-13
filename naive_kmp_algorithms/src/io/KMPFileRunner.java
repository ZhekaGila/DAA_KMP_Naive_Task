package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import algorithms.KMP;

public class KMPFileRunner {

    public static void main(String[] args) {
        String textFile = "naive_kmp_algorithms/docs/input/text.txt";       // file with text
        String patternFile = "naive_kmp_algorithms/docs/input/pattern.txt"; // file with pattern

        String outputFile = "naive_kmp_algorithms/docs/output/results.txt";  // output file

        try {
            // reading the input files
            String text = new String(Files.readAllBytes(Paths.get(textFile)));
            String pattern = new String(Files.readAllBytes(Paths.get(patternFile)));

            // preparing the file for output
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            writer.write("Text: " + text + "\n");
            writer.write("Pattern: " + pattern + "\n");
            writer.write("Results:\n");

            long startTime = System.nanoTime();
            KMP kmp = new KMP(text, pattern);

            int[] matches = kmp.searchToArray(); // running the algorithm
            long endTime = System.nanoTime();

            if (matches.length == 0) {
                writer.write("No matches found.\n");
            } else {
                for (int index : matches) {
                    writer.write("Pattern on index: " + index + "\n");
                }
            }

            double durationMs = (endTime - startTime) / 1_000_000.0;
            writer.write("Algorithm: KMP\n");
            writer.write(String.format("Execution Time: %.5f ms%n", durationMs));

            writer.close();
            System.out.println("Results written to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
