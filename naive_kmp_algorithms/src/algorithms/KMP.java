package algorithms;

public class KMP {
    private String text;
    private String pattern;

// constructor creating and intializing variables

    public KMP(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }
// Performing the algorithm

    public void search() {
        int n = text.length();
        int m = pattern.length();

        int [] lps = computeLPS(pattern); // precompose the Lps Array

        int i = 0; // index for text
        int j = 0; // index for pattern

        while(i < n){
            if(pattern.charAt(j) == text.charAt(i)){ // if character match, we increment both pointer indexes
                i++;
                j++;
            }

            if(j==m){ // if we found fully match, then we print the index
                System.out.println("Pattern on index: " + (i-j) );
                j = lps[j-1]; // and after it continue search by moving pattern index to the last character match in lps
            }
            else if( i < n && pattern.charAt(j) != text.charAt(i) ){ // if we mismatch
                if(j != 0){
                    j = lps[j-1]; // again we move in pattern to the last matching lps
                }else{
                    i++; // just move forward
                }

            }
        }
    }


// building pls Array
    public int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m]; // array for lps

        int len = 0; // length of current prefix / suffix
        int i = 1; // we star from second char cause 1 symbol has no prefix or suffix to compare

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) { // if our char pattern[i] matches with symbol pattern[len]
                len++; // we increase our len
                lps[i] = len; // write to lps[i]
                i++; // move forward
            }else{
                if(len != 0){ // if doesnt matches
                    len = lps[len-1]; // we try to shorten our prefix, like go back to previous suffix
                    // we dont increment i cause we searching to matching len (may go back to 0)
                }else{
                    lps[i] = 0; // if there are no matches just write 0 to lps[i]
                    i++;
                }
            }
        }
        return lps; // return our longest prefix suffix array
    }


    // doing the same thing like a search method but preparing array for output
    public int[] searchToArray() {
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPS(pattern);

        java.util.List<Integer> result = new java.util.ArrayList<>();
        int i = 0, j = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
