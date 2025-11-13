# **Bonus Assignment String Matching — KMP**

## Overview:
In this project, I implemented the **Knuth–Morris–Pratt (KMP)** string search algorithm in Java and compared it with a simple **Naive search**.

---

## Requirements:

- Java 23+ installed on your system

- IDE (like IntelliJ IDEA, Eclipse) or terminal with javac / java

  - Needed input files in `docs/input` text.txt and pattern.txt 

---

## How KMP Works

The KMP algorithm first builds an **LPS (Longest Prefix Suffix)** array for the pattern.  
So it skips the part of the text by matching pattern itself. This allows the algorithm to avoid rechecking characters in the text that already matched if a mismatch occurs.

### 1 Building an LPS array (Longest Prefix Suffix)

- We go through a pattern of length m once.

 - Each character is processed a maximum of twice (sometimes the len index decreases, but it still goes forward).

 - It uses space to store array length of pattern

### 2 Search for a template in the text

 - We go through a text of length n once.

 - If there is a unmatch, we do not go back through the text (not like the naive algorithm).


### Total Complexety:
 - Working hours: O(n + m) = This is a linear complexity, so KMP is much faster than the naive algorithm (which can be O(n×m)).
- Space: O(m) for the LPS array = But Naive algorithm uses much less space:  O(1)

---

## Test Cases

I tested the algorithm on texts of different lengths:

| # | Text Type | Pattern | Found Indexes | Algorithm | Time (ms) |
|---|-----------|---------|---------------|----------|-----------|
| 1 | Short | ABABCABAB | 10 | KMP | 1.54 |
| 1 | Short | ABABCABAB | 10 | Naive | 2.13 |
| 2 | Medium | AABA | 0, 9, 12 | KMP | 0.06 |
| 2 | Medium | AABA | 0, 9, 12 | Naive | 0.08 |
| 3 | Long | TEST | 10, 29, 38, 116 | KMP | 0.06 |
| 3 | Long | TEST | 10, 29, 38, 116 | Naive | 0.11 |
| 4 | No match | BYE | — | KMP | 0.007 |
| 4 | No match | BYE | — | Naive | 0.012 |
| 5 | Repeated letters | AAA | 0–15 | KMP | 0.124 |
| 5 | Repeated letters | AAA | 0–15 | Naive | 0.535 |
| 6 | Realistic text (Lorem Ipsum) | the | 36, 96, 142, 296, 389, 404 | KMP | 0.115 |
| 6 | Realistic text (Lorem Ipsum) | the | 36, 96, 142, 296, 389, 404 | Naive | 0.215 |
| 7 | Very long (100k characters) | 501-character pattern | 99500 | KMP | 6.50 |
| 7 | Very long (100k characters) | 501-character pattern | 99500 | Naive | 6.91 |

---

## Example Output

Text: ABABDABACDABABCABAB
Pattern: ABABCABAB
Results:
Pattern on index: 10
Algorithm: KMP
Execution Time: 1.53940 ms


---

## Observations

- KMP is faster, especially on long or repetitive texts.
- For short texts, the difference is small.
- The naive search is simpler but slower on large data.
- KMP only uses extra memory for the LPS array, which is minimal.

---

## Repository Files

- `src/algorithms/KMP.java` — KMP implementation
- `src/test/KMPTest.java` — test cases
- `src/algorithms/Naive.java` — naive search 
- `src/tests/NaiveTest.java` — test cases
- `src/io/KMPFileRunner.java` — imports input files and return output file
- `docs/input/text.txt` — input file of text
- `docs/input/pattern.txt` — input file of pattern
- `docs/output/results.txt` — output file
- `README.md` — this file

---

## Author:
#### Student: Zhandos Gilazhev
#### Group: SE - 2439
#### Course: Design and Analysis of Algorithms


