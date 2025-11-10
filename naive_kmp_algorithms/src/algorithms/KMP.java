package algorithms;

public class KMP {
    private String text;
    private String pattern;

    public KMP(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    public void search() {
        int n = text.length();
        int m = pattern.length();

        int [] lps = computeLPS(pattern);

        int i = 0;
        int j = 0;

        while(i < n){
            if(pattern.charAt(j) == text.charAt(i)){
                i++;
                j++;
            }

            if(j==m){
                System.out.println("Pattern on index: " + (i-j) );
                j = lps[j-1];
            }
            else if( i < n && pattern.charAt(j) != text.charAt(i) ){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }

            }
        }
    }

    public int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
